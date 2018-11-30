/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;


/**
 * Pré-compra, escolha de um assento em um determinado vôo.
 * @author João Marcello
 * @version 1.0
 * @since 1.0
 */
public class Reserva {
        // ATRIBUTOS
    private static long currentId = 0;
    private long id;
    private Assento s;
    private Cliente cliente;
    protected Voo voo;
    private boolean foiComprada = false;
    
        // CONSTRUTOR
    Reserva(Assento assento, Voo v, Cliente cliente){
        currentId++;
        id = currentId;
        this.s = assento;
        this.voo = v;
        this.cliente = cliente;
    }
    
    
        // MÉTODOS
    /*  Transforma os dados da reserva em string    */
    /**
     * Converte a Reserva em string
     * @since 1.0
     * @return  String da Reserva
     */
    public String toString(){
        return "ID: " + id + "   Assento:" + s.toString() 
                + (this instanceof ReservaPrimClasse ? "    Prim. Classe" : "    Classe Economica")
                + "     Voo Numero " + voo.getId() + ", " + voo.getDestino() + (foiComprada ? "    COMPRADA" : "");
    }
    
    /**
     * Converte a Reserva em uma String
     * @since 1.0
     * @return  String da Reserva
     */
    public String getFormatedString(){
        return "" + cliente.getId() + ";" + id + ";" + voo.getId() + ";" + s.getNumFila() + s.getLetra() +
                ";" + foiComprada;
    }
    
    /**
     * Checa ID Estático
     * @since 1.0
     * @return ID estático atual 
     */
    public static long getLastAddedId(){ return currentId; }
    
    
    /**
     * Muda ID Estático
     * @since 1.0
     * @param current LongInt  
     */
    public static void setCurrentId(long current){ currentId = current; }
    
    
    /**
     * <p>
     * Compra de uma Reserva, gera uma passagem para \
     * a lista de passagens do Cliente
     * <p>
     * @since 1.0
     * @return 'true' se a passagens foi bem sucedida, senão 'false'
     */
    public boolean comprar(){
        Passagem p;
        
        if(!jaFoiComprada()){  //se reserva ainda nao foi comprada
            this.foiComprada = true;  //comprando a reserva
            p = new Passagem(this); //criando a nova passagem
            
            if(getCliente().addPassagem(p)) //adicionando a passagem na lista de passagem do cliente
                return true;
            else    //se nao conseguiu adicionar a passagem na lista
                cancelarCompra();  //cancelando a compra da reserva
        }
        
        return false;
    }
    
    /**
     * Cancelar compra da Passagem
     * @since 1.0
     */
    public void cancelarCompra() {
        this.foiComprada = false;
    }
    
    /**
     * Checa se a reserva foi paga
     * @since 1.0
     * @return 'true' se a reserva foi comprada, senão 'false'
     */
    public boolean jaFoiComprada(){ return this.foiComprada; }
    
    
    /**
     * O número de ID da reserva
     * @since 1.0
     * @return ID da Reserva 
     */
    public long getId(){return id;}
    
    /**
     * Muda o ID da reserva
     * @since 1.0
     * @param id ID da reserva
     */
    public void setId(long id){ 
        this.id = id; 
    }
    
    /**
     * Checa qual o Assento cuja Reserva foi feita
     * @since 1.0
     * @return Assento reservado 
     */
    public Assento getAssento(){ 
        return s; 
    }
    
    
    /**
     * Muda o assento reservado
     * @since 1.0
     * @param s Assento ao qual será reservado 
     */
    public void setAssento(Assento s){
        this.s = s;
    }
    
    
    /**
     * O autor da Reserva de um Assento
     * @since 1.0
     * @return Cliente que reservou
     */
    public Cliente getCliente(){    return cliente; }
    
    
    /**
     * O vôo associado à Reserva
     * @since 1.0
     * @return vôo
     */
     public Voo getVoo(){    
        return voo; 
    }
    
    /**
     * Muda o vôo
     * @param v Objeto do tipo Vôo
     * @since 1.0
     */
     public void setVoo(Voo v){  
         voo = v;    
     }
    
    
    /**
     * Preco da Reserva de um assento no Vôo
     * @since 1.0
     * @return Preco da Reserva 
     */
    public double getPreco(){   return voo.getPreco();  }
    
    
    /**
     * Muda a Reserva do Assento
     * @since 1.0
     * @param numFila Posição do Assento
     * @param letraAssento Posição do Assento
     */
    public void changeAssento(int numFila, char letraAssento){
        this.s.changeFila(numFila);
        this.s.changeLetraAssento(letraAssento);
    }
    
}
