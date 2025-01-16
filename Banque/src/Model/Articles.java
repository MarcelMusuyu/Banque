
package Model;

import java.time.LocalDate;


public class Articles {
    private String nomProduits;
    private int quantite;
    private double prixUnitaire;
    private LocalDate dateFacture;

    public Articles(String nomProduits, int quantite, double prixUnitaire, LocalDate dateFacture) {
        this.nomProduits = nomProduits;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.dateFacture = dateFacture;
    }

    public String getNomProduits() {
        return nomProduits;
    }

    public void setNomProduits(String nomProduits) {
        this.nomProduits = nomProduits;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }
    
    
}
