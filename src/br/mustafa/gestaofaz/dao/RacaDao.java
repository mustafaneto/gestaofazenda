package br.mustafa.gestaofaz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mustafa.gestaofaz.model.Raca;

public class RacaDao {
	
	public void adicionar(Raca raca) throws SQLException {
		//Faz a conexao
		Connection con = ConnectionFactory.getConnection();
		
		//Monta a string sql
		String sql = "insert raca(nome) values (?)";
		
		//Prepara a inje��o do valor 
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, raca.getNome());
		
		// Executa o sql
		stmt.execute();
		
		// Fecha as conex�es
		stmt.close();
		con.close();
		
	}
	
	public List<Raca>listarTodos() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome from raca";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Raca raca = null;
		List<Raca> racas = new ArrayList<Raca>();
		
		while(rs.next()) {
			raca = new Raca();
			raca.setId(rs.getInt("id"));
			raca.setNome(rs.getString("nome"));
			racas.add(raca);
		}
		stmt.close();
		con.close();
		
		return racas;
	}
	
	public Raca listarUm(int id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome from raca where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Raca raca = null;
		
		if(rs.next()) {
			raca = new Raca();
			raca.setId(rs.getInt("id"));
			raca.setNome(rs.getString("nome"));
		}
		
		stmt.close();
		con.close();
		
		return raca;
	}

}
