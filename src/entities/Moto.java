package entities;

import enums.Status;

public class Moto extends Veiculo {
	private String cilindrada;

	public Moto() {
		super();
	}

	public Moto(String nome, String marca, Integer ano, String cor, Status disponibilidade, String cilindrada) {
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
