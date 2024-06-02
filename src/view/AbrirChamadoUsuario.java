package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import dao.ModuloConexao;
import pattersAndLogic.SessaoUsuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AbrirChamadoUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIdUsu;
	private JTextField txtTitulo;
	private JLabel txtHora;
	private JComboBox boxStatus;
	private JComboBox boxCategoria;
	private String filename;
	private int returnValue;
	private FileInputStream arquivoFinal;

	private JTextArea txtComen;

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
					AbrirChamadoUsuario frame = new AbrirChamadoUsuario();
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
	public AbrirChamadoUsuario() {
		setBounds(100, 100, 450, 300);addInternalFrameListener(new InternalFrameAdapter() {
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
		lblNewLabel_1.setBounds(71, 143, 28, 13);
		getContentPane().add(lblNewLabel_1);

		txtIdUsu = new JTextField();
		txtIdUsu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdUsu.setEnabled(false);
		txtIdUsu.setColumns(10);
		txtIdUsu.setBounds(109, 140, 59, 19);
		getContentPane().add(txtIdUsu);
		
		int idUsuarioLogado = SessaoUsuario.getInstancia().getIdUsuario();
		txtIdUsu.setText(String.valueOf(idUsuarioLogado));
		
		JLabel lblNewLabel_1_1 = new JLabel("Titulo");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(71, 182, 48, 13);
		getContentPane().add(lblNewLabel_1_1);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(160, 179, 169, 19);
		getContentPane().add(txtTitulo);

		JLabel lblNewLabel_1_2 = new JLabel("Categoria");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(71, 220, 80, 13);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hora Criada");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(71, 271, 89, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtHora = new JLabel("dd/mm/yyyy");
		txtHora.setFont(new Font("Arial", Font.BOLD, 14));
		txtHora.setBounds(160, 271, 155, 13);
		getContentPane().add(txtHora);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Anexo");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(71, 307, 48, 13);
		getContentPane().add(lblNewLabel_1_1_2);
		
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
		btnArqui.setBounds(71, 337, 170, 21);
		getContentPane().add(btnArqui);

		JLabel lblNewLabel_1_2_1 = new JLabel("Status");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(369, 223, 66, 13);
		getContentPane().add(lblNewLabel_1_2_1);

		boxStatus = new JComboBox();
		boxStatus.setEnabled(false);
		boxStatus.setForeground(new Color(0, 0, 0));
		boxStatus.setModel(new DefaultComboBoxModel(new String[] { "aberto", "em andamento", "fechado" }));
		boxStatus.setFont(new Font("Arial", Font.BOLD, 12));
		boxStatus.setBounds(458, 220, 169, 21);
		getContentPane().add(boxStatus);

		boxCategoria = new JComboBox();
		boxCategoria.setModel(new DefaultComboBoxModel(new String[] { "Help Desk", "Projetos", "Rede e Telefonia",
				"Hardware e Perifericos", "Software", "Servidores", "Especificações" }));
		boxCategoria.setEditable(true);
		boxCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		boxCategoria.setBounds(161, 217, 169, 21);
		getContentPane().add(boxCategoria);

		JLabel lblNewLabel_3 = new JLabel("Comentario");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(71, 368, 163, 24);
		getContentPane().add(lblNewLabel_3);

		txtComen = new JTextArea();
		txtComen.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComen.setBounds(71, 402, 338, 100);
		getContentPane().add(txtComen);
		
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
		btnSalvar.setIcon(new ImageIcon(AbrirChamadoUsuario.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(315, 512, 66, 66);
		getContentPane().add(btnSalvar);
		
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
	
	public void limparCampos() {
		txtTitulo.setText("");
		txtIdUsu.setText("");
		txtComen.setText("");

	}
	
	/*
	 * Abrindo um chamado
	 * Insert
	 */
	
	public void criarChamado() {
		// INSERT INTO chamado (tituloCha,categoriaCha, horaCriCha, anexoCha,statusCha,
		// comentarioCha, descricaoCha, idUsu)
		String sql = "INSERT INTO chamado(tituloCha,categoriaCha,horaCriCha,anexoCha,statusCha,comentarioCha,idUsu) "
				+ "VALUES (?,?,?,?,?,?,?)";

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
			pstm.setInt(7, Integer.parseInt(txtIdUsu.getText()));
			
			int execute = pstm.executeUpdate();

			if (execute > 0) {
				JOptionPane.showMessageDialog(null, "Inserido no banco de dados com sucesso!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar inserir no banco de dados! " + e);
		}
	}
	
	
}
