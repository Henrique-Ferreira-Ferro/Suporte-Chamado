package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.ModuloConexao;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtNome;
	private static JPasswordField txtSenha;
	private static JLabel lblEntrar;
	

	static Connection con = null;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		
		con = ModuloConexao.conector();

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(79, 79, 253));
		panel.setBackground(new Color(79, 79, 253));
		panel.setBounds(0, 0, 401, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Chamado");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(116, 34, 174, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\henri\\OneDrive\\Documentos\\Documents\\Estudo_VsC\\Java\\Suporte Chamados\\src\\recursos\\icone azul_resized.jfif"));
		lblNewLabel_1.setBounds(69, 90, 259, 294);
		panel.add(lblNewLabel_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(441, 160, 62, 26);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(441, 229, 72, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLogin.setBounds(556, 82, 72, 26);
		contentPane.add(lblLogin);
		
		txtNome = new JTextField();
		txtNome.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtNome.setBackground(new Color(228, 228, 228));
		txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNome.setForeground(new Color(0, 0, 0));
		txtNome.setBounds(441, 193, 283, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSenha.setBackground(new Color(228, 228, 228));
		txtSenha.setBounds(441, 265, 283, 26);
		contentPane.add(txtSenha);
		
		JButton btnEsqueciSenha = new JButton("Esqueci a senha");
		btnEsqueciSenha.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEsqueciSenha.setForeground(new Color(255, 255, 255));
		btnEsqueciSenha.setBackground(new Color(79, 79, 253));
		btnEsqueciSenha.setFont(new Font("Arial", Font.PLAIN, 10));
		btnEsqueciSenha.setBounds(607, 313, 117, 21);
		contentPane.add(btnEsqueciSenha);
		
		JRadioButton rbMostraSenha = new JRadioButton("Mostrar senha");
		
		
		
		rbMostraSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbMostraSenha.isSelected()) {
					txtSenha.setEchoChar((char)0);
				}else {
					txtSenha.setEchoChar('*');
				}
			}
		});
		rbMostraSenha.setFont(new Font("Arial", Font.BOLD, 12));
		rbMostraSenha.setBounds(441, 313, 122, 21);
		contentPane.add(rbMostraSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(logar() == true) {
					setVisible(false);
				}
				
			}
		});
		btnEntrar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEntrar.setBackground(new Color(79, 79, 253));
		btnEntrar.setBounds(441, 410, 283, 26);
		contentPane.add(btnEntrar);
		
		JLabel lblNoTemUma = new JLabel("Não tem uma conta ?");
		lblNoTemUma.setForeground(Color.BLACK);
		lblNoTemUma.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNoTemUma.setBounds(441, 356, 122, 26);
		contentPane.add(lblNoTemUma);
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCriarConta.setForeground(Color.WHITE);
		btnCriarConta.setFont(new Font("Arial", Font.PLAIN, 10));
		btnCriarConta.setBackground(new Color(79, 79, 253));
		btnCriarConta.setBounds(621, 361, 103, 21);
		contentPane.add(btnCriarConta);
		
		lblEntrar = new JLabel("");
		lblEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/recursos/dbok.png")));
		lblEntrar.setBounds(441, 457, 38, 46);
		contentPane.add(lblEntrar);
		
		
		
		if(con != null) {
			lblEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/recursos/dbok.png")));
		}else {
			lblEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/recursos/dberror.png")));
		}
		
		
		
	}
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}

	public JLabel getLblEntrar() {
		return lblEntrar;
	}

	public void setLblEntrar(JLabel lblEntrar) {
		this.lblEntrar = lblEntrar;
	}

	public static boolean logar() {
		String sql = "SELECT * FROM usuario WHERE name = ? AND senha = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtNome.getText());
			pstm.setString(2, String.valueOf(txtSenha.getText()));
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Erro",JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no SQL", "Erro",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	
	}
	
	
}
