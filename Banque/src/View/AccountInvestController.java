/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class AccountInvestController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView likeImag2 = new ImageView(getClass().getResource("/BANQUES/checked.png").toString());
        btnValider.setGraphic(likeImag2);
    }

}
