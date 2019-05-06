/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sary
 */
public class Libro {
    private String isbn;
    private String nome;
    private String editore;
    private String autore;
    private float prezzo;

    public Libro(){
        
    }
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the editore
     */
    public String getEditore() {
        return editore;
    }

    /**
     * @param editore the editore to set
     */
    public void setEditore(String editore) {
        this.editore = editore;
    }

    /**
     * @return the autore
     */
    public String getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * @return the prezzo
     */
    public float getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
