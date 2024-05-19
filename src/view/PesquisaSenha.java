package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class PesquisaSenha extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaSenha frame = new PesquisaSenha();
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
	public PesquisaSenha() {
		setFrameIcon(new ImageIcon(PesquisaSenha.class.getResource("/recursos/PesquisaSenha.png")));
		setBounds(0, 0, 695, 640);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisa por Id");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 83, 124, 13);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setBounds(158, 80, 44, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(24, 145, 625, 415);
		getContentPane().add(table);
		
		JLabel lblPesquisaPorOrigem = new JLabel("Pesquisa por origem");
		lblPesquisaPorOrigem.setFont(new Font("Arial", Font.BOLD, 14));
		lblPesquisaPorOrigem.setBounds(299, 84, 155, 13);
		getContentPane().add(lblPesquisaPorOrigem);
		
		textField_1 = new JTextField();
		textField_1.setBounds(459, 81, 190, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}
}
