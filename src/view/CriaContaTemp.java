package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.Panel;

public class CriaContaTemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(102, 209, 358, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(39, 250, 56, 13);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(102, 250, 358, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(39, 291, 56, 13);
		contentPane.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(102, 291, 358, 19);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Login");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBounds(39, 335, 56, 19);
		contentPane.add(lblNewLabel_2_3_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(102, 335, 358, 19);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Departamento");
		lblNewLabel_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1.setBounds(39, 379, 108, 19);
		contentPane.add(lblNewLabel_2_3_1_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(157, 379, 303, 19);
		contentPane.add(textField_4);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
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
	}
}
