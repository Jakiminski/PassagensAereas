/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;

/**
 * Usuário final do programa.
 * <p>
 * O cliente utiliza o programa, registrando-se,\
 * consultando vôos, reservando e comprando passagens.
 * <p>
 * @author Joao Marcello
 * @version 2.0
 * @since 1.0
 */

public class Cliente {
    // ATRIBUTOS
    private static long currentId = 0;
    //INFO sobre o Cliente
    private long id;  
    private String nome;
    private long telefone, numCartao;
    private ArrayList<Reserva> reservas;
    private ArrayList<Passagem> passagens;
    
    // CONSTRUTORES
    Cliente(String nome, long numCartao, long telefone){
        currentId++; 
        this.id = currentId;
        this.nome = nome;
        this.telefone = telefone;
        this.numCartao = numCartao;
        reservas = new ArrayList<Reserva>();
        passagens = new ArrayList<Passagem>();
    }
    
    
    Cliente(String s){
        ArrayList<String> lista = UtilityMethods.getSeparatedString(s);
        
        if(lista.size() == 4){
            
            try{
                id = Integer.parseInt(lista.get(0));
            }
            catch(NumberFormatException e){
                 id = -1;   
            }
            nome = lista.get(1);
            
            try{
                telefone = Long.parseLong(lista.get(2));
            }
            catch(NumberFormatException e){
                telefone = -1;
            }
            
            try{
                numCartao = Long.parseLong(lista.get(3));
            }
            catch(NumberFormatException e){
                numCartao = -1;
            }
        }
        else{
            id = -1;
            nome = "error";
            telefone = -1;
            numCartao =-1;
        }
        
        reservas = new ArrayList<Reserva>(); 
        passagens = new ArrayList<Passagem>();
    }
    
    // MÉTODOS
    /**
     * Converte o ID e o nome do cliente em String
     * @since 1.0
     * @return Uma string dos dados do Cliente
     */
    public String toString(){
        return "Id Cliente: " + id + "\nNome: " + nome.substring(0,30) ;
    }
    
    /**
     * Converte o ID e o nome do cliente em String, para arquivo
     * @since 2.0
     * @return Uma string com os dados do Cliente (para arquivo)
     */
    public String getStringFormated(){
        return "" + id + ";" + nome + ";" + telefone + ";" + numCartao;
    }
    
    
    /**
     * Adiciona uma reserva à lista do Cliente
     * @since 1.0
     * @param r Um objeto do tipo Reserva
     * @return 'true' se a reserva foi feita, senão 'false'
     */
    public boolean addReserva(Reserva r){
        return reservas.add(r);
    }
    
    
    /**
     * Remove uma reserva à lista do Cliente
     * @since 1.0
     * @param r Um objeto do tipo Reserva
     * @return 'true' se a reserva foi removida, senão 'false'
     */
    public boolean removeReserva(Reserva r){
        return reservas.remove(r); 
    }
    
    /**
     * Adiciona uma passagem à lista do Cliente
     * @since 1.0
     * @param p Um objeto do tipo Passagem
     * @return 'true' se a passagem foi feita, senão 'false'
     */
    public boolean addPassagem(Passagem p){
        return passagens.add(p);
    }
    
    /**
     * Remove uma passagem à lista do Cliente
     * @since 1.0
     * @param p Um objeto do tipo Passagem
     * @return 'true' se a passagem foi removida, senão 'false'
     */
    public boolean removePassagem(Passagem p){
        return passagens.remove(p);
    }
    
    
    /**
     * Procura Reserva(s) feitas por um cliente, a partir de um ID
     * @since 1.0
     * @param id Um ID de um Cliente
     * @return A reserva feita pelo Cliente, senão, 'null'
     */
    public Reserva getReservaPorId(long id){
        for(Reserva r : reservas){  //  percorrendo a lista de reservas
            if(r.getId() == id)
                return r;
        }
        return null;
    }
    
    /**
     * Ultimo ID adicionado no sistema
     * @since 1.0
     * @return ID estático atual
     */
    public static long getLastAddedId(){ return currentId; }
    
    /**
     * Muda o ID estático
     * @param id ID estático
     * @since 1.0
     */
    public static void setCurrentId(long id) { currentId = id; }
    
    /**
     * ID do Cliente
     * @since 1.0
     * @return ID do Cliente
     */
    public long getId(){    return id;  }
    
    
    /**
     * Nome do Cliente
     * @since 1.0
     * @return O atributo nome do Cliente
     */
    public String getNome(){    return nome;      }
    
    
    /**
     * Telefone do Cliente
     * @since 1.0
     * @return O atributo telefone do Cliente
     */
    public long getTelefone(){  return telefone;    }
    
    
    /**
     * Cartão do Cliente
     * @since 1.0
     * @return O atributo numCartao do Cliente
     */
    public long getNumCartao(){     return numCartao;    }
    
    
    /**
     * Checa se o Cliente possui reservas em seu nome
     * @since 1.0
     * @return 'true' se o cliente possui reserva(s), senão 'false'
     */
    public boolean possuiReservas(){
        for(Reserva r : reservas){
            if(!r.jaFoiComprada())
                return true;
        }
        
        return false;
    }
    
    
    /**
     * Mostra as reservas feitas pelo Cliente
     * @since 1.0
     */
    public void showReservas(){
        System.out.println();
        for(Reserva r : reservas){
            System.out.println(r.toString());
        }
        System.out.println();
    }
    
    /**
     * Lista de reservas do Cliente
     * @since 1.0
     * @return ArrayList de Reservas
     */ 
    public ArrayList<Reserva> getListaReservas(){ return reservas; }
    
    /**
     * Lista de Passagens do Cliente
     * @since 1.0
     * @return ArrayList de Passagens
     */
    public ArrayList<Passagem> getListaPassagens(){ return passagens; }
}
