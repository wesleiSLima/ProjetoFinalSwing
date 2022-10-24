package br.com.voeairlines.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;

import br.com.voeairlines.conexao.Conexao;

public class AeronaveDAO {

	public void inserirAeronave(int idTipo, String fabricante, String modelo, String codigo, TipoAeronaveDTO tipo) {
		try {
			Connection conn = Conexao.criar_conexao();

			String sql = "insert into tbaeroplane(idtipo,manufactory,modelaeroplane,code) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, idTipo);
			ps.setString(2, fabricante);
			ps.setString(3, modelo);
			ps.setString(4, codigo);

			ps.execute();

			ps.close();
			conn.close();

			JOptionPane.showMessageDialog(null, "Inserido com sucesso !");

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

	public ResultSet listarTipos() {
		try {
			Connection conn = Conexao.criar_conexao();

			String sql = "select * from tbtypeaeroplane";
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeQuery();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Listar Tipo  " + ex.getMessage());

		}
		return null;

	}

}
