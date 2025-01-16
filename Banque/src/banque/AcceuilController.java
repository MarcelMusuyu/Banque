/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import Model.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javafx.scene.control.MenuItem;

import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class AcceuilController implements Initializable {

    @FXML
    private Hyperlink banking;
    @FXML
    private Hyperlink card;
    @FXML
    private Hyperlink investing;
    @FXML
    private Hyperlink planning;
    @FXML
    private Hyperlink business;
    @FXML
    private ImageView acceuil;
    @FXML
    private ComboBox<String> countSelect;
    @FXML
    private ComboBox<String> newCount;
    @FXML
    private ChoiceBox<String> services;
    @FXML
    private ChoiceBox<String> countries;
    @FXML
    private Button valider1;
    @FXML
    private Button valider2;
    @FXML
    private MenuItem commerciale;
    @FXML
    private MenuItem industrie;
    @FXML
    private MenuItem prestations;
    @FXML
    private MenuItem societe;
    @FXML
    private Hyperlink statistics;
    @FXML
    private Hyperlink Bintelligent;
    @FXML
    private MenuItem CloseWindow;
    @FXML
    private MenuItem mnGuide;

    private Button Virement;
    @FXML
    private MenuItem calculator;
    @FXML
    private ContextMenu listeMenu;
    @FXML
    private ContextMenu listeMenu1;
    @FXML
    private ContextMenu listeMenu2;
    @FXML
    private ImageView imgBack;
    @FXML
    private ImageView imgBack111112;
    @FXML
    private MenuItem menuItemBilanBanc;
    @FXML
    private MenuItem menuItemVirement;
    @FXML
    private MenuItem menuItemReport;
    @FXML
    private MenuItem mnGuide1;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem CloseWindow1;
    @FXML
    private MenuItem CloseWindow11;
    @FXML
    private MenuItem CloseWindow111;
    @FXML
    private MenuItem CloseWindow1111;
    @FXML
    private MenuItem mnItemConnection;
    @FXML
    private MenuItem mItemMasque;
    @FXML
    private Menu mnEntreprise;
    @FXML
    private MenuItem mItemMasque1;
    @FXML
    private ContextMenu listeMenu3;
    @FXML
    private MenuItem bankTransact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> countryList = FXCollections.observableArrayList();
        countryList.addAll("RDC", "Russie", "France", "USA", "Afrique du sud", "Japon", "Australie", "Ecosse", "Suisse", "Angleterre", "Chine");

        ObservableList<String> countList = FXCollections.observableArrayList();
        countList.addAll("Epargne", "Courant", "Solde");
        countSelect.setItems(countList);
        newCount.setItems(countList);
        countries.setItems(countryList);

        ImageView likeImage = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());
        ImageView likeImag2 = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());
        ImageView virement = new ImageView(getClass().getResource("/BANQUES/banking/virement.png").toString());
        valider1.setGraphic(likeImag2);
        valider1.setContentDisplay(ContentDisplay.LEFT);

        valider2.setGraphic(likeImage);
        valider2.setContentDisplay(ContentDisplay.LEFT);

    }

    private void existAccount() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("FXMBanque.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Account");
            stage.centerOnScreen();
            stage.setMaximized(false);
            stage.setResizable(false);

            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void soldeAccount() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Solde.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Solde");
            stage.centerOnScreen();

            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Selected() {
        String val = countSelect.getValue();
        if (val.equals("Epargne") || val.equals("Courant")) {
            existAccount();
        } else if (val.equals("Solde")) {
            soldeAccount();
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez choisir un compte!!!");
        }

    }

    @FXML
    private void newSelected() {
        String val = newCount.getValue();
        if (val.equals("Epargne") || val.equals("Courant")) {
            createAccount();
        } else if (val.equals("Investissement")) {
            JOptionPane.showMessageDialog(null, "Interface investissement!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez choisir un compte!!!");
        }

    }

    private void createAccount() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Creation.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Account");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void createEntreprise() {

        Stage stage = new Stage();

        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Firmes.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Entreprise");
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Banking() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Bilan.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Bilan");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void femeture() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/Message.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Dialog box");
            stage.centerOnScreen();

            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void Masquer() {
         mnEntreprise.setVisible(false);
    }
    
       @FXML
    private void Demasquer() {
         mnEntreprise.setVisible(true);
    }


    @FXML
    private void Customers() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/customersReport.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Customer");
            stage.centerOnScreen();

            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Toast() {
        Stage stage = new Stage();

        String toastMsg = "Veuillez prendre la peine d'analyser chaque fonctionnalité ";
        int toastMsgTime = 2500; //2.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime = 500; //0.5 seconds
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);

    }
    
     @FXML
    private void Infobull() {
        Stage stage = new Stage();

        String toastMsg = "Veuillez prendre la peine d'analyser chaque fonctionnalité ";
        int toastMsgTime = 2500; //2.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime = 500; //0.5 seconds
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);

    }
    
    @FXML
    private void Calculatrice() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/calculator.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Calculator");
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UTILITY);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
      

    private void SliptMenu() {

        ChoiceBox fonctions = new ChoiceBox();
        ObservableList< MenuItem> deviseList = FXCollections.observableArrayList();
        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();
        deviseList.addAll(item1, item2);
        fonctions.setItems(deviseList);
        fonctions.show();
    }

    @FXML
    private void VirementBancaire() {

        Stage stage = new Stage();

        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Virement.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Virement");
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void AccountInvest() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/AccountInvest.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Investing");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @FXML
     public void operations(){
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/CompteCourant.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Account");
            stage.centerOnScreen();
            stage.setResizable(false);
           

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
