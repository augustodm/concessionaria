package entities;

import enums.Status.status;

public class Moto extends Veiculos {
	private String cilindrada;

	public Moto() {
		super();
	}

	public Moto(String nome, String marca, Integer ano, String cor, status disponibilidade, String cilindrada) {
		super(nome, marca, ano, cor, disponibilidade);
		this.cilindrada = cilindrada;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

}
