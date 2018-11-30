/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 * A compra de um Assento, cuja Reserva foi feita.
 * @author João Marcello
 * @version 2.0
 * @since 1.0
 */
public class Passagem {
        // ATRIBUTO
    private Reserva reserva;
    
        // CONSTRUTOR
    Passagem(Reserva r){
        reserva = r;
    }
    
    // MÉTODOS
    /**
     * Reserva
     * @since 1.0
     * @return reserva
     */
    public Reserva getReserva(){ return reserva; }
    
    /**
     * Atribui nova Reserva
     * @param reserva Objeto do tipo Reserva
     * @since 1.0
     */
    public void setReserva(Reserva novaReserva){ this.reserva = novaReserva; }

    /**
     * Converte a Passagem em uma string (@Override)
     * @since 1.0
     * @return String da Reserva, como passagem
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString(){
        return reserva.toString();  
    }
    
    /**
     * Converte a Reserva em uma String (para arquivo)
     * @since 2.0
     * @return String da Reserva, como passagem
     */
    public String getFormatedString(){
        return reserva.getFormatedString();
    }
    
    /** 
     * Imprime uma passagem 
     * @deprecated As passagens são feitas por outro método \
     * {@link programa.ReservaHandler#printCartaoEmbarque(programa.Reserva)}
     * @since 1.0
     * @param p Objeto do tipo Passagem
     */
    public static void printPassagem(Passagem p){
        
    }
}
