package br.com.voeairlines.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.voeairlines.model.TipoAeronaveDAO;
import br.com.voeairlines.model.TipoAeronaveDTO;
import javax.swing.DefaultComboBoxModel;

public class ViewCadastrarTipo extends JFrame {

	// TableUsuario tabelaUsuario = new TableUsuario();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtIdExcluir;
	private JTable tabelaTipo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrarTipo frame = new ViewCadastrarTipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("serial")
	public ViewCadastrarTipo() {
		setResizable(false);
		setTitle("Sistema VoeAirlines - Cadastro de Tipos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 457);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		JMenuItem mnCadItemAero = new JMenuItem("Cadastrar Tipo de Aeronave");
		mnCadItemAero.setEnabled(false);
		menuCadastro.add(mnCadItemAero);

		JMenuItem mnCadAero = new JMenuItem("Cadastrar Aeronave");
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

		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(130, 12, 43, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescricao.setBounds(10, 45, 78, 23);
		contentPane.add(lblDescricao);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(45, 12, 75, 23);
		contentPane.add(txtId);
		txtId.setColumns(10);

		mnCadAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarAeronave viewCadAeronave = new ViewCadastrarAeronave();
				viewCadAeronave.setVisible(true);
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

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (verificaVazio(txtIdExcluir)) {
					TipoAeronaveDTO tipos = new TipoAeronaveDTO();
					tipos.setId(Integer.parseInt(txtIdExcluir.getText()));

					TipoAeronaveDAO tipo = new TipoAeronaveDAO();
					tipo.excluirTipo(tipos.getId());
					txtIdExcluir.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "o campo deve ser preenchido para exclusao");
				}

			}
		});
		btnExcluir.setBounds(118, 137, 105, 30);
		contentPane.add(btnExcluir);

		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new TitledBorder(null, "Lista de  Tipos de Aeronaves", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelTipo.setBounds(10, 178, 433, 207);
		contentPane.add(panelTipo);
		panelTipo.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 413, 172);
		panelTipo.add(scrollPane);

		tabelaTipo = new JTable();

		tabelaTipo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Id", "Descrição"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaTipo.getColumnModel().getColumn(0).setResizable(false);
		tabelaTipo.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tabelaTipo);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(90, 45, 352, 23);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		JButton btncadastrar = new JButton("INSERIR");
		btncadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncadastrar.setBounds(10, 137, 105, 30);
		contentPane.add(btncadastrar);
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(txtDescricao.getText());

				if (verificaVazio(txtDescricao)) {
					TipoAeronaveDTO tipos = new TipoAeronaveDTO();
					tipos.setDescricao(new String(txtDescricao.getText()));

					TipoAeronaveDAO tipo = new TipoAeronaveDAO();
					tipo.inserirTipo(tipos.getDescricao());
					txtDescricao.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "o campo Descrição deve ser preenchido");
				}
			}
		});

		JButton btnLocalizar = new JButton("LOCALIZAR");
		btnLocalizar.setEnabled(false);
		btnLocalizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLocalizar.setBounds(227, 137, 105, 30);
		contentPane.add(btnLocalizar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setEnabled(false);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(337, 137, 105, 30);
		contentPane.add(btnLimpar);

		String lista[] = { "Avião de Guerra", "Avião Comercial" };
		
		
		TipoAeronaveDAO combo = new TipoAeronaveDAO();

		JLabel lblIdExcluir = new JLabel("Digite aqui o Id para exclusão");
		lblIdExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdExcluir.setBounds(10, 95, 209, 23);
		contentPane.add(lblIdExcluir);

		txtIdExcluir = new JTextField();
		txtIdExcluir.setBounds(227, 98, 75, 20);
		contentPane.add(txtIdExcluir);
		txtIdExcluir.setColumns(10);
		
		JComboBox comboTipo = new JComboBox(lista);
		comboTipo.setBounds(174, 14, 269, 22);
		contentPane.add(comboTipo);
	}

	// método para ferificar se um campo está vazio
	protected boolean verificaVazio(JTextField campo) {
		return campo.getText() != null && !campo.getText().trim().isEmpty();
	}
}