/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banque;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MARCEL
 */
public class Banque extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/View/HomeLogin.fxml"));
            root.autosize();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("BankInvesting");
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
