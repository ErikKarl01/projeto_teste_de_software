package projeto_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaValorCriticoZ extends JFrame{
    public TelaValorCriticoZ(){
        setTitle("Calculo valor crítico Z");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField mediaAmostra = new JTextField();
        panel.add(mediaAmostra, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField mediaHipotese = new JTextField();
        panel.add(mediaHipotese, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField desvioPadrao = new JTextField();
        panel.add(desvioPadrao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saida = new JTextField();
        panel.add(saida, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField tamanhoAmostra = new JTextField();
        panel.add(tamanhoAmostra, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton calcular = new JButton();
        calcular.addActionListener(e -> {
            Double mediaAmostraDouble = null;
            Double mediaHipoteticaDouble = null;
            Double desvioPadrDouble = null;
            Integer tamanhoAmostraInteger = null;

            try {
                mediaAmostraDouble = Double.parseDouble(mediaAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: Valores não numéricos não são aceitos nos parâmetros");
            }
            try {
                mediaHipoteticaDouble = Double.parseDouble(mediaHipotese.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: Valores não numéricos não são aceitos nos parâmetros");
            }
            try {
                desvioPadrDouble = Double.parseDouble(desvioPadrao.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: Valores não numéricos não são aceitos nos parâmetros");
            }
            try {
                tamanhoAmostraInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: Valores não numéricos não são aceitos nos parâmetros");
            }

            if (mediaAmostraDouble != null && tamanhoAmostraInteger != null && desvioPadrDouble != null && mediaHipoteticaDouble != null) {
                if (tamanhoAmostraInteger <= 0 || desvioPadrDouble <= 0) {
                    saida.setText("ERRO: entrada inválida");
                } else{
                    saida.setText("Resultado: " + EstatisticaInferencial.testeZ(mediaAmostraDouble, mediaHipoteticaDouble, desvioPadrDouble, tamanhoAmostraInteger));
                }
            }
        });
        panel.add(calcular, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton voltar = new JButton();
        voltar.addActionListener(e -> {
            TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
            telaEstInferencial.setVisible(true);
        });
        panel.add(voltar, gbc);

        add(panel);
    }
}
