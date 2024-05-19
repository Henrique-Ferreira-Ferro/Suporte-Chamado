package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblHora;
	private JDesktopPane Interno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/recursos/suporte-tecnico.png")));
		setTitle("Suporte");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				lblHora.setText(sdf.format(data));
			}
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		Interno = new JDesktopPane();
		Interno.setBackground(new Color(192, 192, 192));
		Interno.setBounds(0, 0, 695, 640);
		contentPane.add(Interno);
		
		
		JMenuItem menuCadastroUsuario = new JMenuItem("Cadastro Usuario");
		menuCadastroUsuario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroUsuario usuario = null;
				usuario = new CadastroUsuario();
				usuario.setVisible(true);
				Interno.add(usuario);
				
			}
		});
		mnNewMenu.add(menuCadastroUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastro Senhas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroSenhas cad = new CadastroSenhas();
				cad.setVisible(true);
				Interno.add(cad);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("Chamado");
		mnNewMenu_4.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Abrir Chamado");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_4.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Pesquisa");
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Senhas");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PesquisaSenha senha = new PesquisaSenha();
				senha.setVisible(true);
				Interno.add(senha);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Chamados");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PesquisaChamado chamado = new PesquisaChamado();
				chamado.setVisible(true);
				Interno.add(chamado);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Ajuda");
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sobre");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Como usar o sistema");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Opções");
	
		mnNewMenu_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem btnSair = new JMenuItem("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
				
				if(escolha == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 12));
		mnNewMenu_3.add(btnSair);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(79, 79, 253));
		panel.setBounds(693, 0, 314, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/recursos/suporte-tecnico.png")));
		lblNewLabel.setBounds(84, 203, 128, 127);
		panel.add(lblNewLabel);
		
		lblHora = new JLabel("Hora ");
		lblHora.setFont(new Font("Arial", Font.BOLD, 20));
		lblHora.setForeground(new Color(255, 255, 255));
		lblHora.setBounds(84, 75, 153, 26);
		panel.add(lblHora);
		
		 lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Arial", Font.BOLD, 20));
		lblNome.setBounds(38, 460, 253, 26);
		panel.add(lblNome);
		
		
		
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}
}
