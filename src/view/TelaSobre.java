package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class TelaSobre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobre.class.getResource("/recursos/suporte-tecnico.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Suporte ao Usuario. O sistema em questão");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(51, 100, 499, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblCorrespondeAUm = new JLabel("corresponde a um dos meios de avaliação da disciplina de POO");
		lblCorrespondeAUm.setForeground(new Color(0, 0, 0));
		lblCorrespondeAUm.setVerticalAlignment(SwingConstants.TOP);
		lblCorrespondeAUm.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorrespondeAUm.setFont(new Font("Arial", Font.BOLD, 16));
		lblCorrespondeAUm.setEnabled(false);
		lblCorrespondeAUm.setBounds(51, 127, 499, 44);
		contentPane.add(lblCorrespondeAUm);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(TelaSobre.class.getResource("/recursos/java.png")));
		lblNewLabel_1.setBounds(51, 10, 65, 65);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEBancoDe = new JLabel("e banco de Dados. O software é openSource e seu código ");
		lblEBancoDe.setForeground(new Color(0, 0, 0));
		lblEBancoDe.setVerticalAlignment(SwingConstants.TOP);
		lblEBancoDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblEBancoDe.setFont(new Font("Arial", Font.BOLD, 16));
		lblEBancoDe.setEnabled(false);
		lblEBancoDe.setBounds(51, 154, 499, 44);
		contentPane.add(lblEBancoDe);
		
		JLabel lblEstDisponivelNo = new JLabel("está disponivel no github");
		lblEstDisponivelNo.setForeground(new Color(0, 0, 0));
		lblEstDisponivelNo.setVerticalAlignment(SwingConstants.TOP);
		lblEstDisponivelNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstDisponivelNo.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstDisponivelNo.setEnabled(false);
		lblEstDisponivelNo.setBounds(51, 181, 499, 44);
		contentPane.add(lblEstDisponivelNo);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setIcon(new ImageIcon(TelaSobre.class.getResource("/recursos/link.png")));
		lblNewLabel_2.setBounds(199, 250, 140, 141);
		contentPane.add(lblNewLabel_2);
	}
}
