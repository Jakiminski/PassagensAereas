/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 * Local reservado ao cliente durante os vôos
 * <p>
 * Assentos que serão reservados pelo cliente,\
 * indicados por uma posição do avião durante o vôo.
 * <p>
 * @author João Marcello
 * @version 2.0
 * @since 1.0
 */

public class Assento {
    //ATRIBUTOS
    private char letraAssento;  
    private int numFila;   
    
    //CONSTRUTORES
    public Assento(int numFila, char letraAssento){
        this.letraAssento = Character.toUpperCase(letraAssento);
        this.numFila = numFila;
    }
    
    public Assento(String s){
        letraAssento = s.toUpperCase().charAt(s.length() - 1); //pegando o ultimo caractere da string e atribuindo a letra do assento
        
        s = s.substring(0, s.length() - 1); //tirando o ultimo caractere da string
        
        try {
            numFila = Integer.parseInt(s); //transformando a string em inteiro
        }
        catch(NumberFormatException exception){ //nao consequiu formar um numero com a string!
            numFila = -1;
        }
    }
    
        // MÉTODOS
    /**
     * Dados do Assento
     * @since 1.0
     * @return Uma string dos dados do Assento
     * @see java.lang.Object#toString()
     */
    public String toString(){
        return "" + numFila + letraAssento;
    }
    
    /**
     * Dados do Assento, formatado para arquivos
     * @since 2.0
     * @return Uma string dos dados do Assento (para arquivo) 
     */
    public String getStringFormated() {
        return "" + numFila + letraAssento;
    }
    
    
    /**
     * Determina a coluna(letra) do Assento
     * @since 1.0
     * @return char que determina o Assento
     */
    public char getLetra(){ return letraAssento; }
    
    
    /**
     * Determina a fila(número) do Assento
     * @since 1.0
     * @return num que determina a fila do Assento
     */
    public int getNumFila(){ return numFila; }
    
    
    /**
     * Muda num que determina a fila do Assento
     * @param n Número da Fila
     * @since 1.0
     */
    public void changeFila(int n){
        numFila = n;
    }
    
    
    /**
     * Muda letra que determina o Assento
     * @param l charactere do assento
     * @since 1.0
     */
    public void changeLetraAssento(char l){
        letraAssento = l;
    }
}
