package banque;

import javax.swing.JOptionPane;

public class Client extends Personne {

    private String adresse;
    private Compte compte;

    public Client(String adresse, String nom, String postnom, String contact, String genre) {
        super(nom, postnom, contact, genre);
        this.adresse = adresse;
       
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Compte creerCompte(Compte compte) {
        
        return compte;
    }
    
    public void modifierNumCompte(Compte compte, String numCompte){
        compte.setNumCompte(numCompte);
    }
    
    public void voirSolde(Compte compte){
        JOptionPane.showMessageDialog(null, "votre solde Actuel est de  "+compte.getSolde());
    }

   

}
