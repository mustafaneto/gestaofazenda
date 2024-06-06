package br.mustafa.gestaofaz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mustafa.gestaofaz.model.Lote;

public class LoteDao {
	
	public void adicionar(Lote lote) throws SQLException {
		//Faz a conexao
		Connection con = ConnectionFactory.getConnection();
		
		//Monta a string sql
		String sql = "insert lote(nome,area)" + "values (?,?)";
		
		//Prepara a injeção do valor 
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, lote.getNome());
		stmt.setFloat(2, lote.getArea());

		//Executa o sql
		stmt.execute();
		
		//Fecha as conexões
		stmt.close();
		con.close();
	}
	
	public List<Lote>listarTodos() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome, area from lote";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Lote lote = null;
		List<Lote> lotes = new ArrayList<Lote>();
		
		while(rs.next()) {
			lote = new Lote();
			lote.setId(rs.getInt("id"));
			lote.setNome(rs.getString("nome"));
			lote.setArea(rs.getFloat("area"));
			lotes.add(lote);
		}
		stmt.close();
		con.close();
		
		return lotes;
	}
	
	public Lote listarUm(int id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome, area from lote where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Lote lote = null;
		
		if (rs.next()) {
			lote = new Lote();
			lote.setId(rs.getInt("id"));
			lote.setNome(rs.getString("nome"));
			lote.setArea(rs.getFloat("area"));
		}
		
		stmt.close();
		con.close();
		
		return lote;
	}
	
	
}
