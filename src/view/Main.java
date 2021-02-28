package view;

import java.util.Scanner;

import controller.ProcessosController;

public class Main {

	public static void main(String[] args) {
		ProcessosController procControl = new ProcessosController();
		Scanner leitura = new Scanner(System.in);
		String os = procControl.SoReader();
		System.out.println("Seu sistema operacional: " + os + "\nTecle 1 para visualizar os processos em andamento");
		String option = leitura.next();
		while (! "1" .equals(option)) {
			System.out.println("Acao invalida, tecle 1 para visualizar os processos em andamento");
			option = leitura.next();
		}
		procControl.ListaProcessosPorSo(os);
		System.out.println("\nTodos os processos listados, agora se desejar encerrar algum informe o nome ou PID dele");
		String namePid = leitura.next();
		procControl.MataProcessoPorSo(os,namePid);	
		System.out.println("feito.");
		System.exit(0);
		leitura.close();
	}

}
