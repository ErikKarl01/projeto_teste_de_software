package projeto_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class TesteProporcaoSimples extends JFrame{
    public TesteProporcaoSimples(){
        setTitle("Tela teste de proporção simples");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(210, 180, 140));
        GridBagConstraints gbc = new GridBagConstraints();

        // Proporção amostral label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel proporcaoAmostralLabel = new JLabel("<html>Proporção amostral: </html>");
        proporcaoAmostralLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(proporcaoAmostralLabel, gbc);

        // Proporção amostral text field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField proposcaoAmostral = new JTextField();
        painel.add(proposcaoAmostral, gbc);

        // Proposição hipotética label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0,10);
        JLabel proporcaoHipoteticaLabel = new JLabel("<html>Proposição hipotética: </html>");
        proporcaoHipoteticaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(proporcaoHipoteticaLabel, gbc);

        // proposção hipotetica text field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField proporcaoHipotetica = new JTextField();
        painel.add(proporcaoHipotetica, gbc);

        // Tamanho da amostra label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel tamanhoAmostraLabel = new JLabel("<html>Tamanho da amostra: </html>");
        tamanhoAmostraLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(tamanhoAmostraLabel, gbc);

        // tamanho amostra text field
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField tamanhoAmostra = new JTextField();
        painel.add(tamanhoAmostra, gbc);

        // Saída text field
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saidaTextField = new JTextField(15);
        painel.add(saidaTextField, gbc);

        // botão calcular
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JButton calcularButton = new JButton();
        calcularButton.setText("Calcular");
        calcularButton.setPreferredSize(new Dimension(100, 50));
        calcularButton.addActionListener(e -> {
            Double proporcaoAmostraDouble = null;
            Double proposcaoHipoteticaDouble = null;
            Integer tamanhoAmostraInteger = null;

            try {
                proporcaoAmostraDouble = Double.parseDouble(proposcaoAmostral.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                proposcaoHipoteticaDouble = Double.parseDouble(proporcaoHipotetica.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                tamanhoAmostraInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }

            if (proporcaoAmostraDouble != null && proposcaoHipoteticaDouble !=  null && tamanhoAmostraInteger != null) {
                if (proporcaoAmostraDouble < 0 || proporcaoAmostraDouble > 1) {
                    saidaTextField.setText("ERRO: Proporção amostral deve estar entre 0 e 1");
                } else if (proposcaoHipoteticaDouble < 0 || proposcaoHipoteticaDouble > 1) {
                    saidaTextField.setText("ERRO: Proposição hipotética deve estar entre 0 e 1");
                } else if (tamanhoAmostraInteger <= 0 || tamanhoAmostraInteger > 1000000000) {
                    saidaTextField.setText("ERRO: Tamanho da amostra deve ser maior que zero e menor que 1.000.000.000");
                } else {
                    saidaTextField.setText("Resultado: " + EstatisticaInferencial.testeProporcaoSimples(proporcaoAmostraDouble, proposcaoHipoteticaDouble, tamanhoAmostraInteger));
                }
            }
        });
        painel.add(calcularButton, gbc);

        // botão voltar
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 0);
        JButton voltarButton = new JButton();
        voltarButton.setText("Voltar");
        voltarButton.setPreferredSize(new Dimension(100, 50));
        voltarButton.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
        });
        painel.add(voltarButton, gbc);

        add(painel);
    }
}
