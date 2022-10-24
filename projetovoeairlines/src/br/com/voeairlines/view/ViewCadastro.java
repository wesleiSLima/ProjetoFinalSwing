package br.com.voeairlines.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewCadastro extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private final Action action = new SwingAction();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
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
	public ViewCadastro() {
		setResizable(false);
		setTitle("Sistema VoeAirlines - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 457);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		JMenuItem mnCadItemAeronave = new JMenuItem("Cadastrar Tipo de Aeronave");
		menuCadastro.add(mnCadItemAeronave);

		JMenuItem mnCadAeronave = new JMenuItem("Cadastrar Aeronave");
		menuCadastro.add(mnCadAeronave);

		JMenuItem mnCadUsuario = new JMenuItem("Cadastrar Usuário");
		menuCadastro.add(mnCadUsuario);
		
		JMenu mnNewMenu = new JMenu("Sair");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnCadItemAeronave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarTipo viewCadTipo = new ViewCadastrarTipo();
				viewCadTipo.setVisible(true);
				setVisible(false);
			}
		});
		
		mnCadAeronave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarAeronave viewCadAeronave = new ViewCadastrarAeronave();
				viewCadAeronave.setVisible(true);
				setVisible(false);
			}
		});

		mnCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarUsuario viewCadUsuario = new ViewCadastrarUsuario();
				viewCadUsuario.setVisible(true);
				setVisible(false);
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 251, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
