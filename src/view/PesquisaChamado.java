package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; // Importação correta para java.sql.Date
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import dao.ModuloConexao;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PesquisaChamado extends JInternalFrame {

	private JDateChooser dateChooser;
	private static final long serialVersionUID = 1L;
	private JTable tblChamado;
	private JLabel lblPesquisarPorStatus;

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private JScrollPane scrollPane;

	
	private JComboBox boxStatusPesqui ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaChamado frame = new PesquisaChamado();
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
	public PesquisaChamado() {
		setTitle("Pesquisar Chamado");
		setFrameIcon(new ImageIcon(PesquisaChamado.class.getResource("/recursos/pesquisa chamado.png")));

		setBounds(0, 0, 695, 640);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Pesquisar por Data");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 89, 128, 13);
		getContentPane().add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 153, 621, 411);
		getContentPane().add(scrollPane);

		tblChamado = new JTable();
		scrollPane.setViewportView(tblChamado);

		lblPesquisarPorStatus = new JLabel("Pesquisar por Status");
		lblPesquisarPorStatus.setFont(new Font("Arial", Font.BOLD, 13));
		lblPesquisarPorStatus.setBounds(344, 89, 136, 13);
		getContentPane().add(lblPesquisarPorStatus);

		boxStatusPesqui = new JComboBox();
		boxStatusPesqui.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				pesquisaStatus();
			}
		});
		boxStatusPesqui.setFont(new Font("Arial", Font.BOLD, 14));
		boxStatusPesqui.setModel(new DefaultComboBoxModel(new String[] { "Aberto", "Em andamento", "Fechado" }));
		boxStatusPesqui.setBounds(490, 85, 136, 21);
		getContentPane().add(boxStatusPesqui);

		/*
		 * Nota: O trecho que envolve o calendario
		 */
		java.util.Date date = new java.util.Date();
		dateChooser = new JDateChooser();
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() != null) {
					pesquisaData();
				}
			}
		});

		dateChooser.getCalendarButton().setFont(new Font("Arial", Font.BOLD, 14));
		dateChooser.setBounds(29, 113, 200, 21);
		dateChooser.setDate((date));
		dateChooser.setDateFormatString("yyyy/MM/dd");
		getContentPane().add(dateChooser);

	}

	/*
	 * Os metodos abaixo faram pesquisas no banco em chamados
	 */

	public void pesquisaData() {
		

		String sql = "SELECT idCha as ID, tituloCha as Titulo, categoriaCha as Categoria, horaCricha as Data, anexoCha as Anexo,statusCha as Status,"
				+ " comentarioCha as Comentario, descricaoCha as Descricao, idUsu FROM chamado WHERE horaCricha = ?";

		con = ModuloConexao.conector();
		try {
				Date dataSql = new Date(dateChooser.getDate().getTime());
				pstm = con.prepareStatement(sql);
				pstm.setDate(1, dataSql);
				rs = pstm.executeQuery();
				tblChamado.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar realizar a pesquisa!");
		}
	}

	public void pesquisaStatus() {
		
		String sql = "SELECT idCha as ID\r\n"
				+ ", tituloCha as Titulo, categoriaCha as Categoria,horaCriCha as Hora,"
				+ "anexoCha as Anexo,statusCha as status,comentarioCha as Coment,descricaoCha as Des,idUsu FROM chamado WHERE statusCha = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, boxStatusPesqui.getSelectedItem().toString());
			rs = pstm.executeQuery();
			tblChamado.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar pelo chamado: "+ e);
		}
	}
	
	
	
}
