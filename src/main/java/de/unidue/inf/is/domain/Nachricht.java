package de.unidue.inf.is.domain;

public class Nachricht {
	private int    id_Nachricht;
	private String text_Nachricht;
	private String absender;
	private String empfaenger;
	
	public Nachricht() {
	}
	
	public Nachricht(int id_Nachricht,String text_Nachricht,String absender,String empfaenger) {
		this.id_Nachricht=id_Nachricht;
		this.text_Nachricht=text_Nachricht;
		this.absender=absender;
		 this.empfaenger=empfaenger;
	}
	public  int id_Nachricht() {
		return id_Nachricht;
	}
	public  String text_Nachricht() {
		return text_Nachricht;
	}
	public String absender() {
		return absender;
	}
	public String empfaenger() {
		return empfaenger ;
	}
}
