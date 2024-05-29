package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AbrirChamado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIdCha;
	private JTextField txtTitulo;
	private JTextField txtIdUsu;
	private JLabel txtHora;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
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
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
		
		JComboBox boxStatus = new JComboBox();
		boxStatus.setForeground(new Color(0, 0, 0));
		boxStatus.setEnabled(false);
		boxStatus.setModel(new DefaultComboBoxModel(new String[] {"aberto", "em andamento", "fechado"}));
		boxStatus.setFont(new Font("Arial", Font.BOLD, 12));
		boxStatus.setBounds(458, 284, 169, 21);
		getContentPane().add(boxStatus);
		
		JComboBox boxCategoria = new JComboBox();
		boxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Help Desk", "Projetos", "Rede e Telefonia", "Hardware e Perifericos", "Software", "Servidores", "Especificações"}));
		boxCategoria.setEditable(true);
		boxCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		boxCategoria.setBounds(161, 281, 169, 21);
		getContentPane().add(boxCategoria);
		
		JLabel lblNewLabel_3 = new JLabel("Comentario");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(71, 391, 163, 24);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea txtComen = new JTextArea();
		txtComen.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComen.setBounds(71, 425, 268, 100);
		getContentPane().add(txtComen);
		
		JTextArea txtDesc = new JTextArea();
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
							String filename = f.getName().toLowerCase();
							return filename.endsWith(".pdf") || filename.endsWith(".txt") || filename.endsWith(".jpg") || filename.endsWith(".png");
						}
					}
					
					@Override
					public String getDescription() {
						return "Documentos e Imagens (PDF, TXT, JPG, PNG)";
					}
				});
				
				int returnValue = fileChooser.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File[] selectedFiles = fileChooser.getSelectedFiles();
					for (File file : selectedFiles) {
						System.out.println("Arquivo selecionado: " + file.getAbsolutePath());
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
		txtIdUsu.setBounds(236, 10, 45, 19);
		panel.add(txtIdUsu);
		txtIdUsu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdUsu.setEnabled(false);
		txtIdUsu.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 9));
		textField.setBounds(22, 32, 134, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Pesquisar Nome");
		lblNewLabel_1_1_3_1.setFont(new Font("Arial", Font.BOLD, 9));
		lblNewLabel_1_1_3_1.setBounds(22, 14, 82, 13);
		panel.add(lblNewLabel_1_1_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 72, 259, 92);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel btnSalvar = new JLabel("");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(validaTitulo() == false) {
					JOptionPane.showMessageDialog(null, "Precisa comprir os requisitos para haver o cadastramento");
				}else {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					txtTitulo.setText("");
					txtDesc.setText("");
					txtComen.setText("");
					
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(AbrirChamado.class.getResource("/recursos/salve-.png")));
		btnSalvar.setBounds(133, 535, 66, 66);
		getContentPane().add(btnSalvar);
		
		JLabel btnAlterar = new JLabel("");
		btnAlterar.setIcon(new ImageIcon(AbrirChamado.class.getResource("/recursos/alterar.png")));
		btnAlterar.setBounds(328, 535, 66, 66);
		getContentPane().add(btnAlterar);
		
		JLabel btnDeletar = new JLabel("");
		btnDeletar.setIcon(new ImageIcon(AbrirChamado.class.getResource("/recursos/excluir.png")));
		btnDeletar.setBounds(517, 515, 66, 86);
		getContentPane().add(btnDeletar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(38, 10, 301, 174);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Pesquisar Status");
		lblNewLabel_1_1_3_1_1.setFont(new Font("Arial", Font.BOLD, 9));
		lblNewLabel_1_1_3_1_1.setBounds(22, 14, 82, 13);
		panel_1.add(lblNewLabel_1_1_3_1_1);
		
		JComboBox boxStatusPesqui = new JComboBox();
		boxStatusPesqui.setEditable(true);
		boxStatusPesqui.setModel(new DefaultComboBoxModel(new String[] {"aberto", "em andamento", "fechado"}));
		boxStatusPesqui.setForeground(Color.BLACK);
		boxStatusPesqui.setFont(new Font("Arial", Font.BOLD, 12));
		boxStatusPesqui.setBounds(22, 37, 169, 21);
		panel_1.add(boxStatusPesqui);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 77, 269, 87);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Titulo"
			}
		));
		scrollPane_1.setViewportView(table_1);

	}
	
	private boolean validaTitulo() {
		String senha = txtTitulo.getText();
		if(senha.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo titulo vaziu, pois é importante", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 *Abaixo se encontra tudo relativo ao banco de dados
	 *Nota: Os métodos abaixo não são static, pois serão remanejados futuramente
	 *para outra classe, tal como todos os outros que interagem com o banco
	 */
	
	
	/*
	 * Pesquisa avançada no banco pelo nome do usuario
	 */
	public  void procurarUsuario() {
		
		
		
		
	}
	
	
	
	
	public void criarChamado() {
		
	}
}