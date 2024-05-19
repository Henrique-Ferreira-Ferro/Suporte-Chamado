package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PesquisaChamado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_1;
	private JLabel lblPesquisarPorStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaChamado frame = new PesquisaChamado();
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
	public PesquisaChamado() {
		setFrameIcon(new ImageIcon(PesquisaChamado.class.getResource("/recursos/pesquisa chamado.png")));

		setBounds(0, 0, 695, 640);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisar por Id");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 89, 105, 13);
		getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(29, 153, 621, 411);
		getContentPane().add(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 86, 42, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblPesquisarPorStatus = new JLabel("Pesquisar por Status");
		lblPesquisarPorStatus.setFont(new Font("Arial", Font.BOLD, 13));
		lblPesquisarPorStatus.setBounds(344, 89, 136, 13);
		getContentPane().add(lblPesquisarPorStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aberto", "Em andamento", "Fechado"}));
		comboBox.setBounds(490, 85, 136, 21);
		getContentPane().add(comboBox);
		
	}
}
