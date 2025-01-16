/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class CreationController implements Initializable {

    @FXML
    private AnchorPane content;
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
    private PasswordField tfNumero;
    @FXML
    private ComboBox<String> devise;
    @FXML
    private ComboBox<String> type;
    @FXML
    private TextField tfContacts;
    @FXML
    private ComboBox<String> genre;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Hyperlink HyperCreate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ObservableList<String> genreList = FXCollections.observableArrayList();
        genreList.addAll("Masculin", "Feminin");

        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.addAll("Epargne", "Courant");
        ObservableList<String> deviseList = FXCollections.observableArrayList();

        deviseList.addAll("USD", "CDF", "EURO", "YEN", "FCFA", "GBP");
        devise.setItems(deviseList);

        type.setItems(typeList);
        genre.setItems(genreList);
        tfDate.setText("" + now().format(DateTimeFormatter.ISO_LOCAL_DATE));
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

    @FXML
    private void insertRecord() {
        if (tfNom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir votre Nom");
        } else if (tfPostnom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir votre Postnom");
        } else if (tfContacts.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir votre Contact");
        } else if (tfNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le Numero de votre compte bancaire");
        } else if (type.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez choisir le type de votre compte");
        } else if (devise.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez choisir la devise de votre compte");
        } else if (tfAdresse.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le Montant");
        } else if (tfNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le Numero de votre compte bancaire");

        } else {

            String query = "INSERT INTO client (nomClient,postnomClient,Contact,genre,Adresse) VALUES ('" + tfNom.getText() + "','" + tfPostnom.getText() + "','" + tfContacts.getText() + "','" + genre.getValue() + "','" + tfAdresse.getText() + "')";
            ExecuteQueries(query);
            JOptionPane.showMessageDialog(null, "Enregistrement reussi dans client!!!");

            Date dates = Date.valueOf(tfDate.getText());
            int Id = getId(tfNom.getText(), tfPostnom.getText(), tfContacts.getText());
            String query2 = "INSERT INTO compte (numCompte,typeCompte,solde,dateCreation,devise,Client_idClient) VALUES ('" + tfNumero.getText() + "','" + type.getValue() + "','" + tfMontant.getText() + "','" + dates + "','" + devise.getValue() + "','" + Id + "')";

            ExecuteQueries(query2);
            JOptionPane.showMessageDialog(null, "Enregistrement reussi dans compte!!!");
        }
    }

    public int getId(String nom, String postnom, String contact) {

        Connection conn = getConnection();
        String query = "SELECT idClient FROM client WHERE nomClient = '" + nom + "' AND postnomClient = '" + postnom + "' AND Contact= '" + contact + "' ";

        int result = 0;
        Statement st;
        ResultSet rx;

        try {

            st = conn.createStatement();
            rx = st.executeQuery(query);

            while (rx.next()) {
                result = Integer.parseInt(rx.getString("idClient"));
                return result;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
