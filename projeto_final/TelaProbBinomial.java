package projeto_final;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class TelaProbBinomial extends JFrame{
    public TelaProbBinomial(){
        setTitle("Probabilidade binomial");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField variavelXField = new JTextField();
        variavelXField.setPreferredSize(new Dimension(100, 30));
        painel.add(variavelXField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField mediaField = new JTextField();
        mediaField.setPreferredSize(new Dimension(100, 30));
        painel.add(mediaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField desvioPadraoField = new JTextField();
        desvioPadraoField.setPreferredSize(new Dimension(100, 30));
        painel.add(desvioPadraoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField saidaTextField = new JTextField();
        saidaTextField.setPreferredSize(new Dimension(100, 30));
        painel.add(saidaTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JButton calcularButton = new JButton();
        calcularButton.setText("Calcular");
        calcularButton.addActionListener(e -> {
            Double probabilidade = null;
            Integer repeticoes = null;
            Integer sucessos = null;

            try {
                probabilidade = Double.parseDouble(variavelXField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado em probabilidade");
                return;
            }
            try {
                repeticoes = Integer.parseInt(desvioPadraoField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado em repetições");
                return;
            }
            try {
                sucessos = Integer.parseInt(mediaField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado em sucessos");
                return;
            }

            if (probabilidade != null && repeticoes !=  null && sucessos != null) {
                if (probabilidade < 0 || probabilidade > 1) {
                    saidaTextField.setText("Probabilidade deve estar entre 0 e 1");
                }else if (repeticoes <= 0){
                    saidaTextField.setText("Repetições não podem ser negativas");
                }else if (sucessos < 0){
                    saidaTextField.setText("Sucessos não podem ser negativos");
                } else if (sucessos > repeticoes) {
                    saidaTextField.setText("Sucessos não podem ser maiores que repetições");
                } else if (sucessos > 100 || repeticoes > 100) {
                    saidaTextField.setText("Valores muito grandes detectados entradas repetições, máximo 100");
                } else {
                    saidaTextField.setText("Resultado: " + Probabilidade.calcularProbabilidadeBinomial(probabilidade, repeticoes, sucessos));
                }
            }
        });
        painel.add(calcularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JButton voltarButton = new JButton();
        voltarButton.setText("Voltar");
        voltarButton.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
            dispose();
        });
        painel.add(voltarButton, gbc);

        add(painel);
    }
}