
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
public class LibroFactory {
    private static LibroFactory singleton;
    private ArrayList<Libro> listLibri = new ArrayList<Libro>();
    
    private LibroFactory(){
        Libro l1 = new Libro();
        l1.setIsbn("1245");
        l1.setEditore("Editore1");
        l1.setNome("Cages in Animation");
        l1.setAutore("Sara456");
        
        Libro l2 = new Libro();
        l2.setIsbn("1246");
        l2.setEditore("Editore2");
        l2.setNome("Polycubes and Fabrication");
        l2.setAutore("Davide89");
        
        listLibri.add(l1);
        listLibri.add(l2);
    }
    
    public static LibroFactory getInstance(){
        if(singleton==null)
        {
            singleton = new LibroFactory();  
        }
        return singleton;    
    }
    
    public ArrayList<Libro> getAllBooks(){
        return listLibri;
    }
}
