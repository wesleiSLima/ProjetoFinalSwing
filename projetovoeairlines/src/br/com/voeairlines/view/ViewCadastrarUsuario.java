package br.com.voeairlines.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.voeairlines.model.LoginDAO;

public class ViewCadastrarUsuario extends JFrame {

	// TableUsuario tabelaUsuario = new TableUsuario();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JTable tabUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrarUsuario frame = new ViewCadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewCadastrarUsuario() {
		setResizable(false);
		setTitle("Sistema VoeAirlines - Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 457);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		JMenuItem mnCadItemAero = new JMenuItem("Cadastrar Tipo de Aeronave");
		menuCadastro.add(mnCadItemAero);

		JMenuItem mnCadAero = new JMenuItem("Cadastrar Aeronave");
		menuCadastro.add(mnCadAero);

		JMenuItem menuCadUsuario = new JMenuItem("Cadastrar Usuário");
		menuCadUsuario.setEnabled(false);
		menuCadastro.add(menuCadUsuario);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 54, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 40, 54, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 70, 54, 23);
		contentPane.add(lblNewLabel_2);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(74, 13, 51, 23);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(74, 43, 182, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		mnCadItemAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarTipo viewCadTipo = new ViewCadastrarTipo();
				viewCadTipo.setVisible(true);
				setVisible(false);
			}
		});

		mnCadAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarAeronave viewCadAeronave = new ViewCadastrarAeronave();
				viewCadAeronave.setVisible(true);
				setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Lista de usuários", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 178, 432, 207);
		contentPane.add(panel);
		panel.setLayout(null);

		// tabUsuario.setModel(tabelaUsuario);

		tabUsuario = new JTable();
		tabUsuario.setBounds(10, 21, 410, 175);
		panel.add(tabUsuario);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(74, 73, 182, 23);
		contentPane.add(txtSenha);

		JButton btncadastrar = new JButton("INSERIR");
		btncadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncadastrar.setBounds(10, 137, 105, 30);
		contentPane.add(btncadastrar);
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginDAO login = new LoginDAO();
				login.inserirUsuario(new String(txtUsuario.getText()), new String(txtSenha.getPassword()));
				txtUsuario.setText("");
				txtSenha.setText("");

			}
		});

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(118, 137, 105, 30);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnLocalizar = new JButton("LOCALIZAR");
		btnLocalizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLocalizar.setBounds(227, 137, 105, 30);
		contentPane.add(btnLocalizar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(337, 137, 105, 30);
		contentPane.add(btnLimpar);

	}
}