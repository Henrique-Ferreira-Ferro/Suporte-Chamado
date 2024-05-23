package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SenhaEsquecida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField varEmail;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnEnviar;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhaEsquecida frame = new SenhaEsquecida();
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
	public SenhaEsquecida() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Esqueci minha Senha");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(186, 73, 171, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite seu Email: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(95, 206, 120, 13);
		contentPane.add(lblNewLabel_1);
		
		varEmail = new JTextField();
		varEmail.setFont(new Font("Arial", Font.BOLD, 12));
		varEmail.setBounds(95, 229, 302, 19);
		contentPane.add(varEmail);
		varEmail.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Iremos notificar a equipe tecnica que você esqueceu ");
		lblNewLabel_2.setLabelFor(this);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(95, 120, 341, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("a sua senha, portanto não se preocupe :D");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(95, 137, 278, 13);
		contentPane.add(lblNewLabel_3);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = varEmail.getText();
				
				Pattern padrao = verificaEmail();
				
				Matcher cheque = padrao.matcher(email);
				
				if(email.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Preencha o campo, caso contrario não iremos notificar a equipe", "Falha",JOptionPane.ERROR_MESSAGE);
				}else if(!cheque.matches()){
					JOptionPane.showMessageDialog(null,"Preencha o campo corretamente, caso contrario não iremos notificar a equipe", "Falha",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,"Uma notificação foi enviado para a equipe com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
			}

			
		});
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnEnviar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEnviar.setBackground(new Color(79, 79, 253));
		btnEnviar.setBounds(95, 282, 117, 21);
		contentPane.add(btnEnviar);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SenhaEsquecida.class.getResource("/recursos/PesquisaSenha.png")));
		lblNewLabel_4.setBounds(35, 36, 32, 32);
		contentPane.add(lblNewLabel_4);
	}
	
	/*
	 * Metodos a parte para construção do sistema
	 */
	
	
	private Pattern verificaEmail() {
		String verificaRegx = "^(.+)@(\\S+)$"; 
		
		Pattern padrao = Pattern.compile(verificaRegx);
		return padrao;
	}
}
