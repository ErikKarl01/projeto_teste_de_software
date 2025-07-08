package projeto_final;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaProbCondicional extends JFrame{
    public TelaProbCondicional(){
        setSize(1000, 600);
        setTitle("Tela probabilidade condicional");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField probABField = new JTextField();
        painel.add(probABField, gbc); 

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField probBField = new JTextField();
        painel.add(probBField, gbc); 

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saida = new JTextField();
        painel.add(saida, gbc); 

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton calcular = new JButton("Calcular");
        calcular.setPreferredSize(new Dimension(200, 50));
        calcular.addActionListener(e -> {
            Double probAB = null;
            Double probB = null;

            try {
                probAB = Double.parseDouble(probABField.getText().trim());
            } catch (NumberFormatException ex) {
                saida.setText("ERRO: valor 1 com caracteres");
            }

            try {
                probB = Double.parseDouble(probBField.getText().trim());
            } catch (NumberFormatException ex) {
                saida.setText("ERRO: valor 2 com caracteres");
            }

            if (probAB != null && probB != null) {
                if (probAB > 0 && probB >= 0) {
                    Double resultado = Probabilidade.calcularProbabilidadeCondicional(probAB, probB);
                    saida.setText("Resultado: " + resultado);
                }else{
                    saida.setText("Probabilidade do evento A e B devem ser maiores ou iguais a zero e a probasbilidade de B maior que zero");
                }
            }
        });
        painel.add(calcular, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton voltar = new JButton("Voltar");
        voltar.setPreferredSize(new Dimension(200, 50));
        voltar.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
        });
        painel.add(voltar, gbc); 

        add(painel);
    }
}