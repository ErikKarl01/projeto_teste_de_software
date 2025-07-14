package projeto_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaIntervaloDeConfiança extends JFrame{
    public TelaIntervaloDeConfiança(){
        setTitle("Tela de calculo de intervalo de confiança de uma amostra");
        setLocationRelativeTo(null);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JTextField mediaAmostal = new JTextField();
        panel.add(mediaAmostal, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JTextField varZ = new JTextField();
        panel.add(varZ, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        JTextField desvioPadrao = new JTextField();
        panel.add(desvioPadrao, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        JTextField tamanhoAmostra = new JTextField();
        panel.add(tamanhoAmostra, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        JTextField saida = new JTextField();


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        JButton calcular = new JButton();
        calcular.addActionListener(e -> {
            Double mediaAmostralDouble = null;
            Double varZDouble = null;
            Double desvioPadraDouble = null;
            Integer tamanhoAmostraInteger = null;
            try {
                mediaAmostralDouble = Double.parseDouble(mediaAmostal.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato não aceito, usar valores de ponto flutuante em Media Amostral");
            }
            try {
                varZDouble = Double.parseDouble(varZ.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato não aceito, usar valores de ponto flutuante em Z");
            }
            try {
                desvioPadraDouble = Double.parseDouble(desvioPadrao.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato não aceito, usar valores de ponto flutuante em Desvio Padrão");
            }
            try {
                tamanhoAmostraInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato não aceito, usar valores inteiros em Tamanho da amostra");
            }

            if (mediaAmostralDouble != null && varZDouble != null && desvioPadraDouble != null && tamanhoAmostraInteger != null) {
                if (tamanhoAmostraInteger <= 1 || desvioPadraDouble <= 0 || varZDouble <= 0) {
                    saida.setText("ERRO: Parametros inválidos...");
                } else{
                    saida.setText("Resultado:" + EstatisticaInferencial.intervaloConfiancaMediaComDesvioPadrao(mediaAmostralDouble, varZDouble, desvioPadraDouble, tamanhoAmostraInteger));
                }
            }
        });
        panel.add(calcular, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        JButton voltar = new JButton();
        voltar.addActionListener(e -> {
            TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
            telaEstInferencial.setVisible(true);
        });
        panel.add(voltar, gbc);
        panel.add(saida, gbc);

        add(panel);
    }
}
