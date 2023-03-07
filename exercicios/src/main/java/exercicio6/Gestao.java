package exercicio6;

import javax.swing.JOptionPane;

public class Gestao {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        
        cliente.getId();
        cliente.getNome();
        cliente.getEnderecos();
    }
}
