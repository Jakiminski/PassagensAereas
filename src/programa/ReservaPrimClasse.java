/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 * Classe-Filha de Reserva
 * @author Joao Marcello
 * @version 1.0
 * @since 1.0
 */
public class ReservaPrimClasse extends Reserva {
    
        // CONSTRUTOR
    ReservaPrimClasse(Assento s, Voo v, Cliente c){
        super(s, v, c); 
    }
    
        // MÉTODOS
    /*  Retorna o preco de uma reserva duplicado    */
    /**
     * Preço de uma reserva ainda mais caro
     * @since 1.0
     * @return Preço de Reserva da Primeira Classe
     */
    @Override
    public double getPreco(){   return voo.getPreco() * 2;  }
    
}
