/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import banque.FXMLDocumentController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class CorrespondanceController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private TextArea resume;
    @FXML
    private TextField ville;
    @FXML
    private DatePicker date;
    @FXML
    public TextField objet;
    @FXML
    private TextField reference;
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
    private Label nrccm;
    @FXML
    private Label adresses;
    @FXML
    private Label contacts;
    @FXML
    private TextField appelation;
    @FXML
    private TextArea AdressesDest;
    @FXML
    private ImageView signature;
    @FXML
    private TextField piecesJointes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Fichier() {

        pieces.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final FileChooser dialog = new FileChooser();
                final File file = dialog.showOpenDialog(pieces.getScene().getWindow());
                if (file != null) {
                    piecesJointes.setText("" + file.getName());
                    JOptionPane.showMessageDialog(null, "pieces jointes avec succes !!!");
                }
            }
        });
    }

    @FXML
    private void Enregistrer() {
        File fichier1 = new File("src\\Fichier\\Correspondance.txt");

        PrintWriter  enregistrement1 = null;

        try {
            if (fichier1.exists()) {
                enregistrement1 = new PrintWriter(new FileWriter(fichier1,true));

                enregistrement1.append( adresses.getText()+"]" + "\n" + contacts.getText()+"]"  + "\n" + nrccm.getText()+"]" + "\n" + ville.getText()+"]" + "\n" + date.getValue()+"]" + "\n"
                        + objet.getText() +"]"+ "\n" + reference.getText() +"]"+ "\n" + appelation.getText()+"]" + "\n" + resume.getText()+"]"+ "\n" + AdressesDest.getText()+"]" + "\n" + piecesJointes.getText() + "]" + "\n\n");

                JOptionPane.showMessageDialog(null, "Enregistrement reussi");
                 createAccount() ;

            } else {
                fichier1.delete();
                fichier1.createNewFile();

            }

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            enregistrement1.close();

        }

    }
    
    private void createAccount() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Lettre.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Letter");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
