/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MARCEL
 */
public class Connexion {
    
      public static  Connection getConnection() {
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
      
        public static  void  ExecuteQueries(String query) {
        Connection conn = getConnection();

        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
   public static  String   ResultQueries(String query,String retour) {
        Connection conn =getConnection();

        Statement st;
        try {
            st = conn.createStatement();
            ResultSet resultat= st.executeQuery(query);
            while(resultat.next()){
                return resultat.getString(retour);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
          return null;
    }
    
}
