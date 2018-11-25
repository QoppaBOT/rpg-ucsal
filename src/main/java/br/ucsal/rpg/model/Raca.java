package br.ucsal.rpg.model;

public class Raca {
	private Integer id;
	private String nome;
	private Integer forca;
	private Integer destreza;
	private Integer contituicao;
	private Integer inteligencia;
	private Integer percepicao;
	private Integer carisma;

	public Raca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Raca(Integer id, String nome, Integer forca, Integer destreza, Integer contituicao, Integer inteligencia,
			Integer percepicao, Integer carisma) {
		super();
		this.id = id;
		this.nome = nome;
		this.forca = forca;
		this.destreza = destreza;
		this.contituicao = contituicao;
		this.inteligencia = inteligencia;
		this.percepicao = percepicao;
		this.carisma = carisma;
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

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getDestreza() {
		return destreza;
	}

	public void setDestreza(Integer destreza) {
		this.destreza = destreza;
	}

	public Integer getContituicao() {
		return contituicao;
	}

	public void setContituicao(Integer contituicao) {
		this.contituicao = contituicao;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Integer getPercepicao() {
		return percepicao;
	}

	public void setPercepicao(Integer percepicao) {
		this.percepicao = percepicao;
	}

	public Integer getCarisma() {
		return carisma;
	}

	public void setCarisma(Integer carisma) {
		this.carisma = carisma;
	}

}
