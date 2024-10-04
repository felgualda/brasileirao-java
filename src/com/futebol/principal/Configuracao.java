package com.futebol.principal;

public class Configuracao {
	
	public static ListaEquipes listaEquipes = new ListaEquipes();

	public static int duracaoPartida = 11; // APENAS NÚMEROS ÍMPARES (mediana será intervalo)
	
	public static double mediaGolsPartida = 2.2;
	
	public static double fatorCasa = 0.15;
	public static double penalidadeGolAdversario = 0.30;
	
	//NÍVEIS DE EQUIPE
	public static enum Nivel {
		ALTO,
		MEDIO,
		BAIXO,
	}
	
	//MULTIPLICADORES NÍVEIS DE EQUIPE
	public static double nivelAlto = 0.3; 
	public static double nivelMedio = 0; 
	public static double nivelBaixo = -0.6; 
	
	public static int getMatchMinutes(int fraction) {
		return ((90 / (duracaoPartida - 1)) * fraction);
	}
	
	public static void clrScr() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
}
