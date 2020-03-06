package entities;

import enums.Status;

public class Carro extends Veiculo {
	private Double motor;

	public Carro() {
		super();
	}

	public Carro(String nome, String marca, Integer ano, String cor, Status disponibilidade, Double motor) {
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
