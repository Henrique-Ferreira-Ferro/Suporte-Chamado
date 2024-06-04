package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ModuloConexao;
import entities.Departamento;
import entities.Usuario;
import net.proteanit.sql.DbUtils;
import services.UsuarioService;

public class CadastroUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisaNome;
	private JTextField txtIdUsu;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private JTextField txtLogin;

	private JComboBox boxDepart;
	private JComboBox boxLevel;

	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;
	private JTable tbUsuario;

	private UsuarioService service;

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
	 * 
	 * @throws PropertyVetoException
	 */
	public CadastroUsuario() {
		service = new UsuarioService();

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

		txtPesquisaNome = new JTextField();
		txtPesquisaNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisaAvancada();
			}
		});
		txtPesquisaNome.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPesquisaNome.setBounds(125, 35, 366, 19);
		getContentPane().add(txtPesquisaNome);
		txtPesquisaNome.setColumns(10);

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

		txtIdUsu = new JTextField();
		txtIdUsu.setEnabled(false);
		txtIdUsu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdUsu.setBounds(133, 210, 45, 19);
		getContentPane().add(txtIdUsu);
		txtIdUsu.setColumns(10);

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
		boxLevel.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Usuario" }));
		boxLevel.setFont(new Font("Arial", Font.PLAIN, 13));
		boxLevel.setBounds(136, 371, 142, 21);
		getContentPane().add(boxLevel);

		JLabel btnSalvar = new JLabel("");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usuario = new Usuario();

				salvarUsuario(usuario);
				if (service.registrarUsuario(usuario) && logicaVerificacao()) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					
					limpar();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
				}

			}

		});
		btnSalvar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(80, 515, 66, 66);
		getContentPane().add(btnSalvar);

		JLabel btnGravar = new JLabel("");
		btnGravar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (logicaVerificacao() == true) {
					atualizarUsuario();
				} else {
					JOptionPane.showMessageDialog(null,
							"Não foi possivel realizar a alteração do Usuario, preencha corretamente os campos");
				}

			}
		});
		btnGravar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/alterar.png")));
		btnGravar.setBounds(275, 515, 66, 66);
		getContentPane().add(btnGravar);

		JLabel btnDeletar = new JLabel("");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int respon = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o usuário?",
						"Confirmação", JOptionPane.YES_NO_OPTION);
				if (respon == JOptionPane.YES_OPTION) {
					deleteUser();
				}

			}
		});
		btnDeletar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/recursos/excluir.png")));
		btnDeletar.setBounds(464, 495, 66, 86);
		getContentPane().add(btnDeletar);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("Departamento");
		lblNewLabel_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1.setBounds(70, 466, 108, 19);
		getContentPane().add(lblNewLabel_2_3_1_1);

		boxDepart = new JComboBox();
		boxDepart.setFont(new Font("Arial", Font.PLAIN, 13));
		boxDepart.setModel(new DefaultComboBoxModel(new String[] { "tecnologia", "recursos humanos", "comercial",
				"operacional", "financeiro", "juridico" }));
		boxDepart.setBounds(181, 466, 160, 21);
		getContentPane().add(boxDepart);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 68, 507, 119);
		getContentPane().add(scrollPane);

		tbUsuario = new JTable();
		tbUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setagemCampos();
			}
		});
		tbUsuario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Senha", "Email", "Nivel", "Login", "Departamento" }));
		scrollPane.setViewportView(tbUsuario);

	}

	/*
	 * Mover para o pacote PattersANDLogic
	 */

	private boolean logicaVerificacao() {

		if (validarEmail() && validaUsuario() && validaSenha() && validaLogin() && tecnicoNotIT()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validaLogin() {
		String login = txtLogin.getText();
		if (login.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo login vaziu, pois é importante", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private boolean validaSenha() {
		String senha = txtSenha.getText();
		if (senha.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo senha vaziu, pois é importante", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			try {
				Integer.parseInt(senha);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Bateu o rosto no teclado foi? Não coloque senhas grandes e não coloque letras.");
			}
			return true;
		}
	}

	private boolean validaUsuario() {
		String usuario = txtNome.getText();
		if (usuario.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo nome vaziu, pois é importante", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private boolean validarEmail() {
		String email = txtEmail.getText();
		String verificaRegx = "^(.+)@(\\S+)$";
		Pattern padrao = Pattern.compile(verificaRegx);
		Matcher cheque = padrao.matcher(email);
		if (email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo email vaziu, preencha corretamente!", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!cheque.matches()) {
			JOptionPane.showMessageDialog(null, "Insira um email valido, caso contrario o cadastro não será efetuado",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private boolean tecnicoNotIT() {

		String selectedLevel = (String) boxLevel.getSelectedItem();
		String selectedDepart = (String) boxDepart.getSelectedItem();

		if (selectedLevel.equals("Admin") && !selectedDepart.equals("tecnologia")) {
			JOptionPane.showMessageDialog(null,
					"Um usuario não pode ser Admin, se não for do departamento de tecnologia!");
			return false;
		} else {
			return true;
		}
	}

	private void limpar() {
		txtLogin.setText("");
		txtEmail.setText("");
		txtNome.setText("");
		txtSenha.setText("");
	}

	/*
	 * Termino das validações
	 */

	/*
	 * Tudo que envolver conexao e comunicação com o banco ficara daqui para baixo
	 * Por conta do tempo não irei separar em outra classe. Prioridade para o
	 * funcionamento do sistema como um todo!
	 */

	/*
	 * Metodo INSERT do CRUD Nota: Abaixo se encontrar o método responsavel por
	 * salvar no banco de dados. É levado ao service e após isso ao UsuarioDTO
	 */
	private void salvarUsuario(Usuario usuario) {
		usuario.setName(txtNome.getText());
		usuario.setSenha(Integer.parseInt(txtSenha.getText()));
		usuario.setEmail(txtEmail.getText());
		usuario.setNivel((String) boxLevel.getSelectedItem());
		usuario.setLogin(txtLogin.getText());
		Departamento departamento = new Departamento();
		usuario.setDepartamento(departamento);
		usuario.getDepartamento().setId(boxDepart.getSelectedIndex() + 1);
	}

	/*
	 * Delete do CRUD
	 */

	private void deleteUser() {
		if (txtIdUsu.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "O id do usuario não pode ser nulo!");
			return;
		}

		int idUsuario = Integer.parseInt(txtIdUsu.getText());
		boolean sucesso = service.deletarUsuario(idUsuario);

		if (sucesso) {
			JOptionPane.showMessageDialog(null, "Usuario apagado com sucesso do banco");
			limpar();
		} else {
			JOptionPane.showMessageDialog(null,"Erro ao tentar apagar do banco. O usuário pode já ter aberto um chamado e por isso não pode ser deletado!");
		}

	}
	
	/*
	 * Read CRUD. Metodo voltado para pesquisa, onde eu posso digitar o nome do usuario e assim trazer na tabela 
	 */
	
	private void pesquisaAvancada() {
		String nomeUsuario = txtPesquisaNome.getText();
		service.pesquisaAvancada(nomeUsuario, tbUsuario);
	}


	/*
	 * Setagem dos campos, ao clicar em uma linha da tabela os campos de textos
	 * teram seus valores substituidos
	 */

	private void setagemCampos() {
		int setar = tbUsuario.getSelectedRow();

		txtIdUsu.setText(tbUsuario.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tbUsuario.getModel().getValueAt(setar, 1).toString());
		txtSenha.setText(tbUsuario.getModel().getValueAt(setar, 2).toString());
		txtEmail.setText(tbUsuario.getModel().getValueAt(setar, 3).toString());
		boxLevel.setSelectedItem(tbUsuario.getModel().getValueAt(setar, 4).toString());
		txtLogin.setText(tbUsuario.getModel().getValueAt(setar, 5).toString());
		int idDepart = Integer.parseInt(tbUsuario.getModel().getValueAt(setar, 6).toString());
		boxDepart.setSelectedIndex(idDepart - 1); // lembrando que para inserir um departamento foi feito o esquema de
													// pegar pelo indice
	}

	/*
	 * Update do CRUD
	 */

	
	private void atualizarUsuario() {
	    Usuario usuario = new Usuario();
	    usuario.setId(Integer.parseInt(txtIdUsu.getText()));
	    usuario.setName(txtNome.getText());
	    usuario.setSenha(Integer.parseInt(txtSenha.getText()));
	    usuario.setEmail(txtEmail.getText());
	    usuario.setNivel(boxLevel.getSelectedItem().toString());
	    usuario.setLogin(txtLogin.getText());
	    Departamento departamento = new Departamento();
	    departamento.setId(boxDepart.getSelectedIndex() + 1); // Ajuste conforme necessário para o índice correto
	    usuario.setDepartamento(departamento);
	    if (service.atualizarUsuario(usuario)) {
	        JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
	        limpar();
	    } else {
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário");
	    }
	}


}
