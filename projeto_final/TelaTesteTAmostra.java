package projeto_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTesteTAmostra extends JFrame{
    public TelaTesteTAmostra(){
        setTitle("Tela teste T da amostra");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField mediaAmostral = new JTextField();
        panel.add(mediaAmostral, gbc);

        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField mediaHipotetica = new JTextField();
        panel.add(mediaHipotetica, gbc);

        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField desvioPadraoAmostral = new JTextField();
        panel.add(desvioPadraoAmostral, gbc);

        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField tamanhoAmostra = new JTextField();
        panel.add(tamanhoAmostra, gbc);

        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saida = new JTextField();


        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton calcular = new JButton();
        calcular.addActionListener(e -> {
            Double mediaAmostraDouble = null;
            Double mediaHipoteticaDouble = null;
            Double desvioPadraDouble = null;
            Integer tamanhoAmosInteger = null;
            try {
                mediaAmostraDouble = Double.parseDouble(mediaAmostral.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato inválido, somente valores numéricos são aceitos");
            }
            try {
                mediaHipoteticaDouble = Double.parseDouble(mediaHipotetica.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato inválido, somente valores numéricos são aceitos");
            }
            try {
                desvioPadraDouble = Double.parseDouble(desvioPadraoAmostral.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato inválido, somente valores numéricos são aceitos");
            }
            try {
                tamanhoAmosInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException exe) {
                saida.setText("ERRO: formato inválido, somente valores numéricos são aceitos");
            }

            if (mediaAmostraDouble != null && mediaHipoteticaDouble != null && tamanhoAmosInteger != null && desvioPadraDouble != null) {
                if (tamanhoAmosInteger <= 1 || desvioPadraDouble <= 0) {
                    saida.setText("Entradas inválidas");
                } else {
                    saida.setText("Resultado: " + EstatisticaInferencial.testeT(mediaAmostraDouble, mediaHipoteticaDouble, desvioPadraDouble, tamanhoAmosInteger));
                }
            }
        });
        panel.add(calcular, gbc);

        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
