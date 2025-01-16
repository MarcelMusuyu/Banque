package banque;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banquier extends Personne {

    private String matricule;

    public Banquier(String matricule, String nom, String postnom, String prenom, String genre) {
        super(nom, postnom, prenom, genre);
        this.matricule = matricule;
    }

    public void enregistrerOp(Operation operation) {
        File fichier1 = new File("src\\banque\\BANQUE.txt");
        LocalDate dateOperation;
        double reductionOp;
        BufferedWriter enregistrement1 = null;

        try {
            if (fichier1.exists()) {
                System.out.println("le fichier existe deja!!!");
            } else {
                fichier1.delete();

                try {
                    fichier1.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Banquier.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            enregistrement1 = new BufferedWriter(new FileWriter(fichier1));
            enregistrement1.write(operation.compte.getNumCompte() + "|" + operation.compte.getProprietaire() + "|" + operation.compte.getSolde() + "|"+operation.compte.getDateCreation()+ "|"+operation.compte.getSolde()+ "|"+ "\n");

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                enregistrement1.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
