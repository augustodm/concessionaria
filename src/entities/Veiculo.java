package entities;

import enums.Status;

public class Veiculo {
	private String nome;
	private String marca;
	private Integer ano;
	private String cor;
	private Status disponibilidade;

	public Veiculo() {

	}

	public Veiculo(String nome, String marca, Integer ano, String cor, Status disponibilidade) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
		this.disponibilidade = disponibilidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Status getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Status disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
