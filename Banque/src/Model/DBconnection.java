
package  Model;;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
    public static Connection getConnexion(){
        String url="jdbc:sqlite:Connexion.db";
        Connection conn = null;
        try{
            conn =DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
