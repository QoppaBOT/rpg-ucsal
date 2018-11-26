package br.ucsal.rpg.model;

public class Sala {

	private Integer id;
	private Mestre mestre;
	private Dangeon dangeon;
	private String nome;
	private String senha;
	private String descricao;

	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sala(Integer id, Mestre mestre, Monstro monstro, Dangeon dangeon, String nome, String senha,
			String descricao) {
		super();
		this.id = id;
		this.mestre = mestre;
		this.dangeon = dangeon;
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

	public Dangeon getDangeon() {
		return dangeon;
	}

	public void setDangeon(Dangeon dangeon) {
		this.dangeon = dangeon;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", mestre=" + mestre + ", dangeon=" + dangeon + ", nome=" + nome + ", senha=" + senha
				+ ", descricao=" + descricao + "]";
	}

}
