package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.conexao.Conexao;
import br.com.voeairlines.view.LoginView;

public class ValidaSenha {

	public static boolean ValidarSenha() {
		
		try {
			Connection conn = Conexao.criar_conexao();
			
			String sql = "select * from tbusers where usuario=? and senha =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			LoginView window = new LoginView();
			ps.setString(1,window.txtlogin.getText());
			ps.setString(2,new String(window.txtsenha.getPassword()));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Bem vindo ao sistema");
			}else {
				JOptionPane.showMessageDialog(null, "Usuário incorreto");
			}
			ps.close();
			conn.close();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return true;
		
	}

}
