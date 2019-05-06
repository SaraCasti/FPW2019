
import java.util.ArrayList;

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
        //popolare i nostri utenti
        Utente u1 = new Utente();
        u1.setUsername("Sara456");
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
       return this.usersList;
    }
    
    public boolean login(String usr, String psw){
        for(Utente u : this.usersList)
        {
            String tmpUsername = u.getUsername();
            String tmpPassword = u.getPassword();
            
            if(tmpUsername.equals(usr) && tmpPassword.equals(psw))
            {
                // ho trovato una corrispondenza con un utente
                return true;
            }
        }
        //L'utente con username urs e password psw non esiste
        return false;
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
    
}
