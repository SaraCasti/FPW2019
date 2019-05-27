
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    //private ArrayList<Utente> usersList = new ArrayList<Utente>();

    private UtenteFactory() {

    }

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    public ArrayList<Utente> getAllUsers() {
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();
        ArrayList<Utente> usersList = new ArrayList<Utente>();

        try {

            //Sintassi sql contro sql injection
            String sql = "select * from utente";
            Statement stmt = conn.createStatement();

            ResultSet set = stmt.executeQuery(sql);

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                Utente u = new Utente();
                u.setUsername(set.getString("username"));
                u.setEmail(set.getString("email"));
                u.setEta(set.getInt("eta"));

                usersList.add(u);
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }

        return usersList;
    }

    public boolean login(String usr, String psw) {
        DbConnection connFact = DbConnection.getInstance();
        Connection conn = connFact.getConnection();

        boolean is_logged = false;

        try {

            //Sintassi sql contro sql injection
            String sql = "select * from utente where username = ? and password = ? ";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usr);
            stmt.setString(2, psw);

            ResultSet set = stmt.executeQuery();

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                is_logged = true;
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        //L'utente con username urs e password psw non esiste
        return is_logged;
    }

    public Utente getUser(String usr, String psw) {  
        DbConnection connFact = DbConnection.getInstance();
        Connection conn = connFact.getConnection();
        Utente u=null;
        try {

            //Sintassi sql contro sql injection
            String sql = "select * from utente where username = ? and password = ? ";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usr);
            stmt.setString(2, psw);

            ResultSet set = stmt.executeQuery();

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                u = new Utente();
                u.setCodU(set.getInt("codU"));
                u.setUsername(set.getString("username"));
                u.setEmail(set.getString("email"));
                u.setEta(set.getInt("eta"));
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        //L'utente con username urs e password psw non esiste
        return u;
    }

    public boolean removeUser(int idUser) {
        Connection conn = null;
        try {
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

            remU.setInt(1, idUser);

            remU.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);

            //Chiudo la connessione
            remU.close();
            remL.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException eR) {
                    Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, eR);
                }
            }
        }
        return false;
    }

    void testConnection() {
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();

        if (conn != null) {
            System.out.println("Connessione eseguita con successo");
        }
    }
}
