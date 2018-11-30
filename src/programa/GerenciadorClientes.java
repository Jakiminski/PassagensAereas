/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Gerencia a Lista de Clientes.
 * <p>
 * A partir da lista de Clientes, dos cadastros,\
 * das reservas, e da leitura dos arquivos de database;\
 * Tem-se todas as informações úteis ao usuário.
 * <p>
 * @author João Marcello(1.0), Jonas Jakiminski(2.0)
 * @version 2.0
 * @since 1.0
 */
public class GerenciadorClientes {
        // ATRIBUTOS
    private ArrayList<Cliente> clientes;
    private final String clienteFileName = "clientes.txt";
    private final String reservaFileName = "reservas.txt";
    private Aviao aviao;
    
        // CONSTRUTOR
    public GerenciadorClientes(Aviao aviao){
        this.aviao = aviao;
        clientes = new ArrayList<Cliente>();    //inicializando a lista de clientes
        this.loadClienteData();  //carregando os dados dos clientes a partir de um arquivo de texto
        this.loadReservaClienteData(aviao);  //carregando as reservas dos clientes a partir de um arquivo de texto
    }
    
    //MÉTODOS
    /**
     * Determina o avião
     * @since 1.0
     * @return aviao O avião
     */
    public Aviao getAviao(){return aviao;}
    
    /**
     * Adiciona um cliente à Lista
     * @since 1.0
     * @param nome String com o nome do Cliente/usuário
     * @param numCartao LongInt com o cartão de pagamento
     * @param telefone LongInt com o número de telefone
     * @return Cliente cadastrado à lista, senão 'null'
     */
    public Cliente cadastrar(String nome, long numCartao, long telefone){
        Cliente c = new Cliente(nome,numCartao, telefone);  //criando o novo cliente
        
        if(clientes.add(c)) //adiciona o cliente na lista
            return c;
        return null;
    }
    
    
    /**
     * Se o Cliente foi cadastrado 
     * @since 1.0
     * @param c Cliente
     * @return 'true' se ele está na lista, senão 'false'
     */
    public boolean cadastrar(Cliente c){
        return clientes.add(c);
    }
    
    
    /**
     * Procura Cliente com o ID especificado
     * @since 1.0
     * @param id LongInt com o ID
     * @return Cliente, senão 'null' 
     */
    public Cliente getClientePorId(long id){
        for(Cliente c : clientes)   //percorrendo a lista de clientes
            if(c.getId() == id)
                return c;
        
        return null;
    }
    
    /**
     * Lista de Clientes
     * @since 1.0
     * @return Lista de Clientes
     */
    public ArrayList<Cliente> getListaClientes() {return clientes; }
    
    
    /**
     * Lê e carrega o database de Clientes a partir de um arquivo
     * @since 2.0
     */
    public  void loadClienteData(){
        Scanner input;
        Cliente c;
        
        try {
            input = new Scanner(Paths.get(clienteFileName));  //abrindo o arquivo para leitura
        } catch (IOException ex) {  //se nao conseguiu abrir o arquivo
            return; 
        }
        
        long currentId = 0;
        try{
            currentId = Long.parseLong(input.nextLine());  //pegando o id do ultimo cliente adicionado(primeira linha do arquivo) 
        }
        //caso nao conseguiu converter pra long ou arquivo estiver vazio...
        catch(NumberFormatException | NoSuchElementException e){  
            currentId = 0;
        }
        
        Cliente.setCurrentId(currentId);  //mudando o currentId da classe Cliente
        
        while(input.hasNext()){  //enquanto houver dados no arquivo
            c = new Cliente(input.nextLine()); //criando o novo cliente a partir de uma string
            clientes.add(c);  //adicionando o novo cliente na lista de clientes
        }
        
        if(input != null)
            input.close(); //fechando o arquivo
        
    }
    
    
    /**
     * Grava os dados dos clientes no Sistema de arquivos
     * @since 2.0
     * @throws FileNotFoundException se não encontrou o arquivo
     * @throws FormatterClosedException Se não escreveu no arquivo
     * @throws SecurityException Se não gravou no arquivo
     */
    public void saveClienteData() throws FormatterClosedException, SecurityException, FileNotFoundException{
        
        try(Formatter output = new Formatter(clienteFileName)){ //abrindo o arquivo para gravacao (pode gerar SecurityException)
            
            //colocando o id do ultimo cliente adicionado no arquivo
            output.format("" + Cliente.getLastAddedId() + "\n"); //pode gerar FormatterClosedException
            
            for(Cliente c : clientes){  //percorrendo a lista de clientes
                try{
                    output.format(c.getStringFormated() + "\n"); //transformando o cliente em string e 
                                                            //tenta adicionar no arquivo (pode gerar FormatterClosedException)
                }
                catch(FormatterClosedException e){  //se nao conseguiu escrever no arquivo...
                    throw e;
                }
            }
            
           if(output != null)  //se conseguiu abrir arquivo...
               output.close();  //fecha o arquivo
                
        }
        catch(SecurityException e ){  //nao pode gravar no arquivo
            throw e;
        }
        catch(FileNotFoundException e){  //nao conseguiu abrir o arquivo
           throw e;
        }
        catch(FormatterClosedException e){
            throw e;
        }
    }
    
    /**
     * Grava os dados das Reservas de um Cliente no Sistema de Arquivos
     * @since 2.0
     * @throws FileNotFoundException se não encontrou o arquivo
     * @throws FormatterClosedException Se não escreveu no arquivo
     * @throws SecurityException Se não gravou no arquivo
     */
    public void saveReservaClienteData() throws SecurityException, FileNotFoundException, FormatterClosedException {
        try{
            //pode gerar SecurityException e FileNotFoundException
            Formatter output = new Formatter(reservaFileName);
            
            //adicionando o id do ultimo cliente cadastrado no arquivo
            output.format("" + Reserva.getLastAddedId() + "\n"); //pode gerar FormatterClosedException
            
            for(Cliente c : clientes){  //percorrendo a lista de clientes
                for(Reserva r : c.getListaReservas()){  //percorrendo a lista de reservas do cliente
                    //colocando a reserva formatada no arquivo de texto
                    output.format(r.getFormatedString() + "\n"); //pode gerar FormatterClosedException
                }
            }
            
            if(output != null)
                output.close(); //fechando o arquivo
        }
        catch(SecurityException e){ //acesso negado ao abrir o arquivo
            throw e;
        }
        catch(FileNotFoundException e){ //nao encontrou o arquivo
            throw e;
        }
        catch(FormatterClosedException e){ //nao conseguiu inserir um dado no arquivo
            throw e;
        }
    }
    
    /**
     * Lê e carrega database das Reservas a partir de um arquivo
     * @since 2.0
     * @param aviao O Avião cujas reservas serão importadas
     */
    public void loadReservaClienteData(Aviao aviao){
        Scanner input;
        Reserva r;
        Cliente c;
        ReservaHandler rh = new ReservaHandler();
        
        try {
            //abrindo o arquivo para leitura
            input = new Scanner(Paths.get(reservaFileName)); //pode gerar IOException
            
            long currentId = 0;
            
            try{
                currentId = Long.parseLong(input.nextLine());  //parseLong: pode gerar NumberFormatException 
                                                               //input.nextLine: pode gerar NoSuchElementException
            }
            catch(NumberFormatException | NoSuchElementException e){ //tratando as excecoes
                currentId = 0;
            }
            
            Reserva.setCurrentId(currentId);
            
            while(input.hasNext()){  //enquanto houver dados...
                r = rh.reservarByString(input.nextLine(), aviao, this); //faz a reserva no voo correspondente
            }
            
            if(input != null)  
                input.close(); //fechando arquivo
            
        } catch (IOException ex) {
            return;
        }
    }
    
}
