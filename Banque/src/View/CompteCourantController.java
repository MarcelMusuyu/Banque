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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class CompteCourantController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private DatePicker dates;
    @FXML
    private TableView<?> transactions;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private ImageView imgBack;
    @FXML
    private ImageView imgForward;
    @FXML
    private ImageView home;
    @FXML
    private ImageView tools;
    @FXML
    private TextField c;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void soldeAccount(KeyEvent event) {
    }

    @FXML
    private void soldeAccount(MouseEvent event) {
    }
    
}
