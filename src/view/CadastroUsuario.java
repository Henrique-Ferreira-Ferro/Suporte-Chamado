package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					txtLogin.setText("");
					txtEmail.setText("");
					txtNome.setText("");
					txtSenha.setText("");
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
		String selectedDepart = (String) boxLevel.getSelectedItem();
		
		
		if(selectedLevel.equals("Admin") && !selectedDepart.equals("tecnologia")) {
			JOptionPane.showMessageDialog(null, "Um usuario não pode ser Admin, se não for do departamento de tecnologia!");
			return false;
		}else {
			return true;
		}
	}
	
	
}
