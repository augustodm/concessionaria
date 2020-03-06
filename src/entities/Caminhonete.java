package entities;

import enums.Status;

public class Caminhonete extends Veiculo {
	private String combustivel;

	public Caminhonete() {
		super();
	}

	public Caminhonete(String nome, String marca, Integer ano, String cor, Status disponibilidade, String combustivel) {
		super(nome, marca, ano, cor, disponibilidade);
		this.combustivel = combustivel;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	
}
