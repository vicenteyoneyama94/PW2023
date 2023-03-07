package exercicio5;

import javax.swing.JOptionPane;

public class IMC {
    public static void main(String[] args) {
        String pessoa = JOptionPane.showInputDialog("Sexo:");
        String peso = JOptionPane.showInputDialog("Peso:");
        double pesar = Double.parseDouble(peso);
        String altura = JOptionPane.showInputDialog("Altura:");
        double alt = Double.parseDouble(altura);
        
        CalculoIMC calculo = new CalculoIMC();
        calculo.calculandoIMC(pesar, alt, pessoa);
    }
}
