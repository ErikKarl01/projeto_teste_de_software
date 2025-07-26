package projeto_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaTesteTAmostra extends JFrame{
    public TelaTesteTAmostra(){
        setTitle("Tela teste T da amostra");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(210, 180, 140));
        GridBagConstraints gbc = new GridBagConstraints();

        // media amostral label
        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JLabel mediaAmostraLabel = new JLabel("<html>Média amostral: </html>");
        mediaAmostraLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 16));
        mediaAmostraLabel.setPreferredSize(new Dimension(200, 30));
        panel.add(mediaAmostraLabel, gbc);

        // media amostral text field
        gbc.gridx = 1;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField mediaAmostral = new JTextField(15);
        panel.add(mediaAmostral, gbc);

        // media amostral label
        gbc.gridx = 0;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JLabel mediaHipoteticaLabel = new JLabel("<html>Média hipotética: </html>");
        mediaHipoteticaLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 16));
        mediaHipoteticaLabel.setPreferredSize(new Dimension(200, 30));
        panel.add(mediaHipoteticaLabel, gbc);

        // media hipotetica text field
        gbc.gridx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField mediaHipotetica = new JTextField(15);
        panel.add(mediaHipotetica, gbc);

        // media amostral label
        gbc.gridx = 0;
        gbc.ipady = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JLabel desvioPadraoLabel = new JLabel("<html>Desvio padrão amostral: </html>");
        desvioPadraoLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 16));
        desvioPadraoLabel.setPreferredSize(new Dimension(200, 30));
        panel.add(desvioPadraoLabel, gbc);

        // desvio padrão amostral text field
        gbc.gridx = 1;
        gbc.ipady = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField desvioPadraoAmostral = new JTextField(15);
        panel.add(desvioPadraoAmostral, gbc);

        // tamanho da amostra label
        gbc.gridx = 0;
        gbc.ipady = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JLabel tamanhoAmostraLabel = new JLabel("<html>Tamanho da amostra: </html>");
        tamanhoAmostraLabel.setPreferredSize(new Dimension(200, 30));
        tamanhoAmostraLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 16));
        panel.add(tamanhoAmostraLabel, gbc);

        // tamanho da amostra text field
        gbc.gridx = 1;
        gbc.ipady = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JTextField tamanhoAmostra = new JTextField(15);
        panel.add(tamanhoAmostra, gbc);

        // saida text field
        gbc.gridx = 0;
        gbc.ipady = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JLabel saida = new JLabel("<html>Insira . e não , para valores de ponto flutualne, o sistema diferencia</html>");
        saida.setPreferredSize(new Dimension(300, 150));
        saida.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(saida, gbc);

        // calcular button
        gbc.gridx = 0;
        gbc.ipady = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JButton calcular = new JButton("Calcular");
        calcular.addActionListener(e -> {
            Double mediaAmostraDouble = null;
            Double mediaHipoteticaDouble = null;
            Double desvioPadraDouble = null;
            Integer tamanhoAmosInteger = null;
            try {
                mediaAmostraDouble = Double.parseDouble(mediaAmostral.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>ERRO: Valor não numérico detectado em média amostral</html>");
                return;
            }
            try {
                mediaHipoteticaDouble = Double.parseDouble(mediaHipotetica.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>ERRO: Valor não numérico detectado em média hipotética</html>");
                return;
            }
            try {
                desvioPadraDouble = Double.parseDouble(desvioPadraoAmostral.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>ERRO: Valor não numérico detectado em desvio padrão amostral</html>");
                return;
            }
            try {
                tamanhoAmosInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("<html>ERRO: Valor não numérico detectado em tamanho da amostra</html>");
                return;
            }

            if (mediaAmostraDouble != null && mediaHipoteticaDouble != null && tamanhoAmosInteger != null && desvioPadraDouble != null) {
                if (mediaAmostraDouble < -1000000000 || mediaAmostraDouble > 1000000000 || mediaHipoteticaDouble < -1000000000 || mediaHipoteticaDouble > 1000000000) {
                    saida.setText("<html>ERRO: valores fora do intervalo permitido, media amostral e media hipotética devem estar no intervalo de -1000000000 a 1000000000</html>");
                } else if (tamanhoAmosInteger <= 1 || desvioPadraDouble <= 0) {
                    saida.setText("<html>ERRO: tamanho da amostra deve ser maior que 1 e desvio padrão deve ser positivo</html>");
                } else if(tamanhoAmosInteger > 1000000000 || desvioPadraDouble > 1000000000){
                    saida.setText("<html>ERRO: tamanho da amostra e desvio padrão devem ser menores ou iguais a 1000000000</html>");
                }else {
                    double resultado = EstatisticaInferencial.testeT(mediaAmostraDouble, mediaHipoteticaDouble, desvioPadraDouble, tamanhoAmosInteger);
                    saida.setText("<html>Resultado: " + resultado + "</html>");
                }
            }
        });
        panel.add(calcular, gbc);

        // voltar button
        gbc.gridx = 0;
        gbc.ipady = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> {
            TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
            telaEstInferencial.setVisible(true);
            dispose();
        });
        panel.add(voltar, gbc);

        add(panel);
    }
}
