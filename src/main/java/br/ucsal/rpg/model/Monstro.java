package br.ucsal.rpg.model;

public class Monstro {

	private Integer id;
	private String nome;
	private Integer pontosDeVida;
	private String descricao;

	public Monstro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monstro(Integer id, String nome, Integer pontosDeVida, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pontosDeVida = pontosDeVida;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontosDeVida() {
		return pontosDeVida;
	}

	public void setPontosDeVida(Integer pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Monstro [id=" + id + ", nome=" + nome + ", pontosDeVida=" + pontosDeVida + ", descricao=" + descricao
				+ "]";
	}

}
