package br.ucsal.rpg.model;

public class Dangeon {
	private Integer id;
	private String nome;
	private Monstro monstro;
	private String descricao;

	public Dangeon() {
		super();
	}

	public Dangeon(Integer id, String nome, Monstro monstro, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.monstro = monstro;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the monstro
	 */
	public Monstro getMonstro() {
		return monstro;
	}

	/**
	 * @param monstro the monstro to set
	 */
	public void setMonstro(Monstro monstro) {
		this.monstro = monstro;
	}

}
