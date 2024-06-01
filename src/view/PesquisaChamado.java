package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



public class PesquisaChamado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
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
		
		JLabel lblNewLabel = new JLabel("Pesquisar por Data");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 89, 128, 13);
		getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(29, 153, 621, 411);
		getContentPane().add(table);
		
		lblPesquisarPorStatus = new JLabel("Pesquisar por Status");
		lblPesquisarPorStatus.setFont(new Font("Arial", Font.BOLD, 13));
		lblPesquisarPorStatus.setBounds(344, 89, 136, 13);
		getContentPane().add(lblPesquisarPorStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aberto", "Em andamento", "Fechado"}));
		comboBox.setBounds(490, 85, 136, 21);
		getContentPane().add(comboBox);
		
//		UtilDateModel model = new UtilDateModel();
//		JDatePanelImpl datePanel = new JDatePanelImpl(model);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
//		 
//		frame.add(datePicker);
		
	}
	
}
