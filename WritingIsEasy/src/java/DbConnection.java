
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sary
 * Classe per la gestione del Db e la sua connessione
 */
public class DbConnection {
    private static DbConnection singleton;
    
    //Ci garantisce che venga eseguito una sola volta nella getInstance
    private DbConnection(){
        try{
            /*
                si carica a run-time la classe del driver 
                tramite il nome del driver stesso
            */
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex)
        {
            //Viene sollevata l'eccezione --> classe driver che abbiamo specificato 
            // non viene caricata con successo 
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static DbConnection getInstance(){
        if(singleton==null) // ancora non è stata effettuata la connessione al db
        {
            singleton = new DbConnection();
        }
        return singleton;
    }
    
    public Connection getConnection()
    {
        Connection conn =null;
        
        String str_conn = "jdbc:mysql://localhost:3306/mysql";
        
        try{
            //Connessione al db con username = 'root' e password specificata
            conn = DriverManager.getConnection(str_conn, "root", "wlrDTKHt");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        //Se conn == null, la connessione non è andata a buon fine 
        return conn;
    }
    
}
