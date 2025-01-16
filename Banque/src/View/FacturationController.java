/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import Convertion.Convertion;
import Model.Toast;
import java.sql.Date;
import javafx.print.PrinterJob;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class FacturationController implements Initializable {

    public static int numero = 0;
    public static ObservableList<Produits> produitList = FXCollections.observableArrayList();
    public static double somme = 0.0;

    public Double PrixTotal;

    @FXML
    private AnchorPane content;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfContacts;
    @FXML
    private DatePicker tfDate;
    @FXML
    private ComboBox<String> Articles;
    @FXML
    private TextField tfNumero1;
    @FXML
    private TextField tfDesignation;
    @FXML
    private TextField tfQte;
    @FXML
    private Pane tfPTTC;
    @FXML
    private TextField tfPrixUnitaire;
    @FXML
    private TableView<Produits> tbProduits;
    @FXML
    private TableColumn<Produits, Integer> colNumProd;
    @FXML
    private TableColumn<Produits, String> colDesignation;
    @FXML
    private TableColumn<Produits, Integer> colQte;
    @FXML
    private TableColumn<Produits, Double> colPrixU;
    @FXML
    private TableColumn<Produits, Double> colPrixTTC;
    @FXML
    private TextField tfReduction;
    @FXML
    private TextField tfPrixTOT;
    @FXML
    private TextField tfNetAPayer;
    @FXML
    private TextField tfMontantLettre;
    @FXML
    private ComboBox<String> tfModePaiement;
    @FXML
    private Button btnValider;
    private Button btnAnnuler;
    @FXML
    private ComboBox<String> devise;
    @FXML
    private TextField tfPrixTCC;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnImprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> produitList = FXCollections.observableArrayList();

        produitList.addAll("voiture", "chaussure", "chaise", "television", "antenne", "switch", "HDD", "moniteur", "clavier", "processeur", "souris", "PC");
        Articles.setItems(produitList);

        ObservableList<String> deviseList = FXCollections.observableArrayList();
        deviseList.addAll("USD", "CDF", "EURO", "YEN", "FCFA", "GBP");
        devise.setItems(deviseList);

        ObservableList<String> modeList = FXCollections.observableArrayList();
        modeList.addAll("Especes", "Carte bancaire", "M-Psa", "Airtel Money", "Credit");
        tfModePaiement.setItems(modeList);

        ImageView likeImage = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());
        btnValider.setGraphic(likeImage);
        btnValider.setContentDisplay(ContentDisplay.LEFT);

        ImageView likeImage2 = new ImageView(getClass().getResource("/BANQUES/icones/add.png").toString());
        btnAjouter.setGraphic(likeImage2);
        btnAjouter.setContentDisplay(ContentDisplay.LEFT);

        ImageView likeImage3 = new ImageView(getClass().getResource("/BANQUES/icones/imprimante.png").toString());
       
        btnImprimer.setGraphic(likeImage3);
        btnImprimer.setContentDisplay(ContentDisplay.LEFT);
    }

    @FXML
    private void Articles() throws SQLException {
        tfDesignation.setText("" + Articles.getValue());
        try {
            tfPrixUnitaire.setText("" + prixArticle(Articles.getValue()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String prixArticle(String val) throws ClassNotFoundException, SQLException {
        Connection connexion = null;
         

        String valeur = null;

        try {
            

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/gestion";
            String user = "root";
            String passwd = "";
            connexion = DriverManager.getConnection(url, user, passwd);

            Statement state = connexion.createStatement();
            PreparedStatement insert = connexion.prepareStatement("SELECT prixProduit FROM produits where nomProduit=?");
            insert.setString(1, val);

            ResultSet result = insert.executeQuery();
            while (result.next()) {
                valeur = result.getString("prixProduit");
                
                return valeur;
            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Connexion introuvable =>" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connexion impossible =>" + e.getMessage());
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
               
                e.printStackTrace();
            }

        }
        return valeur;

    }

    @FXML
    private void Calculer() throws SQLException {

        Produits Article;
        String Desi = Articles.getValue();
        int qte = Integer.parseInt(tfQte.getText());
        Double prixUni = Double.parseDouble(tfPrixUnitaire.getText());
        PrixTotal = qte * prixUni;

        tfPrixTCC.setText("" + PrixTotal);
        numero++;

        Article = new Produits(numero, Desi, qte, prixUni, PrixTotal);

        if (Article != null) {

            produitList.add(Article);

            colNumProd.setCellValueFactory(new PropertyValueFactory<Produits, Integer>("numero"));
            colDesignation.setCellValueFactory(new PropertyValueFactory<Produits, String>("Designation"));
            colQte.setCellValueFactory(new PropertyValueFactory<Produits, Integer>("Quantite"));
            colPrixU.setCellValueFactory(new PropertyValueFactory<Produits, Double>("PrixUnitaire"));
            colPrixTTC.setCellValueFactory(new PropertyValueFactory<Produits, Double>("PrixTTC"));

            tbProduits.setItems(produitList);
            addSales();

        } else {
            JOptionPane.showMessageDialog(null, "Aucun produit n'a ete pris");
        }

    }

    @FXML
    private void Valider() {
        Double difference;

        somme += PrixTotal;
        tfPrixTOT.setText("" + somme);
        if (tfReduction.getText().equals("")) {
            tfNetAPayer.setText(tfPrixTOT.getText());

            Integer val;
            double solde = Double.parseDouble(tfNetAPayer.getText());
            val = (int) solde;
            tfMontantLettre.setText("" + Convertion.conversion(val) + " " + devise.getValue());

        } else {
            difference = somme - Double.parseDouble(tfReduction.getText());
            tfNetAPayer.setText("" + difference);
            Integer val;
            double solde = Double.parseDouble(tfNetAPayer.getText());
            val = (int) solde;
            tfMontantLettre.setText("" + Convertion.conversion(val) + " " + devise.getValue());
        }
    }

    private void addSales() throws SQLException {

        Date dates = Date.valueOf(tfDate.getValue());
        double prixUnitaire = Double.parseDouble(tfPrixUnitaire.getText());

        String query2 = "INSERT INTO ventes (nomProduits,quantite,prixUnitaire,dateFacture) VALUES ('" + tfDesignation.getText() + "', " + tfQte.getText() + "," + prixUnitaire + "," + "'" + dates + "'" + ")";
        if( tfAdresse.getText().equals("") || tfNom.getText().equals("") || tfPrenom.getText().equals("") ||  tfContacts.getText().equals("")){
                    Toast();
        }

        ExecuteQueries(query2);

    }

    public Connection getConnection() {

        Connection conn ;
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

    private void ExecuteQueries(String query) throws SQLException {
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
    private void Imprimer() {
        final PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null) {

            if (printerJob.printPage(tbProduits)) {
                printerJob.endJob();
            }
        }
    }
    
       
    private void Toast() {
        Stage stage = new Stage();

        String toastMsg = "Veuillez prendre de remplir les champs indiqués!!! ";
        int toastMsgTime = 2500; //2.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime = 500; //0.5 seconds
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);

    }

}
