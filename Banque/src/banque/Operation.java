package banque;

import java.util.Date;

public class Operation {

    Compte compte;
    private String typeOperation;
    private double montant;

    public Operation(Compte compte, String typeOperation,double montant) {
        this.compte = compte;

        this.typeOperation = typeOperation;
        this.montant=montant;

    }

    public void depot(double montant) {
        compte.setSolde(compte.getSolde()+montant);
    }

    public void retrait(double montant) {
       compte.setSolde(compte.getSolde()-montant);
    }
}
