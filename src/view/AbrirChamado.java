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

public class AbrirChamado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIdCha;
	private JTextField txtTitulo;
	private JTextField txtIdUsu;
	private JLabel txtHora;
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
		lblNewLabel_1.setBounds(74, 72, 28, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtIdCha = new JTextField();
		txtIdCha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdCha.setEnabled(false);
		txtIdCha.setColumns(10);
		txtIdCha.setBounds(112, 69, 59, 19);
		getContentPane().add(txtIdCha);
		
		JLabel lblNewLabel_1_1 = new JLabel("Titulo");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(74, 116, 48, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(163, 113, 169, 19);
		getContentPane().add(txtTitulo);
		
		JLabel lblNewLabel_1_2 = new JLabel("Categoria");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(74, 155, 80, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hora Criada");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(74, 238, 91, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Anexo");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(74, 289, 48, 13);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Status");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(74, 192, 66, 13);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JComboBox boxStatus = new JComboBox();
		boxStatus.setForeground(new Color(0, 0, 0));
		boxStatus.setEnabled(false);
		boxStatus.setModel(new DefaultComboBoxModel(new String[] {"aberto", "em andamento", "fechado"}));
		boxStatus.setFont(new Font("Arial", Font.BOLD, 12));
		boxStatus.setBounds(163, 189, 169, 21);
		getContentPane().add(boxStatus);
		
		JComboBox boxCategoria = new JComboBox();
		boxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Help Desk", "Projetos", "Rede e Telefonia", "Hardware e Perifericos", "Software", "Servidores", "Especificações"}));
		boxCategoria.setEditable(true);
		boxCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		boxCategoria.setBounds(164, 152, 169, 21);
		getContentPane().add(boxCategoria);
		
		JLabel lblNewLabel_3 = new JLabel("Comentario");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(74, 356, 163, 24);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea txtComen = new JTextArea();
		txtComen.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComen.setBounds(74, 390, 268, 100);
		getContentPane().add(txtComen);
		
		JTextArea txtDesc = new JTextArea();
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDesc.setBounds(372, 390, 277, 100);
		getContentPane().add(txtDesc);
		
		JLabel lblNewLabel_3_1 = new JLabel("Descrição");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(372, 356, 163, 24);
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
		btnArqui.setBounds(162, 286, 170, 21);
		getContentPane().add(btnArqui);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("ID Usuario");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(478, 72, 80, 13);
		getContentPane().add(lblNewLabel_1_1_3);
		
		txtIdUsu = new JTextField();
		txtIdUsu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIdUsu.setEnabled(false);
		txtIdUsu.setColumns(10);
		txtIdUsu.setBounds(568, 69, 59, 19);
		getContentPane().add(txtIdUsu);
		
		JButton btnAbrirChamado = new JButton("ABRIR CHAMADO");
		btnAbrirChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validaTitulo() == true) {
					JOptionPane.showMessageDialog(null, "Chamado aberto com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					txtComen.setText("");
					txtDesc.setText("");
					txtTitulo.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel fazer a abertura do chamado!", "Falha", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAbrirChamado.setForeground(Color.WHITE);
		btnAbrirChamado.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAbrirChamado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAbrirChamado.setBackground(new Color(79, 79, 253));
		btnAbrirChamado.setBounds(74, 531, 163, 26);
		getContentPane().add(btnAbrirChamado);
		
		txtHora = new JLabel("dd/mm/yyyy");
		txtHora.setFont(new Font("Arial", Font.BOLD, 14));
		txtHora.setBounds(177, 239, 155, 13);
		getContentPane().add(txtHora);

	}
	
	private boolean validaTitulo() {
		String senha = txtTitulo.getText();
		if(senha.trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "Não deixe o campo senha vaziu, pois é importante", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	
}
