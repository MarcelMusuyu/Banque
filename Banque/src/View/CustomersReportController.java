/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Customers;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class CustomersReportController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ImageView load;
    @FXML
    private ImageView share;
    @FXML
    private ImageView print;
    @FXML
    private ImageView export;
    @FXML
    private ImageView save;
    @FXML
    private Button actualiser;
    @FXML
    private TableView<Customers> tableCustomers;

    public static ObservableList<Customers> clients = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Customers, String> clnom;
    @FXML
    private TableColumn<Customers, String> clpostnom;
    @FXML
    private TableColumn<Customers, String> clcontacts;
    @FXML
    private TableColumn<Customers, String> cladresses;

    @FXML
    private TableColumn<Customers, String> clnumero;
    @FXML
    private TableColumn<Customers, String> cltype;

    @FXML
    private TableColumn<Customers, Double> clsolde;
    @FXML
    private TableColumn<Customers, Date> cldates;
    @FXML
    private TableColumn<Customers, String> cldevise;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowCustomers();
    }

    @FXML
    private void Actualiser(ActionEvent event) {
        ShowCustomers();
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

    public ObservableList<Customers> getCustomersList() {
        ObservableList<Customers> customersList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT client.nomClient,client.postnomClient,client.Contact,client.Adresse,compte.numCompte,compte.typeCompte, compte.solde,compte.dateCreation,compte.devise from client inner join compte on client.idClient=compte.client_idClient";
        Statement st;
        ResultSet rx;
        

        try {
            st = conn.createStatement();
            rx = st.executeQuery(query);
            Customers clients;

            while (rx.next()) {
          
                clients = new Customers(rx.getString("nomClient"), rx.getString("postnomClient"), rx.getString("Contact"), rx.getString("Adresse"), rx.getString("numCompte"), rx.getString("typeCompte"), rx.getDouble("solde"), rx.getDate("dateCreation"), rx.getString("devise"));
                customersList.add(clients);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customersList;
    }

    public void ShowCustomers() {
        ObservableList<Customers> list = getCustomersList();
        clnom.setCellValueFactory(new PropertyValueFactory<Customers,String>("nom"));
        clpostnom.setCellValueFactory(new PropertyValueFactory<Customers,String>("postnom"));
        clcontacts.setCellValueFactory(new PropertyValueFactory<Customers,String>("contacts"));
        cladresses.setCellValueFactory(new PropertyValueFactory<Customers,String>("adresses"));
        clnumero.setCellValueFactory(new PropertyValueFactory<Customers,String>("numero"));
        cltype.setCellValueFactory(new PropertyValueFactory<Customers,String>("type"));
        clsolde.setCellValueFactory(new PropertyValueFactory<Customers,Double>("solde"));
        cldates.setCellValueFactory(new PropertyValueFactory<Customers,Date>("dates"));
        cldevise.setCellValueFactory(new PropertyValueFactory<Customers,String>("devise"));
        tableCustomers.setItems(list);

    }

}
