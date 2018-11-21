package br.ucsal.rpg.model;

public class Personagem {
	private Integer id;
	private String nome;
	private Raca Raca;
	private String maiorPersonalidade;
	// Pontos de vida
	private Integer pontosDeVida;
	private Integer pontosDeEnergia;
	private Integer XP;
	private Integer level;

	public Personagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personagem(Integer id, String nome, br.ucsal.rpg.model.Raca raca, String maiorPersonalidade, Integer pontosDeVida,
			Integer pontosDeEnergia, Integer xP, Integer level) {
		super();
		this.id = id;
		this.nome = nome;
		Raca = raca;
		this.maiorPersonalidade = maiorPersonalidade;
		this.pontosDeVida = pontosDeVida;
		this.pontosDeEnergia = pontosDeEnergia;
		XP = xP;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Personagem [id=" + id + ", nome=" + nome + ", Raca=" + Raca + ", maiorPersonalidade="
				+ maiorPersonalidade + ", pontosDeVida=" + pontosDeVida + ", pontosDeEnergia=" + pontosDeEnergia
				+ ", XP=" + XP + ", level=" + level + "]";
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

	public Raca getRaca() {
		return Raca;
	}

	public void setRaca(Raca raca) {
		Raca = raca;
	}

	public String getMaiorPersonalidade() {
		return maiorPersonalidade;
	}

	public void setMaiorPersonalidade(String maiorPersonalidade) {
		this.maiorPersonalidade = maiorPersonalidade;
	}

	public Integer getPontosDeVida() {
		return pontosDeVida;
	}

	public void setPontosDeVida(Integer pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}

	public Integer getPontosDeEnergia() {
		return pontosDeEnergia;
	}

	public void setPontosDeEnergia(Integer pontosDeEnergia) {
		this.pontosDeEnergia = pontosDeEnergia;
	}

	public Integer getXP() {
		return XP;
	}

	public void setXP(Integer xP) {
		XP = xP;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
