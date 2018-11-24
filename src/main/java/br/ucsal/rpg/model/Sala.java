package br.ucsal.rpg.model;

public class Sala {

	private Integer id;
	private Mestre mestre;
	private Monstro monstro;

	private String nome;
	private String senha;
	private String descricao;

	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sala(Integer id, Mestre mestre, Monstro monstro, String nome, String senha, String descricao) {
		super();
		this.id = id;
		this.mestre = mestre;
		this.monstro = monstro;
		this.nome = nome;
		this.senha = senha;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mestre getMestre() {
		return mestre;
	}

	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Monstro getMonstro() {
		return monstro;
	}


	public void setMonstro(Monstro monstro) {
		this.monstro = monstro;
	}

}
