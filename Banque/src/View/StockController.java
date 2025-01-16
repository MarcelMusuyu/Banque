/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class StockController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private Pane tfPTTC;
    @FXML
    private TableView<Stock> tableStock;
    @FXML
    private TableColumn<Stock, LocalDate> colDateEntree;
    @FXML
    private TableColumn<Stock, Integer> colQteEntree;
    @FXML
    private TableColumn<Stock, Double> colCoutUnitaireEntree;
    @FXML
    private TableColumn<Stock, Double> colCoutTotalEntree;
    @FXML
    private TableColumn<Stock, LocalDate> colDateSortie;
    @FXML
    private TableColumn<Stock, Integer> colQteSortie;
    @FXML
    private TableColumn<Stock, Double> colCoutUnitaireSortie;
    @FXML
    private TableColumn<Stock, Double> colCoutTotalSortie;
    @FXML
    private TableColumn<Stock, LocalDate> colDateStock;
    @FXML
    private TableColumn<Stock, Integer> colQteStock;
    @FXML
    private TableColumn<Stock, Double> colCoutUnitaireStock;
    @FXML
    private TableColumn<Stock, Double> colCoutTotalStock;
    @FXML
    private Button ajouter;
    @FXML
    private TextField tfOperation;
    @FXML
    private MenuBar titleBar;
    @FXML
    private Menu mnFile;
    @FXML
    private MenuItem mnItemNew;
    @FXML
    private MenuItem mnItemOpen;
    @FXML
    private MenuItem mnItemSave;
    @FXML
    private MenuItem mnItemModify;
    @FXML
    private MenuItem mnItemClose;
    @FXML
    private Menu mnVariations;
    @FXML
    private MenuItem mnItemStockIni;
    @FXML
    private MenuItem mnItemStockFi;
    @FXML
    private Menu mnStatistiques;
    @FXML
    private MenuItem mnItemEntree;
    @FXML
    private MenuItem mnItemSortie;
    @FXML
    private MenuItem mnItemStock;
    @FXML
    private HBox entrees;
    @FXML
    private DatePicker tfdateEntree;
    @FXML
    private TextField tfQteEntree;
    @FXML
    private TextField tfcoutUnitaireEntree;
    @FXML
    private TextField tfcouttotalEntree;
    @FXML
    private HBox sorties;
    @FXML
    private DatePicker tfdateSortie;
    @FXML
    private TextField tfQteSortie;
    @FXML
    private TextField tfcoutUnitaireSortie;
    @FXML
    private TextField tfcoutTotalSortie;
    @FXML
    private HBox stock;
    @FXML
    private DatePicker tfDateStock;
    @FXML
    private TextField tfQteStock;
    @FXML
    private TextField tfcoutUnitaireStock;
    @FXML
    private TextField tfcoutTotalStock;
    @FXML
    private Button btnCloturer;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnSave;

    public static ObservableList<Stock> produitList = FXCollections.observableArrayList();
    
    public static int indice1 = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ImageView likeImage3 = new ImageView(getClass().getResource("/BANQUES/icones/check.png").toString());
       
        btnCloturer.setGraphic(likeImage3);
        btnCloturer.setContentDisplay(ContentDisplay.LEFT);
        
         ImageView likeImage = new ImageView(getClass().getResource("/BANQUES/icones/save.png").toString());
       
        btnSave.setGraphic(likeImage);
       btnSave.setContentDisplay(ContentDisplay.LEFT);
        
         ImageView likeImage2 = new ImageView(getClass().getResource("/BANQUES/icones/5718779.png").toString());
       
         btnAnnuler.setGraphic(likeImage2);
         btnAnnuler.setContentDisplay(ContentDisplay.LEFT);
    }

    @FXML
    private void Stockage() {

        if (tfQteSortie.getText().equals("") && tfcoutUnitaireSortie.getText().equals("") && tfcoutTotalSortie.getText().equals("")) {
            Stock Enregistrement;
            LocalDate date = tfdateEntree.getValue();
            int qte = Integer.parseInt(tfQteEntree.getText());
            double cu = Double.parseDouble(tfcoutUnitaireEntree.getText());
            double value = qte * cu;
            tfcouttotalEntree.setText("" + value);
            double ct = Double.parseDouble(tfcouttotalEntree.getText());

            Enregistrement = new Stock(date, qte, cu, ct);
            produitList.add(Enregistrement);
            colDateEntree.setCellValueFactory(new PropertyValueFactory<Stock, LocalDate>("Dates"));
            colQteEntree.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("Quantite"));
            colCoutUnitaireEntree.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutUnitaire"));
            colCoutTotalEntree.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutTotal"));

            colDateStock.setCellValueFactory(new PropertyValueFactory<Stock, LocalDate>("Dates"));
            colQteStock.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("Quantite"));
            colCoutUnitaireStock.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutUnitaire"));
            colCoutTotalStock.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutTotal"));

            tableStock.setItems(produitList);
            
            tfQteEntree.setText("");
            tfcoutUnitaireEntree.setText("");
            tfcouttotalEntree.setText("");
        } else if (tfQteEntree.getText().equals("") && tfcoutUnitaireEntree.getText().equals("") && tfcouttotalEntree.getText().equals("")) {
            Stock destockage;
            LocalDate datesortie = tfdateSortie.getValue();
            int qtesortie = Integer.parseInt(tfQteSortie.getText());
            double cusortie = Double.parseDouble(tfcoutUnitaireSortie.getText());
            double valuesortie = qtesortie * cusortie;
            tfcoutTotalSortie.setText("" + valuesortie);
            double ctsortie = Double.parseDouble(tfcoutTotalSortie.getText());

            destockage = new Stock(datesortie, qtesortie, cusortie, ctsortie);

            colDateSortie.setCellValueFactory(new PropertyValueFactory<Stock, LocalDate>("Dates"));
            colQteSortie.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("Quantite"));
            colCoutUnitaireSortie.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutUnitaire"));
            colCoutTotalSortie.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutTotal"));

            colDateStock.setCellValueFactory(new PropertyValueFactory<Stock, LocalDate>("Dates"));
            colQteStock.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("Quantite"));
            colCoutUnitaireStock.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutUnitaire"));
            colCoutTotalStock.setCellValueFactory(new PropertyValueFactory<Stock, Double>("CoutTotal"));
            produitList.remove(this);
            produitList.add(destockage);

            tableStock.setItems(produitList);
             tfQteSortie.setText("");
            tfcoutUnitaireSortie.setText("");
            tfcoutTotalSortie.setText("");
        }
        indice1++;

    }

}
