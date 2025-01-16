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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MARCEL
 */
public class CalculatorController implements Initializable {

    @FXML
    private TextField ecran;
    @FXML
    private RadioButton on;
    @FXML
    private RadioButton off;
    @FXML
    private Button exp;
    @FXML
    private Button sin;
    @FXML
    private Button cos;
    @FXML
    private Button tan;
    @FXML
    private Button divX;
    @FXML
    private Button log;
    @FXML
    private Button sinh;
    @FXML
    private Button cosh;
    @FXML
    private Button tanh;
    @FXML
    private Button exposantY;
    @FXML
    private Button mod;
    @FXML
    private Button clr;
    @FXML
    private Button plus;
    @FXML
    private Button sept;
    @FXML
    private Button huit;
    @FXML
    private Button neuf;
    @FXML
    private Button moins;
    @FXML
    private Button exposant2;
    @FXML
    private Button quatre;
    @FXML
    private Button cinq;
    @FXML
    private Button six;
    @FXML
    private Button multi;
    @FXML
    private Button facto;
    @FXML
    private Button un;
    @FXML
    private Button deux;
    @FXML
    private Button trois;
    @FXML
    private Button div;
    @FXML
    private Button plusmoins;
    @FXML
    private Button zero;
    @FXML
    private Button point;
    @FXML
    private Button egal;
    @FXML
    private Button pi;
    @FXML
    private Button square;
    @FXML
    private Button back;
    
    double num1,num2,result;
    String opr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     @FXML
     private void un(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(un.getText());
         }else{
               ecran.setText(ecran.getText()+un.getText());
         }
        
     }
     
       @FXML
     private void deux(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(deux.getText());
         }else{
               ecran.setText(ecran.getText()+deux.getText());
         }
        
     }
     
       @FXML
     private void trois(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(trois.getText());
         }else{
               ecran.setText(ecran.getText()+trois.getText());
         }
        
     }
     
       @FXML
     private void quatre(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(quatre.getText());
         }else{
               ecran.setText(ecran.getText()+quatre.getText());
         }
        
     }
     
       @FXML
     private void cinq(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(cinq.getText());
         }else{
               ecran.setText(ecran.getText()+cinq.getText());
         }
        
     }
     
       @FXML
     private void six(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(six.getText());
         }else{
               ecran.setText(ecran.getText()+six.getText());
         }
        
     }
     
       @FXML
     private void sept(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(sept.getText());
         }else{
               ecran.setText(ecran.getText()+sept.getText());
         }
        
     }
     
       @FXML
     private void huit(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(huit.getText());
         }else{
               ecran.setText(ecran.getText()+huit.getText());
         }
        
     }
     
       @FXML
     private void neuf(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(neuf.getText());
         }else{
               ecran.setText(ecran.getText()+neuf.getText());
         }
        
     }
     
       @FXML
     private void zero(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(zero.getText());
         }else{
               ecran.setText(ecran.getText()+zero.getText());
         }
        
     }
     
     
      @FXML
     private void point(){
         if(ecran.getText().equals("0.0")){
              ecran.setText(point.getText());
         }else{
               ecran.setText(ecran.getText()+point.getText());
         }
        
     }
     
    @FXML
    private void  clr(){
         ecran.setText("");
         ecran.setPromptText("");
    }
    
     @FXML
    private void  backspace(){
         String backS =null;
         if(ecran.getText().length() > 0){
             StringBuilder x= new StringBuilder(ecran.getText());
             x.deleteCharAt(ecran.getText().length()-1);
             backS=x.toString();
             ecran.setText(backS);
         }
    }
    
    @FXML
    private void  addition(){
        num1=Double.parseDouble(ecran.getText());
         
        ecran.setText("");
          ecran.setPromptText(Double.toString(num1)+" "+plus.getText());
        opr=plus.getText();
    }
    
    
      @FXML
    private void  PowerY(){
        num1=Double.parseDouble(ecran.getText());
         
        ecran.setText("");
          ecran.setPromptText(Double.toString(num1));
        opr=exposantY.getText();
    }
    
    
      @FXML
    private void  soustraction(){
        num1=Double.parseDouble(ecran.getText());
         
        ecran.setText("");
        ecran.setPromptText(Double.toString(num1)+" "+moins.getText());
        opr=moins.getText();
    }
    
      @FXML
    private void  division(){
        num1=Double.parseDouble(ecran.getText());
         
        ecran.setText("");
         ecran.setPromptText(Double.toString(num1)+" "+div.getText());
        opr=div.getText();
    }
    
      @FXML
    private void  multiplication(){
        num1=Double.parseDouble(ecran.getText());
         
        ecran.setText("");
         ecran.setPromptText(Double.toString(num1)+" "+multi.getText());
        opr=multi.getText();
    }
    
     @FXML
    private void  modulo(){
        num1=Double.parseDouble(ecran.getText());
         
        ecran.setText("");
         ecran.setPromptText(Double.toString(num1)+mod.getText());
        opr=mod.getText();
    }
    
     
      @FXML
    private void  egaliser(){
        num2=Double.parseDouble(ecran.getText());
       
        if(opr.equals("+")){
            result=num1+num2;
            ecran.setText(Double.toString(result));
        }else if(opr.equals("-")){
             result=num1-num2;
            ecran.setText(Double.toString(result));
        }else  if(opr.equals("*")){
              result=num1*num2;
            ecran.setText(Double.toString(result));
        }else   if(opr.equals("/")){
            try{
                result=num1/num2;
              ecran.setText(Double.toString(result));
            }catch(ArithmeticException e){
                  ecran.setText(e.toString());
            }
        }else if (opr.equals("%")){
             try{
                result=num1%num2;
              ecran.setText(Double.toString(result));
            }catch(ArithmeticException e){
                  ecran.setText(e.toString());
            }
        }else if(opr.equals("x^y")){
              result=Math.pow(num1, num2);
              ecran.setText(Double.toString(result));
        }
    }
    
       @FXML
    private void  sinus(){
        double val = Math.sin(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
       @FXML
    private void  cosinus(){
        double val = Math.cos(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
       @FXML
    private void  tangente(){
        double val = Math.tan(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
       @FXML
    private void  sinusHyper(){
        double val = Math.sinh(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
    
       @FXML
    private void  cosenusHyper(){
        double val = Math.cosh(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
         @FXML
    private void  tangenteHyper(){
        double val = Math.tanh(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
        @FXML
    private void  exponentiel(){
        double val = Math.exp(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
    
      @FXML
    private void  logarithmique(){
        double val = Math.log(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
       @FXML
    private void  Factorielle(){
        double val =facto(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
    double facto(double val){
        if(val<1){
            return 1;
        }else
            return val*facto(val-1);
    }
    
      @FXML
    private void  Pi(){
        
        ecran.setText(""+Math.PI);
    }
    
    @FXML
    private void divideByUn(){
        double val=Double.parseDouble(ecran.getText());
        try{
              double  res=1/val;
              ecran.setText(Double.toString(res));
            }catch(ArithmeticException e){
                  ecran.setText(e.toString());
            }
    }
    
    @FXML
    private void  Square(){
        double val =Math.sqrt(Double.parseDouble(ecran.getText()));
        ecran.setText(""+val);
    }
    
     @FXML
    private void  Power(){
        double val =Math.pow(Double.parseDouble(ecran.getText()),2);
        ecran.setText(""+val);
    }
    
    @FXML
    private void Enable(){
        ecran.setDisable(false);
        off.setSelected(false);
         ecran.setVisible(true);
    }
    
     @FXML
    private void Desable(){
        ecran.setDisable(true);
        on.setSelected(false);
        ecran.setText("");
         ecran.setPromptText("");
        ecran.setVisible(false);
    }
}
