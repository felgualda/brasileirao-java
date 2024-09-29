package com.futebol.principal;

public class JogoCampeonato {

	private Time c, v;
	
	public JogoCampeonato(String siglaCasa, String siglaVisitante) {
		c = Configuracao.listaEquipes.encontrarTime(siglaCasa);
		v = Configuracao.listaEquipes.encontrarTime(siglaVisitante);
	}
	
	public JogoCampeonato(Time casa, Time visitante) {
		c = casa;
		v = visitante;
	}
	
	public JogoCampeonato inverteMando() {
		JogoCampeonato jogoInvertido = new JogoCampeonato(v, c);
		return jogoInvertido;
	}
	
	public Time[] getTimes() {
		Time[] time = {c, v};
		return time;
	}
	
}
