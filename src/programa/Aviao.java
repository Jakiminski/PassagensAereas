/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;

/**
 * À serviço da Companhia Aérea.
 * <p>
 * O Avião possui uma lista de Vôos,aos quais\
 * os Clientes reservam um assento em um respectivo vôo.
 * <p>
 * @author João Marcello
 * @version 1.0
 * @since 1.0
 * 
 */
public class Aviao {
    //ATRIBUTOS
    private final int NUM_FILAS = 20;
    private final int NUM_COLUNAS = 6;
    private final int NUM_FILAS_PRIM_CLASSE = 5;
    private final int MAX_VAGAS_PRIM_CLASSE = NUM_FILAS_PRIM_CLASSE * NUM_COLUNAS;
    private final int MAX_VAGAS_ECONOM = NUM_FILAS * NUM_COLUNAS - MAX_VAGAS_PRIM_CLASSE;
    private ArrayList<Voo> voos;
    
    
    //CONSTRUTOR
    Aviao(){
        voos = new ArrayList<Voo>();
    }
    
    // MÉTODOS
    /**
     * Procura um vôo na lista em que o cliente marcou
     * @since 1.0
     * @param id O Id do cliente
     * @return Os vôos com o ID do Cliente, senão 'null'
     */
    public Voo getVooPorId(long id){
        for(Voo v : voos)
            if(v.getId() == id)
                return v;
        return null;
    }
    
    
    /**
     * Procura um vôo na lista apartir do index da lista
     * @since 1.0
     * @param i Uma posição indexada na lista de Voos
     * @return Os vôos com o ID do Cliente, senão 'null'
     */
    public Voo getVooPorIndice(int i){
        return voos.get(i);
    }
    
    
    /**
     * Procura todos os vôos na lista
     * @since 1.0
     * @return Os vôos da ArrayList
     */
    public ArrayList<Voo> getListaVoos(){   return voos;    }
    
    
    /**
     * Adiciona um vôo à lista de vôos do avião
     * @since 1.0
     * @param origem String do ponto de partida do vôo
     * @param destino String do ponto de chegada do vôo
     * @param preco Preço do vôo
     * @param data Data de partida do vôo
     * @param horario Horário da partida do vôo
     * @return 'true' se o vôo foi adicionado ao Avião, senão 'false'
     */
    public boolean addVoo(String origem, String destino, double preco, String data, String horario){
        Voo v = new Voo(origem, destino, this, preco, data, horario); //criando o novo voo
        return voos.add(v);     //adicionando na lista de voos
    }

    
    
    /**
     * Quantidade de filas do avião
     * @since 1.0
     * @return Número de filas
     */    
    public int getNumFilas(){ return NUM_FILAS; }
    
    
    /**
     * Quantidade de filas da Primeira Classe do avião
     * @since 1.0
     * @return Número de filas da 1a Classe
     */
    public int getNumFilasPrimClasse(){ return NUM_FILAS_PRIM_CLASSE; }

    
    /**
     * Quantidade de colunas do avião
     * @since 1.0
     * @return Número de colunas
     */
    public int getNumColunas(){ return NUM_COLUNAS; }
    

    /**
     * Número total de vagas da Primeira Classe
     * @since 1.0
     * @return Número de Vagas da 1a Classe
     */
    public int getMaxVagasPrimClasse(){ return MAX_VAGAS_PRIM_CLASSE; }
    
    
    /**
     * Número total de vagas da Classe Econômica
     * @since 1.0
     * @return Número de Vagas da Classe Econômica
     */
    public int getMaxVagasClasseEconom(){ return MAX_VAGAS_ECONOM; }
    
    
    /**
     * Checa se o Assento está validado
     * @since 1.0
     * @param s Um objeto da classe Assento
     * @return 'true' se for válido, senão 'false'
     */
    public boolean assentoEhValido(Assento s){
        return s.getNumFila() - 1 < NUM_FILAS && s.getNumFila() - 1 >= 0
                && s.getLetra() >= 'A' && s.getLetra() <= 'A' + NUM_COLUNAS - 1;
    }
    
    
    /**
     * Checa se o assento é da Primeira Classe
     * @since 1.0
     * @param s Um objeto da classe Assento
     * @return true, se for da Primeira Classe
     */
    public boolean assentoEhPrimClasse(Assento s){
        return s.getNumFila() - 1 < NUM_FILAS_PRIM_CLASSE && s.getNumFila() - 1 >= 0 
                && s.getLetra() >= 'A' && s.getLetra() <= 'A' + NUM_COLUNAS - 1;
    }
    
    
}
