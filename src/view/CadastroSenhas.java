package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ModuloConexao;
import net.proteanit.sql.DbUtils;
import pattersAndLogic.SessaoUsuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroSenhas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtOrigem;
	private JTextField txtLogin;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtPesquisa;
	private JTextArea textArea;
	
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private JTextField txtIdTecnico;
	private JTable tblSenha;
	
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
		setTitle("Cadastro Senha");
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
		
		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisaAvancada();
			}
		});
		txtPesquisa.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPesquisa.setBounds(190, 31, 366, 19);
		getContentPane().add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea.setBounds(164, 392, 406, 100);
		getContentPane().add(textArea);
		
		JLabel btnSalvar = new JLabel("");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(logicaVerificacao() == true) {
					inserir();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro, preencha corretamente os campos");
				}
				
				
			}

			
		});
		btnSalvar.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(132, 522, 66, 66);
		getContentPane().add(btnSalvar);
		
		JLabel btnAlterar = new JLabel("");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(logicaVerificacao() == true) {
					atualizarSenha();
					limparCampos();
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro, preencha corretamente os campos");
				}
				
			}
		});
		btnAlterar.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/alterar.png")));
		btnAlterar.setBounds(327, 522, 66, 66);
		getContentPane().add(btnAlterar);
		
		JLabel btnDeletar = new JLabel("");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int respon = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar a senha?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if(logicaVerificacao() == true && respon <=0) {
					deletarSenha();
					limparCampos();
				}
				
			}
		});
		btnDeletar.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/excluir.png")));
		btnDeletar.setBounds(516, 502, 66, 86);
		getContentPane().add(btnDeletar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroSenhas.class.getResource("/recursos/senha.png")));
		lblNewLabel.setBounds(591, 34, 66, 66);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID Tecnico");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(415, 180, 83, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		txtIdTecnico = new JTextField();
		txtIdTecnico.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdTecnico.setEnabled(false);
		txtIdTecnico.setColumns(10);
		txtIdTecnico.setBounds(524, 174, 46, 19);
		getContentPane().add(txtIdTecnico);

		int idUsuarioLogado = SessaoUsuario.getInstancia().getIdUsuario();
		txtIdTecnico.setText(String.valueOf(idUsuarioLogado));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 62, 366, 86);
		getContentPane().add(scrollPane);
		
		tblSenha = new JTable();
		tblSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setagemCampos();
			}
		});
		scrollPane.setViewportView(tblSenha);
		
		
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
	
	//Limpar campos
	private void limparCampos() {
		txtLogin.setText("");
		txtEmail.setText("");
		txtOrigem.setText("");
		txtSenha.setText("");
		textArea.setText("");
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
			con = ModuloConexao.conector();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, textArea.getText());
			pstm.setString(2, txtSenha.getText());
			pstm.setString(3, txtEmail.getText());
			pstm.setString(4, txtLogin.getText());
			pstm.setString(5, txtOrigem.getText());
			//Preciso pesquisar pelo cliente. Isso é associar a criação da senha com o usuario que está logado no sistema
			pstm.setInt(6, Integer.parseInt(txtIdTecnico.getText()));
			
			int exec = pstm.executeUpdate();
			
			if(exec > 0) {
				JOptionPane.showMessageDialog(null, "Inserido no banco com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possivel inserir no banco de dados");
			}
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir no banco! Erro: "+ e);
		}
	}
	
	
	/*
	 * Pesquisa avançada por origim da senha
	 */
	
	private void pesquisaAvancada() {
		
		String sql = "SELECT idSen as ID, origemSen as Origem, emailSen as Email, senhaSen as Senha, loginSen as Login, descricaoSen as Descrição, "
				+ "idUsu FROM senhasGerais WHERE origemSen LIKE ?";
		
		con = ModuloConexao.conector();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtPesquisa.getText() + "%");
			rs = pstm.executeQuery();
			tblSenha.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar realizar a busca no banco: "+ e);
			
		}
	}
	
	
	/*
	 * Setagem de campos. O metodo abaixo pega os dados da tabela quando uma linha é clicada
	 */
	
	private void setagemCampos() {
		
		int setar = tblSenha.getSelectedRow();
		
		txtId.setText(tblSenha.getModel().getValueAt(setar, 0).toString());
		txtOrigem.setText(tblSenha.getModel().getValueAt(setar, 1).toString());
		txtEmail.setText(tblSenha.getModel().getValueAt(setar, 2).toString());
		txtSenha.setText(tblSenha.getModel().getValueAt(setar, 3).toString());
		txtLogin.setText(tblSenha.getModel().getValueAt(setar, 4).toString());
		textArea.setText(tblSenha.getModel().getValueAt(setar, 5).toString());
		txtIdTecnico.setText(tblSenha.getModel().getValueAt(setar, 6).toString());
		
	}
	
	
	
	/*
	 * UPDATE do CRUD
	 */
	
	private void atualizarSenha() {
		
		String sql = "UPDATE senhasGerais SET origemSen = ?, emailSen = ?, senhaSen = ?, loginSen = ?, descricaoSen = ? WHERE idSen = ?";
		
		con = ModuloConexao.conector();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtOrigem.getText());
			pstm.setString(2, txtEmail.getText());
			pstm.setInt(3, Integer.parseInt(txtSenha.getText()));
			pstm.setString(4, txtLogin.getText());
			pstm.setString(5, textArea.getText());
			pstm.setInt(6, Integer.parseInt(txtId.getText()));
			int alterado = pstm.executeUpdate();
			
			if(alterado > 0) {
				JOptionPane.showMessageDialog(null, "A senha foi alterada com sucesso!");
			}
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a senha no banco: "+ e);
			
		}
		
	}
	
	
	/*
	 * Delete do CRUD
	 */
	
	private void deletarSenha() {
	
		String sql = "DELETE FROM senhasGerais WHERE idSen = ?";
		
		con = ModuloConexao.conector();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(txtId.getText()));
			int deletado = pstm.executeUpdate();
			
			if(deletado > 0) {
				JOptionPane.showMessageDialog(null, "Deletado do banco com sucesso!");
			}
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar do banco de dados: "+ e);
			
		}
		
	}
	
	
	
}	
