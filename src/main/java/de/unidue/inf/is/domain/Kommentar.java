package de.unidue.inf.is.domain;

public class Kommentar {
	private int id_Kommentar;
	private String text_Kommentar;
	
	public Kommentar() {
		
	}
	public Kommentar(int id_Kommentar, String text_Kommentar) {
		this.id_Kommentar=id_Kommentar;
		this.text_Kommentar=text_Kommentar;
	}
	 public int id_Kommentar() {
	        return id_Kommentar;
	    }


	    public String text_Kommentar() {
	        return text_Kommentar;
	    }
	   
}
