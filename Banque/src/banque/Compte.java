
package banque;

import java.time.LocalDate;
import java.util.Date;


public class Compte {
    private String numCompte;
    private String typeCompte;
    private double solde;
    private LocalDate dateCreation;
    private Client proprietaire;

    public Compte(String numCompte, String typeCompte, double solde, LocalDate dateCreation, Client proprietaire) {
        this.numCompte = numCompte;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.proprietaire = proprietaire;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDerniereTransaction(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
    
     public  void transaction(String type, double montant) {
        Operation op = new Operation(this, type,montant);
        if (type.equals("retrait")) {

            op.retrait(montant);
        } else if (type.equals("depot")) {
            op.depot(montant);
        }

    }
    
    
}
