/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author MARCEL
 */
public class Customers {
    
   private String nom;
   private String postnom;
   private String contacts;
   private String adresses;
   private String numero;
   private String type;
   private double solde;
   private Date Dates;
    private String devise;

    public Customers(String nom, String postnom, String contacts, String adresses, String numero, String type, double solde, Date Dates, String devise) {
        this.nom = nom;
        this.postnom = postnom;
        this.contacts = contacts;
        this.adresses = adresses;
        this.numero = numero;
        this.type = type;
        this.solde = solde;
        this.Dates = Dates;
        this.devise = devise;
    }

    public String getNom() {
        return nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public String getContacts() {
        return contacts;
    }

    public String getAdresses() {
        return adresses;
    }

    public String getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public double getSolde() {
        return solde;
    }

    public Date getDates() {
        return Dates;
    }

    public String getDevise() {
        return devise;
    }
    
}
