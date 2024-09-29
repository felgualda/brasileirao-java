package com.futebol.principal;
import java.util.Scanner;

public class MatchMaker {

	Scanner input;
	private Time casa, visitante;
	private Partida match;
	private boolean apenasResultado;
	
	public MatchMaker() {
		this.input = new Scanner(System.in);
	}
	
	public RelatorioJogo gerarResultado(Time casa, Time visitante) {
		match = new Partida(casa, visitante);
		return iniciarPartida();
	}
	
	public MatchMaker(Time casa, Time visitante) {
		this.input = new Scanner(System.in);
		match = new Partida(casa, visitante);
	}
	
	public MatchMaker(String siglaCasa, String siglaVisitante) {
		this.input = new Scanner(System.in);
		Time casa = Configuracao.listaEquipes.encontrarTime(siglaCasa);
		Time visitante = Configuracao.listaEquipes.encontrarTime(siglaVisitante);
		this.match = new Partida(casa, visitante);
	}
	
	public RelatorioJogo iniciarPartida() {
		RelatorioJogo doc = new RelatorioJogo();
		Placar score = PartidaManager(match);
		
		//Gerar relatório de jogo
		doc.setJogoFinalizado(true);
		doc.setScoreCasa(score.getC());
		doc.setScoreVisitante(score.getV());
		doc.setTimeCasa(match.getTimes()[0]);
		doc.setTimeVisitante(match.getTimes()[1]);
		if(score.getC() == score.getV()) {
			doc.setStatus(0);
		} else if(score.getC() > score.getV()) {
			doc.setStatus(1);
		} else if(score.getC() < score.getV()) {
			doc.setStatus(2);
		}

		return doc;
	}
	
	private Placar PartidaManager(Partida partida) {
		Placar placar = new Placar(0,0);
		
		while(true) {
			
			if(!apenasResultado) {
				Configuracao.clrScr();
				if(partida.getFim()) {
					System.out.println("FIM DE JOGO");
				} else if (partida.getIntervalo()) {
					System.out.println("INTERVALO");
				} else  {
					System.out.println(Configuracao.getMatchMinutes(partida.getTempo()) + " minutos.");
				}
			}
			placar = partida.AvancarTempo();
			if(!apenasResultado) {
			System.out.println(partida.getTimes()[0].getSigla() + " " + placar.getC() + " x " +  + placar.getV() + " " + partida.getTimes()[1].getSigla());
			System.out.println("Pressione ENTER para prosseguir...");
			
			input.nextLine();
			}
			
			if(partida.getFim()) {
				break;
			}
		}
		if(!apenasResultado) {
			Configuracao.clrScr();
		}
		return placar;
	}
	
	public void setApenasResultado(boolean value) {
		this.apenasResultado = value;
	}
}
