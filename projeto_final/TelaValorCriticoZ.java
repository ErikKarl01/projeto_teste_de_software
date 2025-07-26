package projeto_final;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;


public class TelaValorCriticoZ extends JFrame{
    public TelaValorCriticoZ(){
        setTitle("Calculo valor crítico Z");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(210, 180, 140));
        GridBagConstraints gbc = new GridBagConstraints();

        //media amostra label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel mediaAmostraLeLabel = new JLabel("<html>Média da amostra: </html>");
        mediaAmostraLeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(mediaAmostraLeLabel, gbc);

        //media amostra text field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField mediaAmostra = new JTextField(15);
        panel.add(mediaAmostra, gbc);

        //media hipotese label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel mediaHipoteseLabel = new JLabel("<html>Média hipotética: </html>");
        mediaHipoteseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(mediaHipoteseLabel, gbc);

        // media hipotese text field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField mediaHipotese = new JTextField(15);
        panel.add(mediaHipotese, gbc);

        //media hipotese label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel desvioLabel = new JLabel("<html>Desvio padrão: </html>");
        desvioLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(desvioLabel, gbc);

        // desvio padrao text field
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField desvioPadrao = new JTextField(15);
        panel.add(desvioPadrao, gbc);

        //tamanho amostra label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel tamanhoAmostraLabel = new JLabel("<html>Tamanho da amostra: </html>");
        tamanhoAmostraLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tamanhoAmostraLabel, gbc);

        // tamanho amostra text field
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField tamanhoAmostra = new JTextField(15);
        panel.add(tamanhoAmostra, gbc);

        // Labels for each text field
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JLabel saida = new JLabel("<html>Insira . e não , para valores de ponto flutualne, o sistema diferencia</html>");
        saida.setPreferredSize(new Dimension(300, 150));
        saida.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(saida, gbc);

        // Button to calculate the Z value
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JButton calcular = new JButton("Calcular");
        calcular.setPreferredSize(new Dimension(100, 50));
        calcular.addActionListener(e -> {
            Double mediaAmostraDouble = null;
            Double mediaHipoteticaDouble = null;
            Double desvioPadrDouble = null;
            Integer tamanhoAmostraInteger = null;

            try {
                mediaAmostraDouble = Double.parseDouble(mediaAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>Valor não numérico detectado em média amostral</html>");
                return;
            }
            try {
                mediaHipoteticaDouble = Double.parseDouble(mediaHipotese.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>Valor não autorizado em media hipotética</html>");
                return;
            }
            try {
                desvioPadrDouble = Double.parseDouble(desvioPadrao.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>Valor não autorizado em desvio padrão</html>");
                return;
            }
            try {
                tamanhoAmostraInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>Valor não autorizado em tamanho da amostra</html>");
                return;
            }

            if (mediaAmostraDouble != null && tamanhoAmostraInteger != null && desvioPadrDouble != null && mediaHipoteticaDouble != null) {
                if (mediaAmostraDouble < -1000000000 || mediaAmostraDouble > 1000000000 || mediaHipoteticaDouble < -1000000000 || mediaHipoteticaDouble > 1000000000) {
                    saida.setText("<html>Valor da média hipotética ou valor da média amostral fora do intervalo permitido (intervalo de -1000000000 a 1000000000)</html>");
                } else if(desvioPadrDouble < 0 || desvioPadrDouble > 1000000000){
                    saida.setText("<html>Desvio padrão não pode ser menor que 0 e menor ou igual a 1000000000</html>");
                } else if(tamanhoAmostraInteger<=0 || tamanhoAmostraInteger > 1000000000){
                    saida.setText("<html>O tamanho da amostra deve ser maior que zero e menor ou igual a 1000000000</html>");
                } else{
                    saida.setText("<html>Resultado: " + EstatisticaInferencial.testeZ(mediaAmostraDouble, mediaHipoteticaDouble, desvioPadrDouble, tamanhoAmostraInteger) + "</html>");
                }
            }
        });
        panel.add(calcular, gbc);

        // Button to go back to the previous screen
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> {
            TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
            telaEstInferencial.setVisible(true);
            dispose();
        });
        voltar.setPreferredSize(new Dimension(100, 50));
        panel.add(voltar, gbc);

        add(panel);
    }
}