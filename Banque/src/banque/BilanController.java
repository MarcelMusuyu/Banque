/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class BilanController implements Initializable {

    @FXML
    private AnchorPane creation;
    @FXML
    private Button equilibrer;
    @FXML
    private Button enregistrer;
    @FXML
    private Button imprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView likeImag = new ImageView(getClass().getResource("/BANQUES/icones/check.png").toString());
         ImageView likeImag1 = new ImageView(getClass().getResource("/BANQUES/icones/pri.jpeg").toString());
      ImageView likeImag2 = new ImageView(getClass().getResource("/BANQUES/icones/save.png").toString());
      
         
        equilibrer.setGraphic(likeImag);
        equilibrer.setContentDisplay(ContentDisplay.LEFT);
        
        enregistrer.setGraphic(likeImag2);
       enregistrer.setContentDisplay(ContentDisplay.LEFT);
        
        imprimer.setGraphic(likeImag1);
       imprimer.setContentDisplay(ContentDisplay.LEFT);
       
      

    }

    public void ShowBooks() {

    }

}
