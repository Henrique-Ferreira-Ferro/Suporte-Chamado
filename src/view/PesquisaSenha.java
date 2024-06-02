package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.ModuloConexao;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class PesquisaSenha extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tblSenha;
	private JTextField txtPesquisa;
	private JScrollPane scrollPane;
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaSenha frame = new PesquisaSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PesquisaSenha() {
		setTitle("Pesquisar Senha");
		setFrameIcon(new ImageIcon(PesquisaSenha.class.getResource("/recursos/PesquisaSenha.png")));
		setBounds(0, 0, 695, 640);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 145, 625, 456);
		getContentPane().add(scrollPane);
		
		tblSenha = new JTable();
		tblSenha.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Origem", "Email", "Senha", "Login", "Descricao", "IDUsuario"
			}
		));
		scrollPane.setViewportView(tblSenha);
		
		JLabel lblPesquisaPorOrigem = new JLabel("Pesquisa por origem");
		lblPesquisaPorOrigem.setFont(new Font("Arial", Font.BOLD, 14));
		lblPesquisaPorOrigem.setBounds(24, 87, 155, 13);
		getContentPane().add(lblPesquisaPorOrigem);
		
		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarPorOrigem();
			}
		});
		txtPesquisa.setBounds(184, 84, 190, 19);
		getContentPane().add(txtPesquisa);
		txtPesquisa.setColumns(10);

	}
	
	/*
	 * Metodos que buscam no banco se encontram abaixo!
	 */
	
	private void pesquisarPorOrigem() {
		//SELECT idSen, origemSen, emailSen, senhaSen, loginSen, descricaoSen, idUsu FROM senhasGerais WHERE origemSen LIKE 'mer%'
		
		String sql = "SELECT idSen as ID, origemSen as Origem , emailSen as Email, senhaSen as Senha, loginSen as Login,"
				+ " descricaoSen as Descricao, idUsu as IDUsuario FROM senhasGerais WHERE origemSen LIKE ?";
		
		con = ModuloConexao.conector();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtPesquisa.getText() + "%");
			rs = pstm.executeQuery();
			tblSenha.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar pesquisar! "+ e);
		}
		
		
		
	}
	
	
}
