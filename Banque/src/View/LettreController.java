/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class LettreController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private Label nrccm;
    @FXML
    private Label adresses;
    @FXML
    private Label contacts;
    @FXML
    private Label AdressesDest;
    @FXML
    private Label appelation;
    @FXML
    private Label reference;
    @FXML
    private Label objet;
    @FXML
    private Hyperlink pieces;
    @FXML
    private ImageView home;
    @FXML
    private ImageView load;
    @FXML
    private ImageView share;
    @FXML
    private ImageView print;
    @FXML
    private ImageView send;
    @FXML
    private ImageView save;
    @FXML
    private ImageView signature;
    @FXML
    private Label message;
    @FXML
    private Label date;
    @FXML
    private Label ville;

    String[] tab = null;
    BufferedReader affichage1 = null;
     ObservableList<String> letterList= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         File fichier1 = new File("src\\Fichier\\Correspondance.txt");
        

        try {

            if (fichier1.exists()) {

                String valeur1 = null;

                affichage1 = new BufferedReader(new FileReader(fichier1));

                while ((valeur1 = affichage1.readLine()) != null) {
                    
                      letterList.add(valeur1) ;
                }
                 JOptionPane.showMessageDialog(null, ""+letterList.size());
                 
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO
    @FXML
    private void Fichier() {

        pieces.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final FileChooser dialog = new FileChooser();
                final File file = dialog.showOpenDialog(pieces.getScene().getWindow());
                if (file != null) {
                    pieces.setText("" + file.getName());
                    JOptionPane.showMessageDialog(null, "pieces jointes avec succes !!!");
                }
            }
        });
    }

    @FXML
    private void Enregistrer(MouseEvent event) {
    }

}
