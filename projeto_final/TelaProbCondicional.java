package projeto_final;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class TelaProbCondicional extends JFrame{
    public TelaProbCondicional(){
        setSize(1000, 600);
        setTitle("Tela probabilidade condicional");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(220, 240, 235));
        GridBagConstraints gbc = new GridBagConstraints();

        //Label de probabilidade de a e b
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 10);
        JLabel probABJLabel = new JLabel("Probabilidade de A e B");
        probABJLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(probABJLabel, gbc); 

        //JTextField de probabilidade de a e b
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        JTextField probABField = new JTextField(15);
        painel.add(probABField, gbc);

        //Label de probabilidade de b
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 10);
        JLabel probBJLabel = new JLabel("Probabilidade de B");
        probBJLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(probBJLabel, gbc);

        //JTextField de probabilidade de b
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        JTextField probBField = new JTextField(15);
        painel.add(probBField, gbc); 

        //JLabel de saída
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel saida = new JLabel();
        saida.setPreferredSize(new Dimension(250, 80));
        painel.add(saida, gbc); 

        //Botão de calcular
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        JButton calcular = new JButton("Calcular");
        calcular.setPreferredSize(new Dimension(200, 50));
        calcular.addActionListener(e -> {
            Double probAB = null;
            Double probB = null;

            try {
                probAB = Double.parseDouble(probABField.getText().trim());
            } catch (NumberFormatException ex) {
                saida.setText("<html>Valor não numérico detectado em probabilidade de a e b</html>");
            }

            try {
                probB = Double.parseDouble(probBField.getText().trim());
            } catch (NumberFormatException ex) {
                saida.setText("<html>Valor não numérico detectado em probabilidad de b</html>");
            }

            if (probAB != null && probB != null) {
                if (probAB < 0 || probAB > 1 || probB <= 0 || probB > 1) {
                    saida.setText("<html>O valores de probabilidade devem estar entre 0 e 1 (inclusive) e probabilidade de b não deve ser zero</html>");
                } else if (probAB > probB) {
                    saida.setText("<html>A probabilidade de A interseção B não podem ser maior que a probabilidade de B</html>");
                } else {
                    saida.setText("<html>Resultado: " + Probabilidade.calcularProbabilidadeCondicional(probAB, probB) + "</html>");
                }
            }
        });
        painel.add(calcular, gbc);

        //Botão de voltar
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        JButton voltar = new JButton("Voltar");
        voltar.setPreferredSize(new Dimension(200, 50));
        voltar.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
            this.dispose(); 
        });
        painel.add(voltar, gbc); 

        add(painel);
    }
}
