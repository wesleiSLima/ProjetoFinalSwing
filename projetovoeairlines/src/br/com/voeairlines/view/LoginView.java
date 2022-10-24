package br.com.voeairlines.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.voeairlines.model.LoginDAO;

public class LoginView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public JFrame frmSistemaVoeairlines;
	public JTextField txtlogin;
	public JPasswordField txtsenha;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frmSistemaVoeairlines.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginView() {
		initialize();
	}
	
	private void initialize() {
		frmSistemaVoeairlines = new JFrame();
		frmSistemaVoeairlines.setTitle("Sistema VoeAirlines");
		frmSistemaVoeairlines.setBounds(100, 100, 415, 376);
		frmSistemaVoeairlines.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaVoeairlines.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(65, 44, 70, 25);
		frmSistemaVoeairlines.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(65, 146, 70, 25);
		frmSistemaVoeairlines.getContentPane().add(lblSenha);
		
		txtlogin = new JTextField();
		txtlogin.setBounds(65, 80, 260, 30);
		frmSistemaVoeairlines.getContentPane().add(txtlogin);
		txtlogin.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(65, 182, 260, 30);
		frmSistemaVoeairlines.getContentPane().add(txtsenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(151, 251, 89, 23);
		frmSistemaVoeairlines.getContentPane().add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginDAO login = new LoginDAO();
				login.verificarLogin(new String (txtlogin.getText()), new String (txtsenha.getPassword()));
				txtlogin.setText("");
				txtsenha.setText("");
				frmSistemaVoeairlines.setVisible(false);
			}
		});

	}

}
