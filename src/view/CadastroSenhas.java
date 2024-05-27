package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroSenhas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtOrigem;
	private JTextField txtLogin;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField textField_5;
	private JTextArea textArea;
	
	
	private Connection con;
	private PreparedStatement pstm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroSenhas frame = new CadastroSenhas();
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
	public CadastroSenhas() {
		setFrameIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/CadastroSenha.png")));
		setBounds(0, 0, 695, 640);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(86, 174, 28, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Origem");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(86, 216, 74, 24);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descrição");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(86, 391, 74, 24);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(86, 260, 74, 23);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(86, 299, 74, 26);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Senha");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setBounds(86, 346, 74, 28);
		getContentPane().add(lblNewLabel_6);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 13));
		txtId.setEnabled(false);
		txtId.setBounds(156, 171, 46, 19);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtOrigem = new JTextField();
		txtOrigem.setFont(new Font("Arial", Font.PLAIN, 13));
		txtOrigem.setBounds(162, 223, 408, 19);
		getContentPane().add(txtOrigem);
		txtOrigem.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLogin.setBounds(162, 266, 408, 19);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmail.setBounds(162, 307, 408, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBounds(162, 355, 408, 19);
		getContentPane().add(txtSenha);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pesquisar por Origem");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 33, 170, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_5.setBounds(190, 31, 366, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea.setBounds(164, 392, 406, 100);
		getContentPane().add(textArea);
		
		JLabel btnSalvar = new JLabel("");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(logicaVerificacao() == true) {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					txtLogin.setText("");
					txtEmail.setText("");
					txtOrigem.setText("");
					txtSenha.setText("");
					textArea.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro, preencha corretamente os campos");
				}
				
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(132, 522, 66, 66);
		getContentPane().add(btnSalvar);
		
		JLabel btnAlterar = new JLabel("");
		btnAlterar.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/alterar.png")));
		btnAlterar.setBounds(327, 522, 66, 66);
		getContentPane().add(btnAlterar);
		
		JLabel btnDeletar = new JLabel("");
		btnDeletar.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/excluir.png")));
		btnDeletar.setBounds(516, 502, 66, 86);
		getContentPane().add(btnDeletar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/senha.png")));
		lblNewLabel.setBounds(591, 34, 66, 66);
		getContentPane().add(lblNewLabel);

		
	}
	
private boolean logicaVerificacao() {
		
		if(validarEmail()  && validaSenha() && validaOrigem() ) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean validaOrigem() {
		String origem = txtOrigem.getText();
		if(origem.trim().isBlank()) {
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
	 * Abaixo se encontra o script para inserir no banco
	 * 
	 */
	
	//INSERT INTO senhasGerais (descricaoSen, senhaSen, emailSen, loginSen, origemSen, idUsu)

	
	private void inserir() {
		
		String sql = "INSERT INTO senhasGerais(descricaoSen, senhaSen, emailSen,loginSen,origemSen,idUsu) VALUES(?,?,?,?,?,?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, textArea.getText());
			pstm.setString(2, txtSenha.getText());
			pstm.setString(3, txtEmail.getText());
			pstm.setString(4, txtLogin.getText());
			pstm.setString(5, txtOrigem.getText());
			//Preciso pesquisar pelo cliente. Isso é associar a criação da senha com o usuario que está logado no sistema
//			pstm.setInt(6, );
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir no banco!");
		}
		
		
		
	}
	
	
	
	
	
}	
