package br.com.voeairlines.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection criar_conexao() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_voeairlines","root","");
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
			
		}
	}

}
