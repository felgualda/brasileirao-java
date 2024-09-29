package com.futebol.principal;
import java.util.Random;

public class Partida {
	
	private int tempoAtual = 0;		//0 = partida não começou
	private boolean intervalo, fim;
	private Time casa, visitante;
	private Placar placar = new Placar(0,0);
	private Random randomNumbers;
	
	public Partida(Time timeCasa, Time timeVisitante) {
		this.casa = timeCasa;
		this.visitante = timeVisitante;
		randomNumbers = new Random();
		
		this.intervalo = false;
		this.fim = false;
	}
	
    public int golsPoisson(double lambda) {
        int gols = 0;
        double limite = Math.exp(-lambda);
        double p = 1.0;
        
        do {
            p *= randomNumbers.nextDouble();
            if (p > limite) {
                gols++;
            }
        } while (p > limite);
        
        return gols;
    }

	public Placar AvancarTempo() {
		
		if(tempoAtual == 0) {
			tempoAtual++;
			return placar;
		}
		
		if(tempoAtual == Configuracao.duracaoPartida - 1) {
			fim = true;
			return placar;
		}
		
		if(tempoAtual == ((Configuracao.duracaoPartida / 2))) {
			if(intervalo) {
				intervalo = false;
				tempoAtual++;
			} else {
				intervalo = true;
			}
			return placar;
		}
		
		double lambdaPorFracao = Configuracao.mediaGolsPartida / (Configuracao.duracaoPartida - 1);
		double lambdaCasa = lambdaPorFracao * (1 + casa.getNivelMult()) * (1 + Configuracao.fatorCasa);
		double lambdaVisitante = lambdaPorFracao * (1 + visitante.getNivelMult());
		
		int golsCasa = golsPoisson(lambdaCasa);
		placar.setC(placar.getC() + golsCasa);
		
		lambdaVisitante = (golsCasa > 0) ? lambdaPorFracao * (1 - Configuracao.penalidadeGolAdversario) : lambdaPorFracao;
		
		placar.setV(placar.getV() + golsPoisson(lambdaVisitante));
		tempoAtual++;
		
		return placar;
	}
	
	public int getTempo() {
		return tempoAtual;
	}
	public boolean getIntervalo() {
		return intervalo;
	}
	public boolean getFim() {
		return fim;
	}
	public Time[] getTimes() {
		Time[] timeArray = {casa, visitante};
		return timeArray;
	}
	
}
