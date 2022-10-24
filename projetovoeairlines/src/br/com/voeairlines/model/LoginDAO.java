package br.com.voeairlines.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.conexao.Conexao;
import br.com.voeairlines.view.ViewCadastro;

public class LoginDAO {
	
	public void verificarLogin(String login, String senha) {
		try {
			Connection conn = Conexao.criar_conexao();
			
			String sql = "select * from tbusers where usuario=? and senha =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,login);
			ps.setString(2,new String(senha));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ViewCadastro view = new ViewCadastro();
				view.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Bem vindo ao sistema " + login);
			}else {
				JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto");
			}
			ps.close();
			conn.close();
			
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}
	
	public void inserirUsuario(String login, String senha) {
		try {
			Connection conn = Conexao.criar_conexao();
			
			String sql = "insert into tbusers(usuario,senha) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,login);
			ps.setString(2,new String(senha));
			
			ps.execute();
			
			ps.close();
			conn.close();
			
			JOptionPane.showMessageDialog(null, login + " Foi cadastrado com sucesso !");
			
			
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

}
