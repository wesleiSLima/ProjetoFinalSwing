package br.com.voeairlines.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.voeairlines.model.AeronaveDAO;

public class ViewCadastrarAeronave extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtFabricante;
	private JTable tabUsuario;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	private JComboBox<String> comboTipo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrarAeronave frame = new ViewCadastrarAeronave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewCadastrarAeronave() {
		setResizable(false);
		setTitle("Sistema VoeAirlines - Cadastro de Aeronave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 457);
		restauraCombo();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		JMenuItem mnCadItemAero = new JMenuItem("Cadastrar Tipo de Aeronave");
		menuCadastro.add(mnCadItemAero);

		JMenuItem mnCadAero = new JMenuItem("Cadastrar Aeronave");
		mnCadAero.setEnabled(false);
		menuCadastro.add(mnCadAero);

		JMenuItem menuCadUsuario = new JMenuItem("Cadastrar Usuário");
		menuCadastro.add(menuCadUsuario);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(10, 12, 23, 23);
		contentPane.add(lblId);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(130, 12, 43, 23);
		contentPane.add(lblTipo);

		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFabricante.setBounds(10, 45, 78, 23);
		contentPane.add(lblFabricante);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(45, 12, 75, 23);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(118, 137, 105, 30);
		contentPane.add(btnExcluir);

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		mnCadItemAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarTipo viewCadTipo = new ViewCadastrarTipo();
				viewCadTipo.setVisible(true);
				setVisible(false);
			}
		});

		menuCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarUsuario viewCadUsuario = new ViewCadastrarUsuario();
				viewCadUsuario.setVisible(true);
				setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Lista de Aeronaves", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 178, 433, 207);
		contentPane.add(panel);
		panel.setLayout(null);

		// tabUsuario.setModel(tabelaUsuario);

		tabUsuario = new JTable();
		tabUsuario.setBounds(10, 21, 412, 175);
		panel.add(tabUsuario);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(90, 45, 350, 23);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);

		JButton btncadastrar = new JButton("INSERIR");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fabricante = txtFabricante.getText();
				String modelo = txtModelo.getText();
				String codigo = txtCodigo.getText();

			}
		});
		btncadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncadastrar.setBounds(10, 137, 105, 30);
		contentPane.add(btncadastrar);

		JButton btnAdicionar = new JButton("LOCALIZAR");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setBounds(227, 137, 105, 30);
		contentPane.add(btnAdicionar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(337, 137, 105, 30);
		contentPane.add(btnLimpar);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(10, 75, 78, 23);
		contentPane.add(lblModelo);

		txtModelo = new JTextField();
		txtModelo.setBounds(90, 76, 350, 23);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(10, 106, 56, 23);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(90, 106, 123, 23);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		comboTipo = new JComboBox<>();
		comboTipo.setBounds(168, 12, 272, 22);
		contentPane.add(comboTipo);
	}

	Vector<Integer> idTipo = new Vector<Integer>();

	public void restauraCombo() {
		
		try {
			AeronaveDAO lista = new AeronaveDAO();
			ResultSet rs = lista.listarTipos();
			
			while(rs.next()) {
				idTipo.addElement(rs.getInt(1));
				comboTipo.addItem(rs.getString(2));

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Carregar Combo  " + ex.getMessage());
		}
	}
}