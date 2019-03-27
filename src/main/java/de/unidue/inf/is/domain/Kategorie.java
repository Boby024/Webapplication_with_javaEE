package de.unidue.inf.is.domain;

public class Kategorie {
	String name_Kategorie;
	
	public Kategorie() {
		
	}
	public Kategorie(String name_Kategorie) {
		this.name_Kategorie=name(name_Kategorie);
	}
	public String getName_Kategorie() {
		return name_Kategorie;
	}
	public String name(String choix) {
		if(choix== "Digitale Waren"|| choix== "Haus & Garten"||choix== "Mode & Kosmetik"|| choix== "Multimedia & Elektronik") 
			return choix;
		else 
		return "Digitale Waren";
	}
}
