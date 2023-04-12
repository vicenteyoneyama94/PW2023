package com.mycompany.exercicio4;

import javax.swing.JOptionPane;

public class CalculoIR {

    public void calcula(Integer salariocv) {
        if (salariocv <= 900) {
            JOptionPane.showMessageDialog(null, "Isento");
        }
        else if (salariocv > 900 && salariocv <= 1500) {
            JOptionPane.showMessageDialog(null, "Desconto IR 5%:\n" +(5 * salariocv) / 100);
        }
        else if (salariocv > 1500 && salariocv <= 2500) {
            JOptionPane.showMessageDialog(null,"Desconto IR 10%:\n" +(10 * salariocv) / 100);
        } else {
            JOptionPane.showMessageDialog(null, "Desconto IR 20%:\n"+(20 * salariocv) / 100);
        }
        JOptionPane.showMessageDialog(null, "Desconto FGTS:\n"+(11*salariocv)/100);
        JOptionPane.showMessageDialog(null, "Desconto INSS:\n"+(10*salariocv)/100);
    }
}
