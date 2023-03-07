package com.mycompany.exercicio4;

import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Exercicios {

    public static void main(String[] args) {
        String salario = JOptionPane.showInputDialog("Digite o salario:");
        int salariocv = Integer.parseInt(salario);
        
        CalculoIR calcula = new CalculoIR();
        calcula.calcula(salariocv);
    }
}
