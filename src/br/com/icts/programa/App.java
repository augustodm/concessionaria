package br.com.icts.programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import View.Menu;
import entities.Veiculo;
import services.VeiculoService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Veiculo> list = new ArrayList<>();
		VeiculoService servico = new VeiculoService();
		Menu menu = new Menu();
		servico.popularVeiculos(list);
		String resp1 = "s";
		while (resp1.equals("s")) {
			servico.printLista(list);
			menu.showMenu();
			int resp = sc.nextInt();
			if (resp == 1) {
				servico.printLista(list);
			} else if (resp == 2) {
				servico.adicionarVeiculo(list);
			} else if (resp == 3) {
				servico.removerVeiculo(list);
			} else if (resp == 4) {
				servico.alugarVeiculo(list);
			} else if (resp == 5) {
				servico.devolverVeiculo(list);
			} else if (resp == 6) {
				resp1 = "n";
			} else {
				System.out.println("Não reconhecemos sua resposta");
			}
			System.out.println("Deseja realizar uma nova operação? (s/n)");
			sc.nextLine();
			resp1 = sc.nextLine();
			while (!resp1.equals("s") && !resp1.equals("n")) {
				System.out.println("Resposta inválida!");
				System.out.println("Deseja realizar uma nova operação? (s/n)");
				resp1 = sc.nextLine();
			}
				
		}
		System.out.println("Operação finalizada.");
		sc.close();
	}
}
