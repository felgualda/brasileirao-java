package com.futebol.principal;

public class Time {

	public Time(String nome, String sigla, Configuracao.Nivel nivel) {
		this.nome = nome;
		this.sigla = sigla;
		this.nivel = nivel;
	}
	
	private String nome;
	private String sigla;
	private Configuracao.Nivel nivel;
	
	public String getNome() {
		return nome;
	}

	public double getNivelMult() {
		switch(nivel) {
			case ALTO:
				return Configuracao.nivelAlto;
			case MEDIO:
				return Configuracao.nivelMedio;
			case BAIXO:
				return Configuracao.nivelBaixo;
			default:
				return 0;
		}
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public boolean compareTime(Time time) {
		if(time.nome.equals(this.nome) && time.sigla.equals(this.sigla)) {
			return true;
		} else {
			return false;
		}
	}
	
}
