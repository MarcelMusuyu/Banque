/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class EntrepriseController implements Initializable {

 
    @FXML
    private BarChart<String, Integer> industrie;
    @FXML
    private AreaChart<String, Integer> service;
    @FXML
    private ImageView imgBack;
    @FXML
    private TextField c;
    @FXML
    private ImageView imgForward;
    @FXML
    private ImageView home;
    @FXML
    private ImageView tools;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private Menu mnfinanciere;
    @FXML
    private Menu mncommerciale;
    @FXML
    private Menu mnApprov;
    @FXML
    private MenuItem stock;
    @FXML
    private Menu mndistribution;
    @FXML
    private MenuItem facturation;
    @FXML
    private MenuItem livraison;
    @FXML
    private MenuItem caisse;
    @FXML
    private MenuItem ventes;
    @FXML
    private Menu mncomptabilite;
    @FXML
    private Menu mnsociale;
    @FXML
    private Menu mnfiscale;
    @FXML
    private Menu mncomptabilite1;
    @FXML
    private MenuItem mnItemsalaireBase;
    @FXML
    private MenuItem mnItemfichePaie;
    @FXML
    private MenuItem mnItemIndemnites;
    @FXML
    private MenuItem mnItemAllocations;
    @FXML
    private Menu mninformatique;
    @FXML
    private Menu mnlogistique;
    @FXML
    private Menu mnadministraative;
    @FXML
    private Menu mnproduction;
    @FXML
    private Menu mnsecurite;
    @FXML
    private Menu mnstatistiques;
    @FXML
    private Menu mnproduction1;
    @FXML
    private Menu mnproduction11;
    @FXML
    private MenuItem mnGenerales;
    @FXML
    private Menu mnmarketing;
    @FXML
    private MenuItem mnItempublicite;
    @FXML
    private Menu mnmarketing1;
    @FXML
    private MenuItem lettre;
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private ImageView print;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
    

        series.getData().add(new XYChart.Data<String, Integer>("Microsoft corporation", 60000000));
        series.getData().add(new XYChart.Data<String, Integer>("Oracle corporation", 39000000));
        series.getData().add(new XYChart.Data<String, Integer>("NetBeans.org", 45000000));
        series.getData().add(new XYChart.Data<String, Integer>("Opera software", 20000000));
        series.getData().add(new XYChart.Data<String, Integer>("Oracle corporation", 50000000));
        series.getData().add(new XYChart.Data<String, Integer>("Mars technologie", 90000000));
        series.getData().add(new XYChart.Data<String, Integer>("Blender foundation", 30000000));
        series.getData().add(new XYChart.Data<String, Integer>("Mars bank", 1900000));
        series.getData().add(new XYChart.Data<String, Integer>("Labcenter electronics", 1000000));
        series.getData().add(new XYChart.Data<String, Integer>("Mars spaceAeraunotic", 12000000));

      

        series2.getData().add(new XYChart.Data<String, Integer>("Microsoft corporation", 60000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Oracle corporation", 39000000));
        series2.getData().add(new XYChart.Data<String, Integer>("NetBeans.org", 45000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Opera software", 2000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Oracle corporation", 50000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Mars technologie", 90000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Blender foundation", 30000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Mars bank", 19000000));
        series2.getData().add(new XYChart.Data<String, Integer>("Labcenter electronics", 10000000));
        series.getData().add(new XYChart.Data<String, Integer>("Mars spaceAeraunotic", 120000000));

      
        industrie.getData().add(series2);
        service.getData().add(series);

    }

    @FXML
    private void soldeAccount() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.centerOnScreen();
            stage.setMaximized(false);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Facture() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/Facturation.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RepportSales() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/salesReports.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Sales");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ventes() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/EcritureComptable.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Vente");
            stage.centerOnScreen();

            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Stock() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/Stock.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Correspondance() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/Correspondance.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void FichePaie() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/BulletinPaie.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void States() {
        Stage stage = new Stage();

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/Statistiques.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Statistiques");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void publicite() {
        URL uri;
        try {
            uri = new URL("http://localhost/banque/pages/index.php");
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(uri.toURI());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(EntrepriseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
