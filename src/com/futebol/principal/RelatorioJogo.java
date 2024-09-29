package com.futebol.principal;

public class RelatorioJogo {
	private boolean jogoFinalizado;
	private int status; 						//0: empate; 1: vitoria Casa; 2: vitoria Visitante
	private Time timeCasa, timeVisitante;
	private int scoreCasa, scoreVisitante;
	
	public RelatorioJogo() {
		jogoFinalizado = false;
	}

	public boolean isJogoFinalizado() {
		return jogoFinalizado;
	}

	public void setJogoFinalizado(boolean jogoFinalizado) {
		this.jogoFinalizado = jogoFinalizado;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public int getScoreCasa() {
		return scoreCasa;
	}

	public void setScoreCasa(int scoreCasa) {
		this.scoreCasa = scoreCasa;
	}

	public int getScoreVisitante() {
		return scoreVisitante;
	}

	public void setScoreVisitante(int scoreVisitante) {
		this.scoreVisitante = scoreVisitante;
	}
	
	
	
}
