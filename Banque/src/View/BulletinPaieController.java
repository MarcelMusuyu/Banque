/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Convertion.Convertion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class BulletinPaieController implements Initializable {

    @FXML
    private AnchorPane creation;
    @FXML
    private DatePicker date;
    @FXML
    private TextField nom;
    @FXML
    private TextField postnom;
    @FXML
    private TextField matricule;
    @FXML
    private TextField poste;
    @FXML
    private TextField departement;
    @FXML
    private TextField tfSbase;
    @FXML
    private TextField tfSHsuppl;
    @FXML
    private TextField tfPrimes;
    @FXML
    private TextField tfIndemniteConge;
    @FXML
    private TextField tfAllocationFam;
    @FXML
    private TextField tfAutresAvantages;
    @FXML
    private TextField tfRemuBruteTaxable;
    @FXML
    private TextField tfAllocaFamLegales;
    @FXML
    private TextField tfIndemnitesTrans;
    @FXML
    private TextField tfIndemniteLogement;
    @FXML
    private TextField tfAutreIndemnites;
    @FXML
    private TextField tfRemunerationBrute;
    @FXML
    private TextField tfImpotSalaire;
    @FXML
    private TextField tfCotInss;
    @FXML
    private TextField tfCotSyndicale;
    @FXML
    private TextField tfAvanceSalaire;
    @FXML
    private TextField tfSaisieArret;
    @FXML
    private TextField tfAutresRetenus;
    @FXML
    private TextField tfTotalRetenus;
    @FXML
    private TextField tfRemunerationNetPayer;
    @FXML
    private TextField tfRemBrutTaxFinal;
    @FXML
    private TextField tfRemBrutFinal;
    @FXML
    private TextField tfRemNetPayerFinal;
    @FXML
    private Button calculer;
    @FXML
    private ImageView imgBack1;
    @FXML
    private ImageView imgBack11;
    @FXML
    private ImageView imgBack1111;
    @FXML
    private ImageView imgBack11111211;
    @FXML
    private ImageView imgBack111112111;
    @FXML
    private Button valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView likeImage3 = new ImageView(getClass().getResource("/BANQUES/icones/check.png").toString());

        valider.setGraphic(likeImage3);
        valider.setContentDisplay(ContentDisplay.LEFT);

        ImageView likeImage = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());

        calculer.setGraphic(likeImage);
        calculer.setContentDisplay(ContentDisplay.LEFT);

    }

    @FXML
    public void Valider() {

        double remuneraBruteTax = Double.parseDouble(tfSbase.getText()) + Double.parseDouble(tfSHsuppl.getText()) + Double.parseDouble(tfPrimes.getText())
                + Double.parseDouble(tfIndemniteConge.getText()) + Double.parseDouble(tfAllocationFam.getText()) + Double.parseDouble(tfAutresAvantages.getText());
        tfRemuBruteTaxable.setText("" + remuneraBruteTax);
        tfRemBrutTaxFinal.setText("" + remuneraBruteTax);

        double remuneraBrute = Double.parseDouble(tfAllocaFamLegales.getText()) + Double.parseDouble(tfIndemnitesTrans.getText()) + Double.parseDouble(tfIndemniteLogement.getText())
                + Double.parseDouble(tfAutreIndemnites.getText());

        double totalRemu = remuneraBruteTax + remuneraBrute;

        tfRemunerationBrute.setText("" + totalRemu);
        tfRemBrutFinal.setText("" + totalRemu);

        double retenus = Double.parseDouble(tfImpotSalaire.getText()) + Double.parseDouble(tfCotInss.getText()) + Double.parseDouble(tfCotSyndicale.getText())
                + Double.parseDouble(tfAvanceSalaire.getText()) + Double.parseDouble(tfSaisieArret.getText()) + Double.parseDouble(tfAutresRetenus.getText());

        tfTotalRetenus.setText("" + retenus);

        double netApayer = totalRemu - retenus;

        int val = (int) netApayer;
        tfRemunerationNetPayer.setText("" + Convertion.conversion(val));
        tfRemNetPayerFinal.setText("" + netApayer);
        JOptionPane.showMessageDialog(null, "Votre salaire est de "+Convertion.conversion(val));

    }

}
