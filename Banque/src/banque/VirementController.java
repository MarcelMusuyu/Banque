/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import Model.Toast;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class VirementController implements Initializable {

    @FXML
    private AnchorPane virement;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField tfMontant;
    @FXML
    private PasswordField tfNumero;
    @FXML
    private ComboBox<String> devise;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField tfContacts;
    @FXML
    private TextField tfMontantLetttre;
    @FXML
    private DatePicker dateVirement;
    @FXML
    private PasswordField tfNumeroDest;
    @FXML
    private TextField tfContactsDest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView likeImage3 = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());

        btnEnregistrer.setGraphic(likeImage3);
         btnEnregistrer.setContentDisplay(ContentDisplay.LEFT);

        ImageView likeImage2 = new ImageView(getClass().getResource("/BANQUES/icones/5718779.png").toString());

        btnAnnuler.setGraphic(likeImage2);
        btnAnnuler.setContentDisplay(ContentDisplay.LEFT);
    }

    @FXML
    private void transactions(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
    
    
    @FXML
    private void Valider() {
        Toast2();
    }
    
    
       private void Toast2() {
        Stage stage = new Stage();

        String toastMsg = "Veuillez prendre le temps de vérifier les informations saisies!!! ";
        int toastMsgTime = 2500; //2.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime = 500; //0.5 seconds
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);

    }

}
