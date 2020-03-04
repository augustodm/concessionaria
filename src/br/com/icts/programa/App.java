package br.com.icts.programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Caminhonete;
import entities.Carro;
import entities.Moto;
import entities.Veiculos;
import enums.Status.status;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Veiculos> list = new ArrayList<>();
		Veiculos palio1 = new Carro("Palio", "Fiat", 2019, "Preto", status.AVALIABLE, 1.0);
		list.add(palio1);
		Veiculos palio2 = new Carro("Palio", "Fiat", 2019, "Branco", status.AVALIABLE, 1.8);
		list.add(palio2);
		Veiculos palio3 = new Carro("Palio", "Fiat", 2020, "Vermelho", status.AVALIABLE, 1.8);
		list.add(palio3);
		Veiculos s10 = new Caminhonete("S10", "GM", 2018, "Preto", status.AVALIABLE, "Gasolina");
		list.add(s10);
		Veiculos hilux = new Caminhonete("Hilux", "Toyota", 2019, "Preto", status.AVALIABLE, "Diesel");
		list.add(hilux);
		Veiculos ranger = new Caminhonete("Ranger", "Ford", 2020, "Azul", status.AVALIABLE, "Diesel");
		list.add(ranger);
		Veiculos titan = new Moto("Titan", "Honda", 2017, "Vermelha", status.AVALIABLE, "160c");
		list.add(titan);
		System.out.println("Veículos de nossa concessionaria:");
		System.out.println();
		int count = 1;
		for (Veiculos veiculos : list) {
			System.out.println("[" + count + "] " + veiculos.getNome() + " " + veiculos.getMarca() + " "
					+ veiculos.getAno() + " " + veiculos.getCor() + " [" + veiculos.getDisponibilidade() + "]");
			count++;
		}
		String tipo = "";
		System.out.println();
		System.out.println("Deseja cadastrar um veiculo? (s/n)");
		String resp1 = sc.nextLine();
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
				Veiculos car = new Carro(modelo, marca1, ano1, cor, status.AVALIABLE, motor1);
				list.add(car);
			} else if (tipo.equals("caminhonete")) {
				System.out.println("Qual o tipo de combustivel da caminhonete?");
				String combustivel1 = sc.nextLine();
				Veiculos car2 = new Caminhonete(modelo, marca1, ano1, cor, status.AVALIABLE, combustivel1);
				list.add(car2);
			} else if (tipo.equals("moto")) {
				System.out.println("Qual é a cilindrada da moto?");
				String cilind = sc.nextLine();
				Veiculos moto1 = new Moto(modelo, marca1, ano1, cor, status.AVALIABLE, cilind);
				list.add(moto1);
			} else {
				System.out.println("Modelo de veículo não conhecido.");
			}
			System.out.println("Deseja cadastrar um novo veículo? ");
			resp1 = sc.nextLine();
		}
		System.out.println("Sua nova lista de carros é :");
		int count2 = 1;
		for (Veiculos veiculos : list) {
			System.out.println("[" + count2 + "] " + veiculos.getNome() + " " + veiculos.getMarca() + " "
					+ veiculos.getAno() + " " + veiculos.getCor() + " [" + veiculos.getDisponibilidade() + "]");
			count2++;
		}
		System.out.println();
		System.out.println("Deseja alugar um veiculo?(s/n)");
		String resp3 = sc.nextLine();
		while (resp3.equals("s")) {
			System.out.println("Qual o numero do carro que deseja alugar?");
			int num = sc.nextInt();
			int count3 = 0;
			for (Veiculos veiculos : list) {
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
			System.out.println("Deseja alugar outro veículo?(s/n)");
			sc.nextLine();
			resp3 = sc.nextLine();
		}
		System.out.println("Lista atualizada:");
		int count5 = 1;
		for (Veiculos veiculos : list) {
			System.out.println("[" + count5 + "] " + veiculos.getNome() + " " + veiculos.getMarca() + " "
					+ veiculos.getAno() + " " + veiculos.getCor() + " [" + veiculos.getDisponibilidade() + "]");
			count5++;
		}

		System.out.println();
		System.out.println("Deseja devolver um veiculo?(s/n)");
		String resposta = sc.nextLine();
		while (resposta.equals("s")) {
			System.out.println("Qual o numero do carro que deseja devolver?");
			int num = sc.nextInt();
			int count3 = 0;
			for (Veiculos veiculos : list) {
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

		System.out.println();
		System.out.println("Deseja remover um veiculo?(s/n)");
		String resposta2 = sc.nextLine();
		while (resposta2.equals("s")) {
			System.out.println("Qual o numero do carro que deseja remover?");
			int num = sc.nextInt();
			list.remove(num - 1);
			int counter = 1;
			for (Veiculos veiculos : list) {
				System.out.println("[" + counter + "] " + veiculos.getNome() + " " + veiculos.getMarca() + " "
						+ veiculos.getAno() + " " + veiculos.getCor() + " [" + veiculos.getDisponibilidade() + "]");
				counter++;
			}
			System.out.println();
			System.out.println("Deseja remover outro carro? (s/n)");
			resposta2 = sc.nextLine();
			sc.nextLine();
		}

		sc.close();
	}
}
