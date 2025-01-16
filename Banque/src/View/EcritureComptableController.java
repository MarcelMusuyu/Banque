/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class EcritureComptableController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private Pane tfPTTC;
    private Text resume;
    @FXML
    private Text resume3;
    @FXML
    private Text resume2;
    @FXML
    private Text resume4;
    @FXML
    private Pane tfPTTC1;
    @FXML
    private Text resume1;
    @FXML
    private Pane tfPTTC11;
    @FXML
    private Pane tfPTTC111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         TranslateTransition translate = new TranslateTransition();
        translate.setNode( resume3);
        translate.setDuration(Duration.seconds(30));
        translate.setCycleCount(TranslateTransition.INDEFINITE);       
        translate.setByX(1400);       
        translate.play();
        
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode( resume1);
        translate2.setDuration(Duration.seconds(30));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setByX(1400);        
        translate2.playFrom(Duration.seconds(25));
        
         TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode( resume2);
        translate3.setDuration(Duration.seconds(30));
        translate3.setCycleCount(TranslateTransition.INDEFINITE);    
        translate3.setByX(1400);     
         translate3.playFrom(Duration.seconds(20));
        
         TranslateTransition translate4 = new TranslateTransition();
        translate4.setNode( resume4);
        translate4.setDuration(Duration.seconds(30));
        translate4.setCycleCount(TranslateTransition.INDEFINITE);    
        translate4.setByX(1400);     
         translate4.playFrom(Duration.seconds(15));
        
        
        
    }    
    
}
