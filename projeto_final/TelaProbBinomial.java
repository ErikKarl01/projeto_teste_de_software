package projeto_final;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class TelaProbBinomial extends JFrame{
    public TelaProbBinomial(){
        setTitle("Probabilidade binomial");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField variavelXField = new JTextField();
        painel.add(variavelXField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField mediaField = new JTextField();
        painel.add(mediaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField desvioPadraoField = new JTextField();
        painel.add(desvioPadraoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saidaTextField = new JTextField();
        painel.add(saidaTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton calcularButton = new JButton();
        calcularButton.addActionListener(e -> {
            Double varX = null;
            Double desvioPadrao = null;
            Double media = null;

            try {
                varX = Double.parseDouble(variavelXField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                desvioPadrao = Double.parseDouble(desvioPadraoField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                media = Double.parseDouble(mediaField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }

            if (varX != null && media !=  null && desvioPadrao != null) {
                if (desvioPadrao >= 0) {
                    double resultado = Probabilidade.calcularProbabilidadeBinomial(varX, desvioPadrao, media);
                    saidaTextField.setText("Resultado: " + resultado);
                }else{
                    saidaTextField.setText("ERRO: Desvio padrão deve ser maior que zero.");
                }
            }
        });
        painel.add(calcularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton voltarButton = new JButton();
        voltarButton.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
        });
        painel.add(voltarButton, gbc);

        add(painel);
    }
}