package view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrinUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel lblNome;
	private JLabel lblHora;
	private JDesktopPane Interno;

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrinUsuario frame = new TelaPrinUsuario();
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
	public TelaPrinUsuario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				lblHora.setText(sdf.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrinUsuario.class.getResource("/recursos/encontro.png")));
		setTitle("Suporte - Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(79, 79, 253));
		panel.setBounds(695, 23, 312, 640);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrinUsuario.class.getResource("/recursos/encontro.png")));
		lblNewLabel.setBounds(84, 203, 128, 127);
		panel.add(lblNewLabel);

		lblHora = new JLabel("Hora ");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Arial", Font.BOLD, 20));
		lblHora.setBounds(84, 75, 153, 26);
		panel.add(lblHora);

		lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.BOLD, 20));
		lblNome.setBounds(51, 440, 253, 26);
		panel.add(lblNome);

		JLabel lblAvisos = new JLabel("Seja Bem-Vindo!");
		lblAvisos.setForeground(Color.WHITE);
		lblAvisos.setFont(new Font("Arial", Font.BOLD, 20));
		lblAvisos.setBounds(71, 375, 174, 26);
		panel.add(lblAvisos);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1007, 23);
		contentPane.add(menuBar);

		JMenu mnNewMenu_4 = new JMenu("Chamado");
		mnNewMenu_4.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Gerenciar Chamados");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirChamadoUsuario chamado = new AbrirChamadoUsuario();
				chamado.setVisible(true);
				Interno.add(chamado);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.BOLD, 12));
		mnNewMenu_4.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem = new JMenuItem("Acompanhar Chamados");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcompanharChamado acompanhaChamado = new AcompanharChamado();
				acompanhaChamado.setVisible(true);
				Interno.add(acompanhaChamado);
			}
		});
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 12));
		mnNewMenu_4.add(mntmNewMenuItem);

		JMenu mnNewMenu_2 = new JMenu("Ajuda");
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sobre");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);

			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_3 = new JMenu("Opções");
		mnNewMenu_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_3);

		JMenuItem btnSair = new JMenuItem("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
						JOptionPane.YES_NO_OPTION);

				if (escolha == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 12));
		mnNewMenu_3.add(btnSair);

		Interno = new JDesktopPane();
		Interno.setBackground(Color.LIGHT_GRAY);
		Interno.setBounds(0, 23, 695, 640);
		contentPane.add(Interno);
	}
}
