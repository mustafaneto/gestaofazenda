package br.mustafa.gestaofaz.model;

public class Lote {
	
	private int id;
	private String nome;
	private Float area;
	
	public Lote() {
		
	}
	
	public Lote(int id, String nome, Float area) {
		super();
		this.id = id;
		this.nome = nome;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}
	
	
}
