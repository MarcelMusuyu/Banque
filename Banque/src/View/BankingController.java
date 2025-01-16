/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import banque.FXMLDocumentController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class BankingController implements Initializable {

    @FXML
    private Hyperlink bilan;
    @FXML
    private Hyperlink tauxInteret;
    @FXML
    private Button butt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Bilanbancaire() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("/banque/Bilan.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Bilan");
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    // Effectuer le traitement. 
}
