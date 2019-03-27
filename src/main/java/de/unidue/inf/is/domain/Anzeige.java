package de.unidue.inf.is.domain;

import java.util.Date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.unidue.inf.is.domain.Benutzer;


public class Anzeige extends Benutzer  {
	private  int id_Anzeige;
	private  String titel;
	private  float preis;
	private  String text;
	private  String ersteller ;
	ArrayList<String> kategories ;
	String kat;
	Date data_ajout;
	private  String status ;
	/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//Date date = new Date();

	String frmtdDate = dateFormat.format(date);
	String date_ajout= frmtdDate; */
	//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	//String date_ajout= timestamp.toString();
	
	public Anzeige() {	
	}
	public Anzeige(int id_Anzeige,String titel,ArrayList<String> kategories , float preis,String text, java.util.Date erstellungsdatum, String ersteller,String status) {
		this.id_Anzeige=id_Anzeige;
		this.titel= titel;
		this.kategories= kategories;
		this.text= text;
		this.preis= preis;
		this.data_ajout=erstellungsdatum;
		this.ersteller= ersteller;
		//this.ersteller= getErsteller();
		this.status=status;
	}
	public Anzeige(String titel,String text , float preis, String ersteller, String status) {
		//this.id_Anzeige=id_Anzeige;
		this.titel= titel;
		this.text= text;
		this.preis= preis;
		this.ersteller= ersteller;
		this.status=status;
	}
	
	public Anzeige(String titel,String text , float preis, int id_Anzeige,ArrayList<String> kategories) {
		//this.id_Anzeige=id_Anzeige;
		this.titel= titel;
		this.text= text;
		this.preis= preis;
		this.id_Anzeige=id_Anzeige;
		this.kategories= kategories;
	
	}
	
	public Anzeige(String titel,String text , float preis, int id_Anzeige,String kat) {
		//this.id_Anzeige=id_Anzeige;
		this.titel= titel;
		this.text= text;
		this.preis= preis;
		this.id_Anzeige=id_Anzeige;
		this.kat= kat;
	
	}
	public String getKat() {
		return kat;
	}
	/*
	private Anzeige Anzeige(String titel, String text, float preis, int id_Anzeige, String[] kategories) {
		this.id_Anzeige=id_Anzeige;
		this.titel= titel;
		this.kategories= kategories;
		this.text= text;
		this.preis= preis;
		this.ersteller= ersteller;
	} */
	
	public  int getId() {
		return id_Anzeige;
	}  
		public  String getTitel() {
		return titel;
	}
		public  String getKategorie() {
			return String.join(", ", kategories);
		}
	public  String getText() {
		return text;
	}
	public float getPreis() {
		return preis;
	}
	public Date getDate() {
		return data_ajout;
	}
	/*
	public void setErsteller (String ersteller) {
		this.ersteller= getBenutzername();
	} */
	public String getErsteller() {
		return ersteller ;
	}
	public String getStatus() {
		return status ;
	}
	public void setId(int id_Anzeige) {
		this.id_Anzeige = id_Anzeige;
	}
/*
// set void
	public  void setTitel(String titel) {
		 this.titel=titel;
	}
	public  void setText(String text) {
		this.text=text;
	}
	public void setPreis(float preis) {
		 this.preis=preis;
	}
	public void setDate_ajout(String date_ajout) {
		this.date_ajout=date_ajout;
	}
	/*
	public void setErsteller (String ersteller) {
		this.ersteller= getBenutzername();
	} 
	public void getErsteller(String ersteller) {
		this.ersteller=ersteller ;
	}
	public void setStatus() {
		this.status=status ;
	}
*/
}
