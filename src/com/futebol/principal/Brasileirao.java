package com.futebol.principal;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Brasileirao {
	
	TimeCampeonato[] tabela;
    private JogoCampeonato[][] partidas;
    private Random randomNumbers;
    private int rodadaAtual;

	public Brasileirao() {
		 this.tabela = new TimeCampeonato[20];
	     this.partidas = new JogoCampeonato[38][10];
	     //this.jogo = new JogoCampeonato[190];
	     this.rodadaAtual = 0;
	     
		randomNumbers = new Random();
		
        int index = 0;
        for (String sigla : Configuracao.listaEquipes.getTimes().keySet()) {
            if (index < 20) {
            	tabela[index] = new TimeCampeonato(sigla);
                index++;
            }
        }
        
        gerarPartidas();
	}
	public Brasileirao(TimeCampeonato[] time) {
		this.tabela = time;
		gerarPartidas();
	}
	
    public void ordenarTabela() {
        Arrays.sort(tabela, new Comparator<TimeCampeonato>() {
            @Override
            public int compare(TimeCampeonato t1, TimeCampeonato t2) {
                if (t1.getPontuacao() != t2.getPontuacao()) {
                    return Integer.compare(t2.getPontuacao(), t1.getPontuacao());
                }
                return Integer.compare(t2.getSaldo(), t1.getSaldo());
            }
        });
    }
    
    private boolean PartidaRegistrada(List<JogoCampeonato> lista, Time a, Time b) {
    	for(int i = 0; i < lista.size(); i++) {
    		if(lista.get(i).getTimes()[0].compareTime(a) && lista.get(i).getTimes()[1].compareTime(b)) {
    			return true;
    		}
    		if(lista.get(i).getTimes()[0].compareTime(b) && lista.get(i).getTimes()[1].compareTime(a)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private void gerarPartidas() {
    	List<JogoCampeonato> jogosRegistrados = new ArrayList<JogoCampeonato>();
    	
    	for(int rodada = 0; rodada < 19; rodada++) {
    		
    		boolean rodadaValida = true;
    		
    		List<JogoCampeonato> jogosBatch = new ArrayList<JogoCampeonato>();
        	List<Time> poteA = new ArrayList<Time>();
        	
        	for(int i = 0; i < 20; i++) {
        		poteA.add(this.tabela[i].getTime());
        	}
        	for(int partida = 0; partida < 10; partida++) {
        		int indexA = randomNumbers.nextInt(0, poteA.size());
        		Time timeA = poteA.get(indexA);
        		poteA.remove(indexA);
        		
            	List<Time> poteB = new ArrayList<Time>();
            	
            	for(Time time : poteA) {
            		if(PartidaRegistrada(jogosRegistrados, timeA, time)){
            			continue;
            		}
            		poteB.add(time);
            	}
            	
            	if(poteB.size() == 0) {
            		rodadaValida = false;
            		continue;
            	}
            	
            	int indexB = 0;
            	indexB = randomNumbers.nextInt(0, poteB.size());
            	Time timeB = poteB.get(indexB);
            	poteA.remove(timeB);
            	
        		
        		
        		JogoCampeonato atual = new JogoCampeonato(timeA, timeB);
        		partidas[rodada][partida] = atual;
        		jogosBatch.add(atual);
        	}
        	if(rodadaValida) {
        		for(JogoCampeonato e : jogosBatch) {
            		jogosRegistrados.add(e);
            	}
        	} else {
        		rodada--;
        	}
    	}
    	
    	for(int rodada = 19; rodada < 38; rodada++) {
    		for(int partida = 0; partida < 10; partida++) {
    			partidas[rodada][partida] = partidas[rodada-19][partida].inverteMando();
    		}
    	}
    				
        
    }

    // Método para exibir as partidas
    public void exibirPartidas() {
        for (int rodada = 0; rodada < partidas.length; rodada++) {
            System.out.println("Rodada " + (rodada + 1) + ":");
            for (int partida = 0; partida < partidas[rodada].length; partida++) {
                System.out.println(partidas[rodada][partida].getTimes()[0].getSigla() + " x " + partidas[rodada][partida].getTimes()[1].getSigla() );
            }
            System.out.println();
        }
    }
    
    public void exibirTabela() {
    	ordenarTabela();
    	System.out.println("POS\tNOME\t\t\tPTS\tPJ\tSG");
        for (int time = 0; time < 20; time++) {
            System.out.println((time + 1) + ". \t" + tabela[time].getTime().getNome() + "\t" + tabela[time].getPontuacao() + "\t" + tabela[time].getPartidasJogadas() + "\t" + tabela[time].getSaldo());
        }
    }
    
    public int getRodada() {
    	return this.rodadaAtual + 1;
    }
    
    public void simularRodada() {
    	if(rodadaAtual >= 37) {
    		return;
    	}
    	
    	MatchMaker game = new MatchMaker();
    	game.setApenasResultado(true);
    	for(int i = 0; i < 10; i++) {
    		Time casa = partidas[rodadaAtual][i].getTimes()[0];
    		Time visitante = partidas[rodadaAtual][i].getTimes()[1];
    		RelatorioJogo doc = game.gerarResultado(casa,visitante);
    		if(doc.getStatus()==0) {
    			//Empate
    			tabela[indexTimeCampeonato(casa)].JogouPartida(0, doc.getScoreCasa(), doc.getScoreVisitante());
    			tabela[indexTimeCampeonato(visitante)].JogouPartida(0, doc.getScoreVisitante(), doc.getScoreCasa());
    		} else if(doc.getStatus()==1) {
    			//Vitoria casa
    			tabela[indexTimeCampeonato(casa)].JogouPartida(1, doc.getScoreCasa(), doc.getScoreVisitante());
    			tabela[indexTimeCampeonato(visitante)].JogouPartida(-1, doc.getScoreVisitante(), doc.getScoreCasa());
    		} else if(doc.getStatus()==2) {
    			//Vitoria casa
    			tabela[indexTimeCampeonato(casa)].JogouPartida(-1, doc.getScoreCasa(), doc.getScoreVisitante());
    			tabela[indexTimeCampeonato(visitante)].JogouPartida(1, doc.getScoreVisitante(), doc.getScoreCasa());
    		}
    		
    	}
    	rodadaAtual++;
        
    }
    
    public void simularTudo() {
        for (int rodada = 0; rodada < partidas.length; rodada++) {
            System.out.println("Rodada " + (rodada + 1) + ":");
            for (int partida = 0; partida < partidas[rodada].length; partida++) {
                System.out.println(partidas[rodada][partida].getTimes()[0].getSigla() + " x " + partidas[rodada][partida].getTimes()[1].getSigla() );
            }
            System.out.println();
        }
    }
    
    public int indexTimeCampeonato(Time time) {
        for(int i = 0; i < 20; i++) {
        	if(tabela[i].getTime().compareTime(time)){
        		return i;
        	}
        }
        return -1;
    }
    
}
