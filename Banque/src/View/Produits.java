/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author MARCEL
 */
public class Produits {
    private int numero;
    private String Designation;
    private int Quantite;
    private Double PrixUnitaire;
    private Double PrixTTC;

    public Produits(int numero, String Designation, int Quantite, Double PrixUnitaire, Double PrixTTC) {
        this.numero = numero;
        this.Designation = Designation;
        this.Quantite = Quantite;
        this.PrixUnitaire = PrixUnitaire;
        this.PrixTTC = PrixTTC;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public Double getPrixUnitaire() {
        return PrixUnitaire;
    }

    public void setPrixUnitaire(Double PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
    }

    public Double getPrixTTC() {
        return PrixTTC;
    }

    public void setPrixTTC(Double PrixTTC) {
        this.PrixTTC = PrixTTC;
    }
    
    
}
