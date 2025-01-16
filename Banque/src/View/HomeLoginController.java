/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Model.Connexion;
import Model.DBconnection;
import banque.FXMLDocumentController;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class HomeLoginController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUsername;
    @FXML
    private Button btnValider;
    @FXML
    private Hyperlink HyperCreate;
    @FXML
    private ComboBox<String> typeUsers;
    public String chaine;
    public String resultat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> countList = FXCollections.observableArrayList();
        countList.addAll("investisseur", "banque", "entreprise");
        typeUsers.setItems(countList);
    }

    @FXML
    private void valider() {
        if (tfPassword.getText().equals("") || tfUsername.getText().equals("") || typeUsers.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "veillez saisir tous les champs");
        } else {

            resultat = SelectUsers(tfUsername.getText(),tfPassword.getText());
             

            if (resultat.equals("investisseur")) {
                JOptionPane.showMessageDialog(null, "vous etes investisseur");
            } else if (resultat.equals("banque")) {
                bank();
            } else if (resultat.equals("entreprise")) {
                firm();
            }
        }
    }

    private void bank() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("/banque/Acceuil.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("BankInvest");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String SelectUsers(String username, String Password) {
        Connection conn = DBconnection.getConnexion();
        Statement state = null;
        if (conn != null) {

            String query = "SELECT *  FROM  utilisateurs WHERE  Username ="+"'"+username+"'"+" AND passWord ="+"'"+Password+"'";

            try {
                state = conn.createStatement();
                
                ResultSet result = state.executeQuery(query);
               
               while(result.next())
                      
                     return result.getString("typeUsers");

            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        } else {

            return null;
        }
        return null;

    }

    private void firm() {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("/banque/Firmes.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("FirmInvest");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
