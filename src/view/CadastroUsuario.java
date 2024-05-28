package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ModuloConexao;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class CadastroUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private JTextField txtLogin;

	private JComboBox boxDepart;
	private JComboBox boxLevel;
	
	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public CadastroUsuario()  {
		setTitle("Cadastro Usuario");
		setFrameIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/cadastroUsuario.png")));
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setBounds(0, 0, 693, 640);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisa");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 38, 80, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(70, 210, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(70, 249, 56, 13);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setBounds(125, 35, 366, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(70, 290, 56, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(70, 331, 56, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nivel");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(70, 374, 56, 13);
		getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Login");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBounds(70, 422, 56, 19);
		getContentPane().add(lblNewLabel_2_3_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_1.setBounds(133, 210, 45, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(133, 249, 358, 19);
		getContentPane().add(txtNome);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBounds(133, 290, 358, 19);
		getContentPane().add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 331, 358, 19);
		getContentPane().add(txtEmail);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLogin.setColumns(10);
		txtLogin.setBounds(133, 422, 358, 19);
		getContentPane().add(txtLogin);
		
		boxLevel = new JComboBox();
		boxLevel.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Usuario"}));
		boxLevel.setFont(new Font("Arial", Font.PLAIN, 13));
		boxLevel.setBounds(136, 371, 142, 21);
		getContentPane().add(boxLevel);
		
		JLabel btnSalvar = new JLabel("");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(logicaVerificacao() == true) {
					salvarUsuario();
					limpar();
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro, preencha corretamente os campos");
				}
				
			}
			
		});
		btnSalvar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(80, 515, 66, 66);
		getContentPane().add(btnSalvar);
		
		JLabel btnGravar = new JLabel("");
		btnGravar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/alterar.png")));
		btnGravar.setBounds(275, 515, 66, 66);
		getContentPane().add(btnGravar);
		
		JLabel btnDeletar = new JLabel("");
		btnDeletar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/excluir.png")));
		btnDeletar.setBounds(464, 495, 66, 86);
		getContentPane().add(btnDeletar);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Departamento");
		lblNewLabel_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1.setBounds(70, 466, 108, 19);
		getContentPane().add(lblNewLabel_2_3_1_1);
		
		boxDepart = new JComboBox();
		boxDepart.setFont(new Font("Arial", Font.PLAIN, 13));
		boxDepart.setModel(new DefaultComboBoxModel(new String[] {"tecnologia", "recursos humanos", "comercial", "operacional", "financeiro", "juridico"}));
		boxDepart.setBounds(181, 466, 160, 21);
		getContentPane().add(boxDepart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 68, 418, 119);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);

	}
	
private boolean logicaVerificacao() {
		
		if(validarEmail() && validaUsuario() && validaSenha() && validaLogin() && tecnicoNotIT()) {
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
				Integer.parseInt(senha);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Bateu o rosto no teclado foi? Não coloque senhas grandes e não coloque letras.");
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
	
	private boolean tecnicoNotIT() {
		
		String selectedLevel = (String) boxLevel.getSelectedItem();
		String selectedDepart = (String) boxDepart.getSelectedItem();
		
		
		if(selectedLevel.equals("Admin") && !selectedDepart.equals("tecnologia")) {
			JOptionPane.showMessageDialog(null, "Um usuario não pode ser Admin, se não for do departamento de tecnologia!");
			return false;
		}else {
			return true;
		}
	}
	
	private void limpar() {
		txtLogin.setText("");
		txtEmail.setText("");
		txtNome.setText("");
		txtSenha.setText("");
	}
	
	//INSERT INTO usuario (nomeUsu, senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart)
	
	/*
	 * Tudo que envolver conexao e comunicação com o banco ficara daqui para baixo
	 * Por conta do tempo não irei separar em outra classe. Prioridade para o funcionamento do
	 * sistema como um todo!
	 */
	private void salvarUsuario() {
		String sql = "INSERT INTO usuario (nomeUsu,senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart) VALUES(?,?,?,?,?,?)";
		con = ModuloConexao.conector();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtNome.getText());
			pstm.setInt(2, Integer.parseInt(txtSenha.getText()));
			pstm.setString(3, txtEmail.getText());
			pstm.setString(4, (String) boxLevel.getSelectedItem());
			pstm.setString(5, txtLogin.getText());
			int posicaoDepart = boxDepart.getSelectedIndex() + 1;
			pstm.setInt(6, posicaoDepart);
			int ad = pstm.executeUpdate();
			if(ad > 0) {
				JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso ao banco!");
			}
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir no banco de dados: " + e);
		}
		
	}
}
