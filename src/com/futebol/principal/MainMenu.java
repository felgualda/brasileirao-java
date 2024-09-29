package com.futebol.principal;
import java.util.Scanner;

public class MainMenu {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		/*MatchMaker game = new MatchMaker("BOT","PAL");
		RelatorioJogo teste = game.IniciarPartida();
		
		System.out.println("Relatório de jogo:");
		if(teste.getStatus() == 0) {
			System.out.println("EMPATE");
		}
		if(teste.getStatus() == 1) {
			System.out.println("VITÓRIA DE " + teste.getTimeCasa().getNome() + " (Casa)");
		}
		if(teste.getStatus() == 2) {
			System.out.println("VITÓRIA DE " + teste.getTimeVisitante().getNome() + " (Visitante)");
		}
		System.out.println("PLACAR FINAL: " + teste.getScoreCasa() + " x " + teste.getScoreVisitante());*/
		
		Brasileirao brasileirao = new Brasileirao();
		
		System.out.println("RODADA 0");
		System.out.println();
		brasileirao.ordenarTabela();
		brasileirao.exibirTabela();
		System.out.println();
		System.out.println("Pressione ENTER para prosseguir...");
		
		input.nextLine();
		
		while(true) {
			System.out.println("RODADA " + brasileirao.getRodada());
			System.out.println();
			brasileirao.simularRodada();
			brasileirao.ordenarTabela();
			brasileirao.exibirTabela();
			System.out.println();
			System.out.println("Pressione ENTER para prosseguir...");
			
			input.nextLine();
		}

	}
	
}
