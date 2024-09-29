package com.futebol.principal;
import java.util.HashMap;
import java.util.Map;

public class ListaEquipes {

	private Map<String, Time> times = new HashMap<>();
	
	   public ListaEquipes() {
	        times.put("BOT", new Time("Botafogo            ", "BOT", Configuracao.Nivel.ALTO));
	        times.put("PAL", new Time("Palmeiras           ", "PAL", Configuracao.Nivel.ALTO));
	        times.put("FOR", new Time("Fortaleza           ", "FOR", Configuracao.Nivel.MEDIO));
	        times.put("FLA", new Time("Flamengo            ", "FLA", Configuracao.Nivel.ALTO));
	        times.put("SAO", new Time("São Paulo           ", "SAO", Configuracao.Nivel.MEDIO));
	        times.put("ECB", new Time("Bahia               ", "ECB", Configuracao.Nivel.MEDIO));
	        times.put("CRU", new Time("Cruzeiro            ", "CRU", Configuracao.Nivel.MEDIO));
	        times.put("INT", new Time("Internacional       ", "INT", Configuracao.Nivel.MEDIO));
	        times.put("CAM", new Time("Atlético Mineiro    ", "CAM", Configuracao.Nivel.MEDIO));
	        times.put("VAS", new Time("Vasco               ", "VAS", Configuracao.Nivel.BAIXO));
	        times.put("RBB", new Time("Bragantino          ", "RBB", Configuracao.Nivel.BAIXO));
	        times.put("JUV", new Time("Juventude           ", "JUV", Configuracao.Nivel.BAIXO));
	        times.put("CRI", new Time("Criciúma            ", "CRI", Configuracao.Nivel.BAIXO));
	        times.put("GRE", new Time("Gremio              ", "GRE", Configuracao.Nivel.MEDIO));
	        times.put("CAP", new Time("Athlético Paranaense", "CAP", Configuracao.Nivel.MEDIO));
	        times.put("VIT", new Time("Vitória             ", "VIT", Configuracao.Nivel.BAIXO));
	        times.put("COR", new Time("Corinthians         ", "COR", Configuracao.Nivel.BAIXO));
	        times.put("FLU", new Time("Fluminense          ", "FLU", Configuracao.Nivel.MEDIO));
	        times.put("CUI", new Time("Cuiabá              ", "CUI", Configuracao.Nivel.BAIXO));
	        times.put("ACG", new Time("Atlético Goianiense ", "ACG", Configuracao.Nivel.BAIXO));
	    }
	   
	    public Time encontrarTime(String sigla) {
	        return times.get(sigla.toUpperCase());
	    }
	    
	    public Map<String, Time> getTimes() {
	        return times;
	    }
	    
}
