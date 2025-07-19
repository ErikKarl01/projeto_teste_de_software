package projeto_final;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
        painel.setBackground(new Color(220, 240, 235));
        GridBagConstraints gbc = new GridBagConstraints();

        //Label de média
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel textomediLabel = new JLabel("<html>Insira valor de probabilidade: </html>");
        textomediLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(textomediLabel, gbc);

        //TextField de média
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField variavelXField = new JTextField();
        variavelXField.setPreferredSize(new Dimension(100, 30));
        painel.add(variavelXField, gbc);

        //Label de repetiçoes
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel textoRepeticoesJLabel = new JLabel("<html>Insira valor de repetições: </html>");
        textoRepeticoesJLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(textoRepeticoesJLabel, gbc);

        //TextField de repetições
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField mediaField = new JTextField();
        mediaField.setPreferredSize(new Dimension(100, 30));
        painel.add(mediaField, gbc);

        //Label de sucessos
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 0, 10);
        JLabel textoSucessosJLabel = new JLabel("<html>Insira valor de sucessos: </html>");
        textoSucessosJLabel.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(textoSucessosJLabel, gbc);

        //TextField de sucessos
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JTextField desvioPadraoField = new JTextField();
        desvioPadraoField.setPreferredSize(new Dimension(100, 30));
        painel.add(desvioPadraoField, gbc);

        //Label de saída
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        JLabel saidaTextField = new JLabel();
        saidaTextField.setFont(new Font("Arial", Font.BOLD, 16));
        saidaTextField.setPreferredSize(new Dimension(250, 80));
        painel.add(saidaTextField, gbc);

        //Botão de calcular
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
                saidaTextField.setText("<html> Valor não numérico detectado em probabilidade</html>");
                return;
            }
            try {
                repeticoes = Integer.parseInt(desvioPadraoField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("<html>Valor não numérico detectado em repetições</html>");
                return;
            }
            try {
                sucessos = Integer.parseInt(mediaField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("<html>Valor não numérico detectado em sucessos</html>");
                return;
            }

            if (probabilidade != null && repeticoes !=  null && sucessos != null) {
                if (probabilidade < 0 || probabilidade > 1) {
                    saidaTextField.setText("<html>Probabilidade deve estar entre 0 e 1</html>");
                }else if (repeticoes <= 0){
                    saidaTextField.setText("<html>Repetições não podem ser negativas</html>");
                }else if (sucessos < 0){
                    saidaTextField.setText("<html>Sucessos não podem ser negativos</html>");
                } else if (sucessos > repeticoes) {
                    saidaTextField.setText("<html>Sucessos não podem ser maiores que repetições</html>");
                } else if (sucessos > 100 || repeticoes > 100) {
                    saidaTextField.setText("<html>Valores muito grandes detectados em repetições ou sucessos, máximo 100</html>");
                } else {
                    saidaTextField.setText("<html>Resultado: " + Probabilidade.calcularProbabilidadeBinomial(probabilidade, repeticoes, sucessos) + "</html>");
                }
            }
        });
        painel.add(calcularButton, gbc);

        //Botão de voltar
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