package exercicio5;

import javax.swing.JOptionPane;

public class CalculoIMC {

    public void calculandoIMC(double pesar, double alt, String pessoa) {
        double calculadorImc = pesar / (alt * alt);

        if (pessoa.equals("Masculino")) {
            if (calculadorImc <= 19.1) {
                JOptionPane.showMessageDialog(null, "Abaixo do peso");
            } else if (calculadorImc > 19.1 && calculadorImc <= 25.8) {
                JOptionPane.showMessageDialog(null, "Peso normal");
            } else if (calculadorImc > 25.8 && calculadorImc <= 27.3) {
                JOptionPane.showMessageDialog(null, "Acima do peso");
            } else if (calculadorImc > 27.3 && calculadorImc <= 32.3) {
                JOptionPane.showMessageDialog(null, "Acima do peso idela");
            } else {
                JOptionPane.showMessageDialog(null, "Obeso");
            }
            JOptionPane.showMessageDialog(null, "Sexo:\n" + pessoa + "\nIMC:\n" + calculadorImc);
        } else if (pessoa.equals("Feminino")) {
            if (calculadorImc <= 20.7) {
                JOptionPane.showMessageDialog(null, "Abaixo do peso");
            } else if (calculadorImc > 20.7 && calculadorImc <= 26.4) {
                JOptionPane.showMessageDialog(null, "Peso normal");
            } else if (calculadorImc > 26.4 && calculadorImc <= 27.8) {
                JOptionPane.showMessageDialog(null, "Marginalmente Acima do peso");
            } else if (calculadorImc > 27.8 && calculadorImc <= 31.1) {
                JOptionPane.showMessageDialog(null, "Acima do peso idela");
            } else {
                JOptionPane.showMessageDialog(null, "Obeso");
            }
            JOptionPane.showMessageDialog(null, "Sexo:\n" + pessoa + "\nIMC:\n" + calculadorImc);
        }
    }
}
