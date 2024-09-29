package com.futebol.principal;

public class Placar {
	private int c, v; 	//C = score casa; V = score visitante
	
	public Placar(int c, int v) {
		this.c = c;
		this.v = v;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
	
	
}
