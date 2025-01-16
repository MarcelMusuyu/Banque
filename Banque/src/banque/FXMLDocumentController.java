/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import Convertion.Convertion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfMontant;
    @FXML
    private TextField tfPostnom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfDate;
    @FXML
    private CheckBox depot;
    @FXML
    private PasswordField tfNumero;
    @FXML
    private CheckBox retrait;
    @FXML
    private ComboBox<String> devise;
    @FXML
    private Button btnAnnuler;

    @FXML
    private TextField tfContacts;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView logo1;
    @FXML
    private ImageView logo11;
    @FXML
    private ImageView logo111;
    @FXML
    private TextField tfMontantLetttre;
    @FXML
    private AnchorPane creation;
    @FXML
    private Button btnImprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.addAll("Epargne", "Courant");
        ObservableList<String> deviseList = FXCollections.observableArrayList();
        deviseList.addAll("USD", "CDF", "EURO", "YEN", "FCFA", "GBP");
        devise.setItems(deviseList);
        tfDate.setText("" + now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        depot.setSelected(true);
        
         ImageView likeImag= new ImageView(getClass().getResource("/BANQUES/checked.png").toString());
         btnEnregistrer.setGraphic(likeImag);
         btnEnregistrer.setContentDisplay(ContentDisplay.LEFT);

    }

    @FXML
    private void annuler() {

        tfNom.setText("");
        tfAdresse.setText("");
        tfMontant.setText("");
        tfPostnom.setText("");
        tfNumero.setText("");
        tfContacts.setText("");
        tfDate.setText("");
        tfMontantLetttre.setText("");
    }

    @FXML
    private void DepSelect() {
        retrait.setSelected(false);
    }

    @FXML
    private void RetSelect() {
        depot.setSelected(false);
    }

    public Connection getConnection() {
        Connection conn;
        try {

            String url = "jdbc:mysql://localhost:3306/banque";
            String user = "root";
            String passwd = "";
            conn = DriverManager.getConnection(url, user, passwd);

            return conn;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    @FXML
    private void transactions() {
         if (tfNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le Numero de votre compte bancaire");
        } else {
            SaveTransact(Double.parseDouble(tfMontant.getText()), tfNumero.getText());
            Connection conn = getConnection();
            String query = "SELECT client.nomClient,client.postnomClient,client.Adresse,client.Contact FROM client "
                    + "INNER JOIN compte on client.idClient = compte.client_idClient WHERE compte.numCompte = '" + tfNumero.getText() + "'";

            Statement st;
            ResultSet rx;

            try {

                st = conn.createStatement();
                rx = st.executeQuery(query);

                while (rx.next()) {
                    tfNom.setText("" + rx.getString("nomClient"));
                    tfPostnom.setText("" + rx.getString("postnomClient"));
                    tfAdresse.setText("" + rx.getString("Adresse"));
                    tfContacts.setText("" + rx.getString("Contact"));

                }
                int val = Integer.parseInt(tfMontant.getText());
                tfMontantLetttre.setText("" + Convertion.conversion(val) + " " + devise.getValue());
                tfDate.setText("" + now().format(DateTimeFormatter.ISO_LOCAL_DATE));
                 
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void ExecuteQueries(String query) {
        Connection conn = getConnection();

        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void SaveTransact(double montant, String numCompte) {
        Connection conn = getConnection();

        if (depot.isSelected()) {
            double add = montant + getSolde(numCompte);
            String query = "UPDATE compte SET solde =" + add + " WHERE numCompte = '" + numCompte + "'";
            ExecuteQueries(query);

            JOptionPane.showMessageDialog(null, "Votre compte a ete approvisionné d'une somme de " + montant + " " + devise.getValue());
            JOptionPane.showMessageDialog(null, "Votre solde actuel est de " + getSolde(numCompte) + " " + devise.getValue());
        } else if (retrait.isSelected()) {
            if (montant < getSolde(numCompte)) {
                double sub = getSolde(numCompte) - montant;
                String query = "UPDATE compte SET solde =" + sub + " WHERE numCompte = '" + numCompte + "'";
                ExecuteQueries(query);
                JOptionPane.showMessageDialog(null, "vous avez effectué un retrait de  " + montant + " " + devise.getValue());
                JOptionPane.showMessageDialog(null, "Votre solde actuel est de " + getSolde(numCompte) + " " + devise.getValue());
            } else if (montant >= getSolde(numCompte)) {
                JOptionPane.showMessageDialog(null, "Votre solde est insuffisant \n veuillez contacter votre banquier pour un decouvert bancaire ou une emprunte");
            }
        }

    }
    
   
    public double getSolde(String numCompte) {

        Connection conn = getConnection();
        String query = "SELECT solde FROM compte WHERE numCompte = '" + numCompte + "'";

        double result = 0.0;
        Statement st;
        ResultSet rx;

        try {

            st = conn.createStatement();
            rx = st.executeQuery(query);

            while (rx.next()) {
                result = Double.parseDouble(rx.getString("solde"));
                return result;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
