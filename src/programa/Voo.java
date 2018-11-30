/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 * Vôo feito por um avião
 * @author Fábio(1.0) e João Marcello (1.0 e 2.0)
 * @version 2.0
 * @since 1.0
 */
public class Voo {
        // ATRIBUTOS
    private static long currentId = 0;
    private String destino;
    private String origem;
    private long id;
    private Aviao plane;
    private boolean[][] mapaAssentos;
    private int vagasPrimClasse;
    private int vagasClasseEconom;
    private double preco;
    private String horario;
    private String data;
    
    
        // CONSTRUTOR
    Voo(String origem, String destino, Aviao plane, double preco, String data, String horario){
        currentId++;
        this.origem = origem;
        this.destino = destino;
        this.plane = plane;
        this.id = currentId;
        this.preco = preco;
        this.horario = horario;
        this.data = data;
        vagasClasseEconom = plane.getMaxVagasClasseEconom();
        vagasPrimClasse = plane.getMaxVagasPrimClasse();
        
        mapaAssentos = new boolean[plane.getNumFilas()][plane.getNumColunas()];
    }
    
        // MÉTODOS
    /**
     * Converte as informações de vôo em string
     * @since 1.0
     * @return String do ID e destino do vôo
     */
    public String toString(){
        return "" + id + "     " + destino;
    }
    
    
    /**
     * Destino
     * @since 1.0
     * @return destino da viagem
     */
    public String getDestino(){ return destino; }
    
    /**
     * Origem
     * @since 1.0
     * @return ponto de partida da viagem
     */
    public String getOrigem(){return origem;}
    
    
    /**
     * ID do Vôo
     * @since 1.0
     * @return ID do võo
     */
    public long getId(){   return id;     }
    
    
    /**
     * Determina o avião, dado um vôo
     * @since 1.0
     * @return Avião
     */
    public Aviao getAviao(){   return plane;   }
    
    
    /**
     * Mostra o Mapa de Assentos de um Vôo
     * @since 1.0
     * @return 'true' ou 'false' de acordo com a lotação de cada assento
     */
    public boolean[][] getMapAssentos(){   return mapaAssentos;    }
    
    
    /**
     * Determina preço
     * @since 2.0
     * @param preco para uma Passagem do respectivo Vôo
     */
    public void setPreco(double novoPreco){   preco = novoPreco;  } 
    
    
    /**
     * Preço do vôo
     * @since 2.0
     * @return Preço atual do Vôo
     */
    public double getPreco(){   return preco;   }
    
    
   /**
     * Quantidade de vagas na Primeira Classe
     * @since 1.0
     * @return Número de vagas
     */
    public int numVagasPrimClasse(){    return vagasPrimClasse;  }
    
    
    /**
     * Quantidade de vagas na Classe Econômica
     * @since 1.0
     * @return Número de vagas 
     */
    public int numVagasClasseEconom(){  return vagasClasseEconom;   }
    
    
    /**
     * Altera o horário do Vôo
     * @param horario Horário novo de vôo
     * @since 1.0
     */
    public void setHorario(String novoHorario){ horario = novoHorario;  }
    
    
    /**
     * Horário do Vôo
     * @since 1.0
     * @return Horário do Vôo
     */
    public String getHorario(){ return horario; }
    
    
    /**
     * Data do Vôo
     * @since 1.0
     * @return Data do Vôo 
     */
    public String getData(){    return data;    }
    
    
    /**
     * Altera a data do Võo
     * @param data data do Vôo
     * @since 1.0
     */
    public void setData(String novaData){   data = novaData;    }  
    
    
    /**
     * Se a Primeira Classe está Cheia
     * @since 1.0
     * @return 'true' se todas as vagas foram ocupadas, \
     * senão 'false'
     */
    public boolean primClasseEstaCheia(){   return vagasPrimClasse <= 0;    }
    
    
    /**
     * Se a Classe Econômica está Cheia
     * @since 1.0
     * @return 'true' se todas as vagas foram ocupadas, \
     * senão 'false'
     */
    public boolean classeEconomEstaCheia(){ return vagasClasseEconom <= 0;    }
    
    
    /**
     * Se o Vôo está lotado
     * @since 1.0
     * @return 'true' se todas as vagas foram ocupadas, \
     * senão 'false'
     */
    public boolean estaLotado(){    return vagasPrimClasse + vagasClasseEconom <= 0;    }
    
    
    
     /**
     * Incremento de vagas na Primeira Classe
     * @since 1.0
     * @return 'true' senão ultrapassar o máximo de vagas, \
     * senão 'false'
     */
    private boolean addVagaNaPrimClasse(){
        if(vagasPrimClasse + 1 <= plane.getMaxVagasPrimClasse()){
            vagasPrimClasse ++;
            return true;
        }
        return false;
    }
    
    
    /**
     * Decremento de vagas na Primeira Classe
     * @since 1.0
     * @return 'true' senão ultrapassar o mínimo de vagas(ZERO), \
     * senão 'false'
     */
    private boolean subtractVagaPrimClasse(){
        if(vagasPrimClasse - 1 >= 0){
            vagasPrimClasse --;
            return true;
        }
        return false;
    }
    
    
    /**
     * Incremento de vagas na Classe Econômica
     * @since 1.0
     * @return 'true' senão ultrapassar o máximo de vagas, \
     * senão 'false'
     */
    private boolean addVagaClasseEconom(){
        if(vagasClasseEconom + 1 <= plane.getMaxVagasClasseEconom()){
            vagasClasseEconom ++;
            return true;
        }
        return false;
    }
    
    
    /**
     * Decremento de vagas na Classe Econômica
     * @since 1.0
     * @return 'true' senão ultrapassar o máximo de vagas, \
     * senão 'false'
     */
    private boolean subtractVagaClasseEconom(){
        if(vagasClasseEconom - 1 >= 0){
            vagasClasseEconom --;
            return true;
        }
        return false;
    }
    
    
    /**
     * Checa se o assento está ocupado
     * @since 1.0
     * @param s Objeto do tipo Assento
     * @return 'true' se estiver vazia, \
     * senão 'false'
     */
    public boolean assentoEstaOcupado(Assento s){
        if(plane.assentoEhValido(s))
                return mapaAssentos[s.getNumFila() - 1][s.getLetra() - 'A'];
       
        return false;
    }
    
    
    /**
     * Reserva assento durante o Vôo
     * @since 1.0
     * @param s Objeto do tipo Assento
     * @return 'true' se não estiver ocupado, \
     * senão 'false'
     */
    public boolean reservarAssento(Assento s){
        if(!assentoEstaOcupado(s)){
            mapaAssentos[s.getNumFila() - 1][s.getLetra() - 'A' ] = true;
            
            if(plane.assentoEhPrimClasse(s))
                subtractVagaPrimClasse();
            else
                subtractVagaClasseEconom();
            return true;
        }
        return false;
    }
    
    
     /**
     * Cancela Reserva deAssento durant o Vôo
     * @since 1.0
     * @param s Objeto do tipo Assento
     * @return 'true' senão ultrapassar o máximo de vagas, \
     * senão 'false'
     */
    public boolean cancelaReservaAssento(Assento s ){
        if(assentoEstaOcupado(s)){
            mapaAssentos[s.getNumFila() - 1][s.getLetra() - 'A'] = false;
            
            if(plane.assentoEhPrimClasse(s))
                addVagaNaPrimClasse();
            else
                addVagaClasseEconom();
            
            return true;
        }
        return false;
    }
    
    
    /**
     * <p>
     * Exibe quais assentos estão disponíveis ou não \
     * para sua ocupação durante um Vôo
     * <p>
     * @since 1.0
     */
    public void printMapaAssentos(){
        System.out.print("\n    ");
        
        //imprimindo os caracteres A, B, C...
        for(int i = 0; i < plane.getNumColunas(); i++)
            System.out.print(" " + (char)('A' + i) + " " + (i == plane.getNumColunas()/2 - 1 ? "  " : ""));
        
        System.out.println();
        
        
        for(int i = 0; i < mapaAssentos.length; i++){
            
            if(i == plane.getNumFilasPrimClasse())  //deixa uma linha em branco entre a prim. classe e a classe economica
                System.out.println();
            
            System.out.print(i + 1 + (i + 1 < 10 ? " " : "") +  ": ");  //imprimindo o numero da linha
            
            //imprimindo os assentos. Se estiver ocupado imprime 'X'. Senao imprime '-'
            for(int j = 0; j < mapaAssentos[i].length; j++){ 
                
                System.out.print(mapaAssentos[i][j] ? " X " : " - " ); 
                
                if(j == plane.getNumColunas()/2-1)  //deixa um espaco em branco na metade das colunas
                    System.out.print("  ");
            }
            
            //mostrando algumas informacoes adicionais
            if(i == 0)
                System.out.print("    Voo " + id);
            else if(i == 1)
                System.out.print("    Destino: " + destino);
            else if(i == plane.getNumFilas() - 3)
                System.out.print("   Num. vagas Prim. Classe: " + vagasPrimClasse);
            else if(i == plane.getNumFilas() - 2)
                System.out.print("   Num. vagas Classe Econom.: " + vagasClasseEconom);
            else if(i == plane.getNumFilas() - 1)
                System.out.print("   Total Vagas Livres: " + (vagasClasseEconom + vagasPrimClasse));

            System.out.print("\n");
        }
        
        System.out.print("\n");
    }
    
    
    /**
     * Mapa de Assentos
     * @since 1.0
     * @return String com o guia dos Assentos 
     */
    public String getMapaAssentos(){
        String s = "     ";
        
        //imprimindo os caracteres A, B, C...
        for(int i = 0; i < plane.getNumColunas(); i++)
            s = s + (" " + (char)('a' + i) + "" + (i == plane.getNumColunas()/2 - 1 ? "  " : ""));
        
       s = s + "\n";
        
        
        for(int i = 0; i < mapaAssentos.length; i++){
            
            if(i == plane.getNumFilasPrimClasse())  //deixa uma linha em branco entre a prim. classe e a classe economica
                s = s + "\n";
            
            s = s + (i + 1 + (i + 1 < 10 ? " " : "") +  ": ");  //imprimindo o numero da linha
            
            //imprimindo os assentos. Se estiver ocupado imprime 'X'. Senao imprime '-'
            for(int j = 0; j < mapaAssentos[i].length; j++){ 
                
                s = s + (mapaAssentos[i][j] ? " x " : " - " ); 
                
                if(j == plane.getNumColunas()/2-1)  //deixa um espaco em branco na metade das colunas
                    s = s + ("  ");
            }
            
           s = s + ("\n");
        }
        
        s = s + ("\n");
        
        return s;
    }
}
