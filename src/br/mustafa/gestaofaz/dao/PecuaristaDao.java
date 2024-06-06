package br.mustafa.gestaofaz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.mustafa.gestaofaz.model.Pecuarista;

public class PecuaristaDao {
	
	public void adicionar(Pecuarista pecuarista) throws SQLException { 

		Connection con = ConnectionFactory.getConnection();
		
		String sql = "insert pecuarista(nome, login, senha) "+" values (?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, pecuarista.getNome());
		stmt.setString(2, pecuarista.getLogin());
		stmt.setString(3, pecuarista.getSenha());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
	}
	
	public Pecuarista logar(String login, String senha) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome, login, senha from pecuarista " + " where login = ? and senha = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		ResultSet rs = stmt.executeQuery();
		
		Pecuarista p = null;
		
		if(rs.next()) {
			p = new Pecuarista();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setLogin(rs.getString("login"));
			p.setSenha(rs.getString("senha"));
		}
		
		stmt.close();
		con.close();
		return p;
		
	}
}
