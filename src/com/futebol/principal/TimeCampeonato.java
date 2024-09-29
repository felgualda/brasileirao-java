package com.futebol.principal;

public class TimeCampeonato {
	private int pontuacao, saldo, partidasJogadas;
	private Time time;
	
	public TimeCampeonato(String sigla) {
		this.pontuacao = 0;
		this.saldo = 0;
		this.partidasJogadas = 0;
		this.time = Configuracao.listaEquipes.encontrarTime(sigla);
	}
	
	public void JogouPartida(int status, int gm, int gc) {
		//Status 0: empate; -1: derrota; 1: vitoria
		partidasJogadas++;
		saldo = saldo + (gm - gc);
		
		if(status == 0) {
			pontuacao += 1;
		}
		if(status == 1) {
			pontuacao += 3;
		}
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public int getPartidasJogadas() {
		return partidasJogadas;
	}
	
	public Time getTime() {
		return this.time;
	}
	
}
