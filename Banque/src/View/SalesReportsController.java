/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class SalesReportsController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private BarChart<String, Integer> salesBarchar;
    @FXML
    private Button actualiser;
    @FXML
    private LineChart<String, Double> salesLinechar;
    @FXML
    private ImageView home;
    @FXML
    private ImageView load;
    @FXML
    private ImageView share;
    @FXML
    private ImageView print;
    @FXML
    private ImageView save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SalesR();
        ImageView likeImag2 = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());

        actualiser.setGraphic(likeImag2);
        actualiser.setContentDisplay(ContentDisplay.LEFT);
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

    public void SalesR() {

        Connection conn = getConnection();
        String query = "SELECT nomProduits,quantite,prixUnitaire  FROM ventes";
        Statement st;
        ResultSet rx;

        try {

            st = conn.createStatement();
            rx = st.executeQuery(query);

            XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
            XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
            while (rx.next()) {

                series.getData().add(new XYChart.Data<String, Integer>(rx.getString("nomProduits"), rx.getInt("quantite")));
                series1.getData().add(new XYChart.Data<String, Double>(rx.getString("nomProduits"), rx.getDouble("prixUnitaire")));

            }
            salesBarchar.getData().add(series);
            salesLinechar.getData().add(series1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void Actualiser() {
        SalesR();
    }

    @FXML
    private void Fichier() {
        final FileChooser dialog = new FileChooser();
         dialog.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(".pdf", ".txt", ".html",".png",".jpe")); 
        final File file = dialog.showSaveDialog(save.getScene().getWindow());
        if (file != null) {

            JOptionPane.showMessageDialog(null, "Enregistrement reussi !!!");
            
            //Alert show=new Alert(AlertType.INFORMATION);
            //show.setTitle("Save");
            //show.setHeaderText("Enregistrement reussi");
           // show.setResizable(false);
           //show.setContentText("je suis une dialog box");
          // show.showAndWait();
        }
    }

}
