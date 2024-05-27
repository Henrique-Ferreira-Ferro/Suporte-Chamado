package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.ModuloConexao;

public class CriaContaTemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JComboBox boxDepart;

	private Connection con;
	private PreparedStatement pstm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaContaTemp frame = new CriaContaTemp();
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
	public CriaContaTemp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CriaContaTemp.class.getResource("/recursos/cadastroUsuario.png")));
		setTitle("Cadastro de Usuario");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(39, 209, 56, 13);
		contentPane.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(102, 209, 358, 19);
		contentPane.add(txtNome);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(39, 250, 56, 13);
		contentPane.add(lblNewLabel_2_1);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBounds(102, 250, 358, 19);
		contentPane.add(txtSenha);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(39, 291, 56, 13);
		contentPane.add(lblNewLabel_2_2);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(102, 291, 358, 19);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Login");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBounds(39, 335, 56, 19);
		contentPane.add(lblNewLabel_2_3_1);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLogin.setColumns(10);
		txtLogin.setBounds(102, 335, 358, 19);
		contentPane.add(txtLogin);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Departamento");
		lblNewLabel_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1.setBounds(39, 379, 108, 19);
		contentPane.add(lblNewLabel_2_3_1_1);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(logicaVerificacao() == true) {
					salvar();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro, preencha corretamente os campos");
				}
				
				
				
			}

			
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCadastrar.setBackground(new Color(79, 79, 253));
		btnCadastrar.setBounds(139, 448, 283, 26);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nota: ");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(91, 127, 33, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("Na sua criação de conta, será atribuido a você o nivel");
		lblNewLabel_2_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3_1_1_1.setBounds(127, 124, 310, 19);
		contentPane.add(lblNewLabel_2_3_1_1_1);
		
		JLabel lblNewLabel = new JLabel("usuario, podendo apenas abrir chamados. Solicite mais");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(91, 143, 339, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("permissões a um tecnico");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(91, 161, 154, 13);
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 558, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(231, 29, 93, 32);
		panel.add(lblCadastro);
		lblCadastro.setForeground(new Color(255, 255, 255));
		lblCadastro.setFont(new Font("Arial", Font.BOLD, 20));
		
		boxDepart = new JComboBox();
		boxDepart.setModel(new DefaultComboBoxModel(new String[] {"recursos humanos", "comercial", "operacional", "financeiro", "juridico"}));
		boxDepart.setFont(new Font("Arial", Font.PLAIN, 13));
		boxDepart.setBounds(157, 379, 160, 21);
		contentPane.add(boxDepart);
	}
	
	
	private boolean logicaVerificacao() {
		
		if(validarEmail() && validaUsuario() && validaSenha() && validaLogin()) {
			return true;
		}else {
			return false;
		}
	}


	private boolean validaLogin() {
		String login = txtLogin.getText();
		if(login.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo login vaziu, pois é importante", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}

	private boolean validaSenha() {
		String senha = txtSenha.getText();
		if(senha.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo senha vaziu, pois é importante", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			try {
				Integer.parseInt(txtSenha.getText());
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Não insira letras na senha e não coloque senhas grandes!");
			}
			return true;
		}
	}

	private boolean validaUsuario() {
		String usuario = txtNome.getText();
		if(usuario.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo nome vaziu, pois é importante", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}

	private boolean validarEmail() {
		String email = txtEmail.getText();
		String verificaRegx = "^(.+)@(\\S+)$"; 
		Pattern padrao = Pattern.compile(verificaRegx);
		Matcher cheque = padrao.matcher(email);
		if(email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo email vaziu, preencha corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(!cheque.matches()) {
			JOptionPane.showMessageDialog(null, "Insira um email valido, caso contrario o cadastro não será efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * Inserir no banco de dados
	 */
	
	public void salvar() {
		//INSERT INTO usuario (nomeUsu, senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart)

		String sql = "INSERT INTO usuario(nomeUsu,senhaUsu,emailUsu,nivelUsu,loginUsu,idDepart) VALUES(?,?,?,?,?,?)";
		con = ModuloConexao.conector();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtNome.getText());
			pstm.setInt(2, Integer.parseInt(txtSenha.getText()));
			pstm.setString(3, txtEmail.getText());
			pstm.setString(4, "usuario"); //Para os que criarem a propria conta será dado a eles o nivel de usuario!
			pstm.setString(5, txtLogin.getText());
			int depart = boxDepart.getSelectedIndex() + 2;
			pstm.setInt(6, depart);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar no banco!" + e);
		}
		
		
		
		
	}
	
	
}
