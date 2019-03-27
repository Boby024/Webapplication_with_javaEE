package de.unidue.inf.is.domain;

import java.util.Date;

public class Benutzer {

    private String benutzername;
    private String name;
    private Date eintrittsdatum;


    public Benutzer() {
    }


    public Benutzer(String benutzername, String name, Date eintrittsdatum) {
        this.benutzername = benutzername;
        this.name = name;
        this.eintrittsdatum=eintrittsdatum;

    }
    public Benutzer(String benutzername, String name) {
        this.benutzername = benutzername;
        this.name = name;

    }


    public String getBenutzername() {
        return benutzername;
    }


    public String getName() {
        return name;
    }
    
    public Date getEintrittsdatum() {
    	return  eintrittsdatum;
    }

}