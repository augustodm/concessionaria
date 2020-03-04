package entities;

import enums.Status.status;

public class Carro extends Veiculos {
	private Double motor;

	public Carro() {
		super();
	}

	public Carro(String nome, String marca, Integer ano, String cor, status disponibilidade, Double motor) {
		super(nome, marca, ano, cor, disponibilidade);
		this.motor = motor;
	}

	public Double getMotor() {
		return motor;
	}

	public void setMotor(Double motor) {
		this.motor = motor;
	}

}
