package br.mustafa.gestaofaz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mustafa.gestaofaz.model.Animal;
import br.mustafa.gestaofaz.model.Lote;
import br.mustafa.gestaofaz.model.Raca;

public class AnimalDao {
	
	public void adicionar(Animal animal) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "insert animal(nome, peso, idraca, idlote)" + "values (?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, animal.getNome());
		stmt.setFloat(2, animal.getPeso());
		stmt.setInt(3, animal.getRaca().getId());
		stmt.setInt(4, animal.getLote().getId());

		
		stmt.execute();
		
		stmt.close();
		con.close();
	}
	
	public void alterar(Animal animal) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
	    String sql = "UPDATE animal SET nome = ?, peso = ?, idraca = ?, idlote = ? WHERE id = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    
	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, animal.getNome());
	    stmt.setFloat(2, animal.getPeso());
	    stmt.setInt(3, animal.getRaca().getId());
	    stmt.setInt(4, animal.getLote().getId());
	    stmt.setInt(5, animal.getId());
	    
	    stmt.execute();
	    stmt.close();
	    con.close();
	}
	
	
	
	public List<Animal>listarTodos() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome, peso, idraca, idlote from animal";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Animal animal = null;
		RacaDao racDao = new RacaDao();
		LoteDao lotDao = new LoteDao();

		List<Animal> animais = new ArrayList<Animal>();
		
		while(rs.next()) {
			animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setPeso(rs.getFloat("peso"));
			animal.setRaca(racDao.listarUm(rs.getInt("idraca")));
			animal.setLote(lotDao.listarUm(rs.getInt("idlote")));
			animais.add(animal);
		}
        
		stmt.close();
		con.close();
		
		return animais;
		
	}
	
	public void excluir(int id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "delete from animal where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
	}
	
	
	public Animal listarUm(int id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, peso, idraca, idlote FROM "+" animal WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Animal animal = null;
		
		if(rs.next()) {
			animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setPeso(rs.getFloat("peso"));
			
			int idraca = rs.getInt("idraca");
			int idlote = rs.getInt("idlote");
			
			Raca raca = null;
			RacaDao racDao = new RacaDao();
			raca = racDao.listarUm(idraca);
			
			Lote lote = null;
			LoteDao lotDao = new LoteDao();
			lote = lotDao.listarUm(idlote);
			
			animal.setRaca(raca);
			animal.setLote(lote);
		}
		stmt.close();
		con.close();
		
		return animal;
	}
}
