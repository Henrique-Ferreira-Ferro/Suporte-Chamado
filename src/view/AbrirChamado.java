package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import dao.ModuloConexao;
import net.proteanit.sql.DbUtils;
import pattersAndLogic.SessaoUsuario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AbrirChamado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIdCha;
	private JTextField txtTitulo;
	private JTextField txtIdUsu;
	private JLabel txtHora;
	private JTextField txtPesquisaNome;
	private JTable tblUsuario;
	private JTable tblStatus;
	private JComboBox boxStatus;
	private JComboBox boxCategoria;
	private JComboBox boxStatusPesqui;
	private String filename;
	private int returnValue;
	private FileInputStream arquivoFinal;

	private JTextArea txtComen;
	private JTextArea txtDesc;

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;

	private SimpleDateFormat sdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirChamado frame = new AbrirChamado();
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
	public AbrirChamado() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				Date data = new Date();
				sdf = new SimpleDateFormat("yyyy/MM/dd");
				txtHora.setText(sdf.format(data));
			}
		});
		setFrameIcon(new ImageIcon(AbrirChamado.class.getResource("/recursos/video-chamada (1).png")));
		setTitle("Chamado");
		setBounds(0, 0, 695, 640);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(71, 207, 28, 13);
		getContentPane().add(lblNewLabel_1);

		txtIdCha = new JTextField();
		txtIdCha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdCha.setEnabled(false);
		txtIdCha.setColumns(10);
		txtIdCha.setBounds(109, 204, 59, 19);
		getContentPane().add(txtIdCha);

		JLabel lblNewLabel_1_1 = new JLabel("Titulo");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(71, 246, 48, 13);
		getContentPane().add(lblNewLabel_1_1);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(160, 243, 169, 19);
		getContentPane().add(txtTitulo);

		JLabel lblNewLabel_1_2 = new JLabel("Categoria");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(71, 284, 80, 13);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hora Criada");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(71, 323, 91, 13);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Anexo");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(71, 363, 48, 13);
		getContentPane().add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Status");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(369, 287, 66, 13);
		getContentPane().add(lblNewLabel_1_2_1);

		boxStatus = new JComboBox();
		boxStatus.setEditable(true);
		boxStatus.setForeground(new Color(0, 0, 0));
		boxStatus.setModel(new DefaultComboBoxModel(new String[] { "aberto", "em andamento", "fechado" }));
		boxStatus.setFont(new Font("Arial", Font.BOLD, 12));
		boxStatus.setBounds(458, 284, 169, 21);
		getContentPane().add(boxStatus);

		boxCategoria = new JComboBox();
		boxCategoria.setModel(new DefaultComboBoxModel(new String[] { "Help Desk", "Projetos", "Rede e Telefonia",
				"Hardware e Perifericos", "Software", "Servidores", "Especificações" }));
		boxCategoria.setEditable(true);
		boxCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		boxCategoria.setBounds(161, 281, 169, 21);
		getContentPane().add(boxCategoria);

		JLabel lblNewLabel_3 = new JLabel("Comentario");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(71, 391, 163, 24);
		getContentPane().add(lblNewLabel_3);

		txtComen = new JTextArea();
		txtComen.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComen.setBounds(71, 425, 268, 100);
		getContentPane().add(txtComen);

		txtDesc = new JTextArea();
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDesc.setBounds(369, 425, 277, 100);
		getContentPane().add(txtDesc);

		JLabel lblNewLabel_3_1 = new JLabel("Descrição");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(369, 391, 163, 24);
		getContentPane().add(lblNewLabel_3_1);

		JButton btnArqui = new JButton("Escolher Arquivo");
		btnArqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(true);
				fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
					@Override
					public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						} else {
							filename = f.getName().toLowerCase();
							return filename.endsWith(".pdf") || filename.endsWith(".txt") || filename.endsWith(".jpg")
									|| filename.endsWith(".png");
						}
					}

					@Override
					public String getDescription() {
						return "Documentos e Imagens (PDF, TXT, JPG, PNG)";
					}
				});

				returnValue = fileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					try {
						arquivoFinal = new FileInputStream(selectedFile);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo: " + ex.getMessage());
					}

				}

			}
		});
		btnArqui.setBackground(new Color(79, 79, 253));
		btnArqui.setForeground(new Color(255, 255, 255));
		btnArqui.setFont(new Font("Arial", Font.BOLD, 12));
		btnArqui.setBounds(160, 360, 170, 21);
		getContentPane().add(btnArqui);

		txtHora = new JLabel("dd/mm/yyyy");
		txtHora.setFont(new Font("Arial", Font.BOLD, 14));
		txtHora.setBounds(174, 324, 155, 13);
		getContentPane().add(txtHora);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(382, 10, 291, 174);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1_1_3 = new JLabel("ID Usuario");
		lblNewLabel_1_1_3.setBounds(167, 15, 59, 13);
		panel.add(lblNewLabel_1_1_3);
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 9));

		txtIdUsu = new JTextField();
		txtIdUsu.setEnabled(false);
		txtIdUsu.setBounds(236, 10, 45, 19);
		panel.add(txtIdUsu);
		txtIdUsu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdUsu.setColumns(10);

		int idUsuarioLogado = SessaoUsuario.getInstancia().getIdUsuario();
		txtIdUsu.setText(String.valueOf(idUsuarioLogado));

		txtPesquisaNome = new JTextField();
		txtPesquisaNome.addKeyListener(new KeyAdapter() {
			@Override
			// Pesquisa avançada enquanto o usuario digita no campo de pesquisa
			public void keyReleased(KeyEvent e) {

				procurarUsuario();

			}
		});
		txtPesquisaNome.setFont(new Font("Arial", Font.BOLD, 9));
		txtPesquisaNome.setBounds(22, 32, 134, 19);
		panel.add(txtPesquisaNome);
		txtPesquisaNome.setColumns(10);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Pesquisar Nome");
		lblNewLabel_1_1_3_1.setFont(new Font("Arial", Font.BOLD, 9));
		lblNewLabel_1_1_3_1.setBounds(22, 14, 82, 13);
		panel.add(lblNewLabel_1_1_3_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 72, 259, 92);
		panel.add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				modificaIdUsuario();
			}
		});
		tblUsuario.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome" }));
		scrollPane.setViewportView(tblUsuario);

		JLabel btnSalvar = new JLabel("");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (validaTitulo() == false) {
					JOptionPane.showMessageDialog(null, "Precisa comprir os requisitos para haver o cadastramento");

				} else {
					criarChamado();
					JOptionPane.showMessageDialog(null, "Chamado aberto com sucesso!");
					limparCampos();

				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(AbrirChamado.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(196, 535, 66, 66);
		getContentPane().add(btnSalvar);

		JLabel btnAlterar = new JLabel("");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (validaTitulo() == false) {
					JOptionPane.showMessageDialog(null, "Precisa comprir os requisitos para haver o cadastramento");

				} else {
					alterarChamado();
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					limparCampos();
				}

			}
		});
		btnAlterar.setIcon(new ImageIcon(AbrirChamado.class.getResource("/recursos/alterar.png")));
		btnAlterar.setBounds(391, 535, 66, 66);
		getContentPane().add(btnAlterar);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 10, 353, 174);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Pesquisar Status");
		lblNewLabel_1_1_3_1_1.setFont(new Font("Arial", Font.BOLD, 9));
		lblNewLabel_1_1_3_1_1.setBounds(22, 14, 82, 13);
		panel_1.add(lblNewLabel_1_1_3_1_1);

		boxStatusPesqui = new JComboBox();
		boxStatusPesqui.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				pesquisarChamado();
			}
		});
		boxStatusPesqui.setEditable(true);
		boxStatusPesqui.setModel(new DefaultComboBoxModel(new String[] { "aberto", "em andamento", "fechado" }));
		boxStatusPesqui.setForeground(Color.BLACK);
		boxStatusPesqui.setFont(new Font("Arial", Font.BOLD, 12));
		boxStatusPesqui.setBounds(22, 37, 169, 21);
		panel_1.add(boxStatusPesqui);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 77, 333, 87);
		panel_1.add(scrollPane_1);

		tblStatus = new JTable();
		tblStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		tblStatus.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Titulo" }));
		scrollPane_1.setViewportView(tblStatus);

	}

	private boolean validaTitulo() {
		String senha = txtTitulo.getText();
		if (senha.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo titulo vaziu, pois é importante", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Metodo para limpar os campos
	 */

	public void limparCampos() {
		txtTitulo.setText("");
		txtPesquisaNome.setText("");
		txtIdUsu.setText("");
		txtIdCha.setText("");
		txtDesc.setText("");
		txtComen.setText("");

	}

	/*
	 * Abaixo se encontra tudo relativo ao banco de dados Nota: Os métodos abaixo
	 * não são static, pois serão remanejados futuramente para outra classe, tal
	 * como todos os outros que interagem com o banco
	 */

	/*
	 * Pesquisa avançada no banco pelo nome do usuario
	 */
	public void procurarUsuario() {
		String sql = "SELECT idUsu as Id,nomeUsu as Nome FROM usuario WHERE nomeUsu LIKE ?";

		con = ModuloConexao.conector();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtPesquisaNome.getText() + "%");
			rs = pstm.executeQuery();
			// Usando a biblioteca rs2xml
			tblUsuario.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + e);
		}

	}

	// Metodo para modificar os campos ao clicar na tabela, no caso vou modificar o
	// ID do usuario

	public void modificaIdUsuario() {
		int setar = tblUsuario.getSelectedRow();

		txtIdUsu.setText(tblUsuario.getModel().getValueAt(setar, 0).toString());

	}

	/*
	 * Pesquisa avançada pelo chamado
	 */

	public void pesquisarChamado() {

		String sql = "SELECT idCha as ID\r\n" + ", tituloCha as Titulo, categoriaCha as Categoria,horaCriCha as Hora,"
				+ "anexoCha as Anexo,statusCha as status,comentarioCha as Coment,descricaoCha as Des,idUsu FROM chamado WHERE statusCha = ?";

		con = ModuloConexao.conector();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, boxStatusPesqui.getSelectedItem().toString());
			rs = pstm.executeQuery();
			tblStatus.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar pelo chamado: " + e);
		}

	}

	/*
	 * Insert do CRUD
	 */

	public void criarChamado() {
		// INSERT INTO chamado (tituloCha,categoriaCha, horaCriCha, anexoCha,statusCha,
		// comentarioCha, descricaoCha, idUsu)
		String sql = "INSERT INTO chamado(tituloCha,categoriaCha,horaCriCha,anexoCha,statusCha,comentarioCha,descricaoCha,idUsu) "
				+ "VALUES (?,?,?,?,?,?,?,?)";

		con = ModuloConexao.conector();

		Date data = null;
		// Preciso converter de date para sql.date, porque o pstm não vai deixar inserir
		// no banco como string
		try {
			data = sdf.parse(txtHora.getText());
		} catch (ParseException e) {
			System.out.println("Não foi possivel realizar a conversar: " + e);
		}
		java.sql.Date dataSql = new java.sql.Date(data.getTime());

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtTitulo.getText());
			pstm.setString(2, boxCategoria.getSelectedItem().toString());
			pstm.setDate(3, dataSql);
			pstm.setBlob(4, arquivoFinal);
			pstm.setString(5, boxStatus.getSelectedItem().toString());
			pstm.setString(6, txtComen.getText());
			pstm.setString(7, txtDesc.getText());
			if (!txtIdUsu.getText().trim().isEmpty()) {
				pstm.setInt(8, Integer.parseInt(txtIdUsu.getText()));
			} else {
				JOptionPane.showMessageDialog(null,
						"Não deixe o campo id do usuario vaziu! Selecione seu Id ou de outro usuario");
			}

			int execute = pstm.executeUpdate();

			if (execute > 0) {
				JOptionPane.showMessageDialog(null, "Inserido no banco de dados com sucesso!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar inserir no banco de dados! " + e);
		}
	}

	/*
	 * Ao clicar na linha da tabela de chamados, será substituido os valores nos
	 * campos de titulo, descrição dentre outros
	 */

	public void setarCampos() {

		int linhaSelec = tblStatus.getSelectedRow();

		Object idCha = tblStatus.getModel().getValueAt(linhaSelec, 0);
		Object titulo = tblStatus.getModel().getValueAt(linhaSelec, 1);
		Object categoria = tblStatus.getModel().getValueAt(linhaSelec, 2);
		Object status = tblStatus.getModel().getValueAt(linhaSelec, 5);
		Object comentario = tblStatus.getModel().getValueAt(linhaSelec, 6);
		Object descricao = tblStatus.getModel().getValueAt(linhaSelec, 7);
		Object idUsu = tblStatus.getModel().getValueAt(linhaSelec, 8);

		txtIdCha.setText(idCha != null ? idCha.toString() : "");
		txtTitulo.setText(titulo != null ? titulo.toString() : "");
		boxCategoria.setSelectedItem(categoria != null ? categoria.toString() : "");
		boxStatus.setSelectedItem(status != null ? status.toString() : "");
		txtComen.setText(comentario != null ? comentario.toString() : "");
		txtDesc.setText(descricao != null ? descricao.toString() : "");
		txtIdUsu.setText(idUsu != null ? idUsu.toString() : "");

	}

	/*
	 * Metodo Update do CRUD
	 */

	public void alterarChamado() {

		// UPDATE chamado set tituloCha = 'Arrumar bateria', categoriaCha = 'Hardware e
		// Perifericos', horaCricha = NOW(),statusCha = 'fechado',
		// comentarioCha = 'Problema na bateria chefia', idUsu = 1 WHERE idCha = 1;
		String sql = "UPDATE chamado SET tituloCha = ?, categoriaCha = ?, horaCriCha = ?, anexoCha = ?,statusCha = ?, comentarioCha = ?,"
				+ " descricaoCha = ?, idUsu = ? WHERE idCha = ? ";

		con = ModuloConexao.conector();

		Date data = null;
		// Preciso converter de date para sql.date, porque o pstm não vai deixar inserir
		// no banco como string
		try {
			data = sdf.parse(txtHora.getText());
		} catch (ParseException e) {
			System.out.println("Não foi possivel realizar a conversar: " + e);
		}
		java.sql.Date dataSql = new java.sql.Date(data.getTime());

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, txtTitulo.getText());
			pstm.setString(2, boxCategoria.getSelectedItem().toString());
			pstm.setDate(3, dataSql);
			pstm.setBlob(4, arquivoFinal);
			pstm.setString(5, boxStatus.getSelectedItem().toString());
			pstm.setString(6, txtComen.getText());
			pstm.setString(7, txtDesc.getText());
			pstm.setInt(8, Integer.parseInt(txtIdUsu.getText()));
			pstm.setInt(9, Integer.parseInt(txtIdCha.getText()));
			int alterado = pstm.executeUpdate();
			if (alterado > 0) {
				JOptionPane.showMessageDialog(null, "Atualizado no banco com sucesso!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar Chamado! " + e);
		}

	}

}