/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Convertion.Convertion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.ContentDisplay;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class SoldeController implements Initializable {

    @FXML
    private AnchorPane creation;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private PasswordField tfNumero;
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
    private Label lbName;
    @FXML
    private Label lbLastname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

          ImageView likeImag= new ImageView(getClass().getResource("/BANQUES/checked.png").toString());
         btnEnregistrer.setGraphic(likeImag);
         btnEnregistrer.setContentDisplay(ContentDisplay.LEFT);
    }

    @FXML
    private void transactions(ActionEvent event) {
            transact() ;
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


    private void transact() {

        int val = 0;
        String devise = null;
        double solde=0.0;
        Connection conn = getConnection();
        String query = "SELECT client.nomClient,client.postnomClient,compte.solde,compte.devise FROM client "
                + "INNER JOIN compte on client.idClient = compte.client_idClient WHERE compte.numCompte = '" + tfNumero.getText() + "'";

        Statement st;
        ResultSet rx;

        try {

            st = conn.createStatement();
            rx = st.executeQuery(query);

            while (rx.next()) {
                lbName.setText("" + rx.getString("nomClient"));
                lbLastname.setText("" + rx.getString("postnomClient"));
               solde = rx.getDouble("solde");
                devise = rx.getString("devise");

            }
            val=(int) solde;

            tfMontantLetttre.setText("" + Convertion.conversion(val) + " " + devise);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
