package services;

import java.util.List;
import java.util.Scanner;

import entities.Caminhonete;
import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import enums.Status.status;

public class VeiculoService {
	static Scanner sc = new Scanner(System.in);

//	public void respMenu(List<Veiculo> List) {
//		int resp = sc.nextInt();
//		if (resp == 1) {
//			VeiculoService.printLista(List);
//		} else if (resp == 2) {
//			VeiculoService.adicionarVeiculo(List);
//		} else if (resp == 3) {
//			VeiculoService.removerVeiculo(List);
//		} else if (resp == 4) {
//			VeiculoService.alugarVeiculo(List);
//		} else if (resp == 5) {
//			VeiculoService.devolverVeiculo(List);
//		} else {
//			System.out.println("Não reconhecemos sua resposta");
//		}
//	}

	public void printLista(List<Veiculo> list) {
		System.out.println("Nossa Lista de Veículos atual é: ");
		System.out.println("-----------------------------------------------");
		int count = 1;
		for (Veiculo veiculos : list) {
			System.out.println("[" + count + "] " + veiculos.getNome() + " " + veiculos.getMarca() + " "
					+ veiculos.getAno() + " " + veiculos.getCor() + " [" + veiculos.getDisponibilidade() + "]");
			count++;
		}
		System.out.println("-----------------------------------------------");
	}

	public void popularVeiculos(List<Veiculo> list) {
		Veiculo palio1 = new Carro("Palio", "Fiat", 2019, "Preto", status.AVALIABLE, 1.0);
		list.add(palio1);
		Veiculo palio2 = new Carro("Palio", "Fiat", 2019, "Branco", status.AVALIABLE, 1.8);
		list.add(palio2);
		Veiculo palio3 = new Carro("Palio", "Fiat", 2020, "Vermelho", status.AVALIABLE, 1.8);
		list.add(palio3);
		Veiculo s10 = new Caminhonete("S10", "GM", 2018, "Preto", status.AVALIABLE, "Gasolina");
		list.add(s10);
		Veiculo hilux = new Caminhonete("Hilux", "Toyota", 2019, "Preto", status.AVALIABLE, "Diesel");
		list.add(hilux);
		Veiculo ranger = new Caminhonete("Ranger", "Ford", 2020, "Azul", status.AVALIABLE, "Diesel");
		list.add(ranger);
		Veiculo titan = new Moto("Titan", "Honda", 2017, "Vermelha", status.AVALIABLE, "160c");
		list.add(titan);
	}

	public void adicionarVeiculo(List<Veiculo> list) {
		String tipo = "";
		String resp1 = "s";
		while (resp1.equals("s")) {
			System.out.println("Este veiculo é um carro, uma caminhonete ou uma moto?");
			tipo = sc.nextLine();
			System.out.println("Qual o modelo do veículo? ");
			String modelo = sc.nextLine();
			System.out.println("Qual a marca do veiculo?");
			String marca1 = sc.nextLine();
			System.out.println("Qual o ano do veiculo?");
			int ano1 = sc.nextInt();
			System.out.println("Qual a cor do veiculo?");
			String cor = sc.nextLine();
			sc.nextLine();
			if (tipo.equals("carro")) {
				System.out.println("Qual o motor do carro?(Ex: 1.0, 1.6 ou 1.8)");
				double motor1 = sc.nextDouble();
				sc.nextLine();
				Veiculo car = new Carro(modelo, marca1, ano1, cor, status.AVALIABLE, motor1);
				list.add(car);
			} else if (tipo.equals("caminhonete")) {
				System.out.println("Qual o tipo de combustivel da caminhonete?");
				String combustivel1 = sc.nextLine();
				Veiculo car2 = new Caminhonete(modelo, marca1, ano1, cor, status.AVALIABLE, combustivel1);
				list.add(car2);
			} else if (tipo.equals("moto")) {
				System.out.println("Qual é a cilindrada da moto?");
				String cilind = sc.nextLine();
				Veiculo moto1 = new Moto(modelo, marca1, ano1, cor, status.AVALIABLE, cilind);
				list.add(moto1);
			} else {
				System.out.println("Modelo de veículo não conhecido.");
			}
			System.out.println("Deseja cadastrar um novo veículo? ");
			resp1 = sc.nextLine();
		}
	}

	public void alugarVeiculo(List<Veiculo> list) {
		String resp3 = "s";
		while (resp3.equals("s")) {
				System.out.println("Qual o numero do carro que deseja alugar?");
				int num = sc.nextInt();
				int count3 = 0;
				if (num > list.size() || num < 1) {
					System.out.println("Número inválido!");
				} else {
				for (Veiculo veiculos : list) {
					count3++;
					while (count3 == num) {
						if (veiculos.getDisponibilidade() == status.AVALIABLE) {
							veiculos.setDisponibilidade(status.UNAVALIABLE);
							System.out.println("O carro: " + veiculos.getNome() + " " + veiculos.getMarca() + " "
									+ veiculos.getAno() + " " + veiculos.getCor() + "] foi alugado com sucesso!");
							System.out.println();
							count3 += num;
						} else {
							System.out.println("O carro nao pode ser alugado pois não está disponível.");
							count3 += num;
						}
					}
				}
			}
			System.out.println("Deseja alugar outro veículo?(s/n)");
			sc.nextLine();
			resp3 = sc.nextLine();
		}
	}

	public void devolverVeiculo(List<Veiculo> List) {
		String resposta = "s";
		while (resposta.equals("s")) {
			System.out.println("Qual o numero do carro que deseja devolver?");
			int num = sc.nextInt();
			int count3 = 0;
			for (Veiculo veiculos : List) {
				count3++;
				while (count3 == num) {
					if (veiculos.getDisponibilidade() == status.UNAVALIABLE) {
						veiculos.setDisponibilidade(status.AVALIABLE);
						System.out.println("O carro: " + veiculos.getNome() + " " + veiculos.getMarca() + " "
								+ veiculos.getAno() + " " + veiculos.getCor() + "] foi devolvido com sucesso!");
						System.out.println();
						count3 += num;
					} else {
						System.out.println("O carro nao pode ser devolvido pois não está alugado.");
						count3 += num;
					}
				}
			}
			System.out.println();
			System.out.println("Deseja devolver um novo veiculo?(s/n)");
			sc.nextLine();
			resposta = sc.nextLine();
		}
	}

	public void removerVeiculo(List<Veiculo> List) {
		String resposta2 = "s";
		while (resposta2.equals("s")) {
			System.out.println("Qual o numero do carro que deseja remover?");
			int num = sc.nextInt();
			if (num > List.size() || num < 1) {
				System.out.println("Número inválido!");
			} else {
				List.remove(num - 1);
				int counter = 1;
				for (Veiculo veiculos : List) {
					System.out.println("[" + counter + "] " + veiculos.getNome() + " " + veiculos.getMarca() + " "
							+ veiculos.getAno() + " " + veiculos.getCor() + " [" + veiculos.getDisponibilidade() + "]");
					counter++;
				}
			}
			System.out.println();
			System.out.println("Deseja remover outro carro? (s/n)");
			sc.nextLine();
			resposta2 = sc.nextLine();
		}
	}
}
