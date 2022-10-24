package br.com.voeairlines.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.voeairlines.conexao.Conexao;

public class TipoAeronaveDAO {

	public void inserirTipo(String descricao) {
		try {
			Connection conn = Conexao.criar_conexao();

			String sql = "insert into tbtypeaeroplane(description) values (?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, descricao);

			ps.execute();

			ps.close();
			conn.close();

			JOptionPane.showMessageDialog(null, descricao + " Foi inserido com sucesso !");

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

	public void excluirTipo(int id) {
		try {
			Connection conn = Conexao.criar_conexao();

			String sql = "delete from tbtypeaeroplane where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(id);
			ps.setInt(1, id);
			ps.execute();

			ps.close();
			conn.close();

			JOptionPane.showMessageDialog(null, "O id " + id + " Foi deletado com sucesso !");

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

	public boolean listar() {

		try {
			Connection conn = Conexao.criar_conexao();

			String sql = "select * from tbtypeaeroplane";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<TipoAeronaveDTO> tipos = new ArrayList<>();

			while (rs.next()) {
				TipoAeronaveDTO t = new TipoAeronaveDTO();
				t.setId(rs.getInt("id"));
				t.setDescricao(rs.getString("descricao"));
				tipos.add(t);
			}

			ps.close();
			conn.close();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		return true;

	}

}
