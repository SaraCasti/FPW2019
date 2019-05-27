
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 */
public class UtenteFactory {
    private static UtenteFactory singleton;
    private ArrayList<Utente> usersList = new ArrayList<Utente>();
    
    private UtenteFactory(){
        testConnection();
        
        //popolare i nostri utenti
        Utente u1 = new Utente();
        u1.setUsername("Sara91");
        u1.setPassword("01234");
        u1.setEmail("sara@unica.it");
        u1.setEta(28);
        
        Utente u2 = new Utente();
        u2.setUsername("Davide89");
        u2.setPassword("01234");
        u2.setEmail("davide@unica.it");
        u2.setEta(23);
        
        Utente u3 = new Utente();
        u3.setUsername("Riccardo89");
        u3.setPassword("9999");
        u3.setEmail("riccardo@gmail.it");
        u3.setEta(20);
        
        this.usersList.add(u1);
        this.usersList.add(u2);
        this.usersList.add(u3);
    }
    
    public static UtenteFactory getInstance(){
        if(singleton==null)
        {
            singleton = new UtenteFactory();  
        }
        return singleton;      
    }
    
    public ArrayList<Utente> getAllUsers(){
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();
        
       return this.usersList;
    }
    
    public boolean login(String usr, String psw){
        DbConnection connFact = DbConnection.getInstance();
        Connection conn = connFact.getConnection();
        
        boolean is_logged = false;
       
        try{
            
            //Sintassi sql contro sql injection
            String sql = "select * from utente where username = ? and password = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, usr);
            stmt.setString(2, psw);
            
            ResultSet set = stmt.executeQuery();
            
            //Se la query mi ha restituito con successo l'utente
            while(set.next())
            {
                is_logged = true;
            }
            
            //Chiudo la connessione
            stmt.close();
            conn.close();
                   
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,e);
        }
        //L'utente con username urs e password psw non esiste
        return is_logged;
    }
    
    public Utente getUser(String usr, String psw)
    {
        for(Utente u : this.usersList)
        {
            //Controlla che corrisponda ad un utente
            String tmpUsername = u.getUsername();
            String tmpPassword = u.getPassword();
            
            if(tmpUsername.equals(usr) && tmpPassword.equals(psw))
            {
                return u;
            }
        }
        return null;
    }
    
    public boolean removeUser(int idUser){
        Connection conn=null;
        try
        {
            DbConnection connFact = DbConnection.getInstance();
            conn = connFact.getConnection();
            
            conn.setAutoCommit(false);
            
            //Query relativa alla rimozione dei suoi libri
            String sql0 = "delete from libro where autore = ?";
            PreparedStatement remL = conn.prepareStatement(sql0);
            remL.setInt(1, idUser);
            remL.executeUpdate();
    
            
            //Query relativa alla rimozione dell'utente
            String sql = "delete from utente where codU = ?";
            PreparedStatement remU = conn.prepareStatement(sql);
            
            remU.setInt(1,idUser);
            
            remU.executeUpdate();
            
            
            conn.commit();
            conn.setAutoCommit(true);
            
            //Chiudo la connessione
            remU.close();
            remL.close();
            conn.close();
            return true;
            
        }catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,e);
            if(conn!=null)
            {
                try{
                    conn.rollback();
                }catch(SQLException eR )
                {
                    Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,eR);
                }
            }
        }
        return false;
    }
    
    
    void testConnection(){
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();
        
        if(conn!=null)
        {
            System.out.println("Connessione eseguita con successo");
        }
    }
}
