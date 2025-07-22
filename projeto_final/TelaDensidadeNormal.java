package projeto_final;
import java.awt.*;
import javax.swing.*;

public class TelaDensidadeNormal extends JFrame {
    private static JTextField[] textFields;
    private static JLabel saidaText;
    
    public TelaDensidadeNormal() {
        setTitle("Cálculo de Densidade Normal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(220, 240, 235));
        GridBagConstraints gbc = new GridBagConstraints();
        
        textFields = new JTextField[]{
            new JTextField(15), //TextField da média
            new JTextField(15), //TextField do desvio padrão
            new JTextField(15), //TextField do valor x
        };

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 10);
        JLabel labelMedia = new JLabel("<html>Média: </html>");
        labelMedia.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        panel.add(labelMedia, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[0].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[0], gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 0, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel labelDesvioPadrao = new JLabel("<html>Desvio Padrão: </html>");
        labelDesvioPadrao.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        panel.add(labelDesvioPadrao, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        textFields[1].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[1], gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 0, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel labelX = new JLabel("<html>Valor de X: </html>");
        labelX.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        panel.add(labelX, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        textFields[2].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[2], gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        saidaText = new JLabel();
        saidaText.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        saidaText.setPreferredSize(new Dimension(250, 80));
        panel.add(saidaText, gbc);

        JButton calcularButton = new JButton("Calcular");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        calcularButton.setPreferredSize(new Dimension(100, 30));
        panel.add(calcularButton, gbc);

        calcularButton.addActionListener(e -> {
           

            //Verifica se os campos estão preenchidos corretamente
            if (!validateFields()) {
                return;
            }
            //Se os campos estiverem corretos, realiza o cálculo
            double x = Double.parseDouble(textFields[2].getText().trim());
            double desvioPadrao = Double.parseDouble(textFields[1].getText().trim());
            double media = Double.parseDouble(textFields[0].getText().trim());

            double resultado = Probabilidade.calcularDensidadeNormal(x, desvioPadrao, media);
            saidaText.setText("<html>Resultado: " + String.format("%.4f", resultado) + "</html>");
            saidaText.setForeground(Color.BLACK);
            
        });
        
        JButton voltarButton = new JButton("Voltar");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        voltarButton.setPreferredSize(new Dimension(100, 30));
        panel.add(voltarButton, gbc);

        voltarButton.addActionListener(e -> {
            TelaDistNormal telaDistNormal = new TelaDistNormal();
            telaDistNormal.setVisible(true);
            this.dispose();
        });

        add(panel);
    }

    private static boolean validateFields() {
        String[] campos = {
            textFields[0].getText().trim(),
            textFields[1].getText().trim(),
            textFields[2].getText().trim()
        };

        for (int i = 0; i < campos.length; i++) {
            if (campos[i].isEmpty()) {
                saidaText.setText("<html>Por favor, preencha todos os campos.</html>");
                saidaText.setForeground(Color.RED);
                return false;
            }
            try {
                double valor = Double.parseDouble(campos[i]);

                if(i == 1 && valor <= 0) {
                    saidaText.setText("<html>Erro: Desvio padrão deve ser positivo.</html>");
                    saidaText.setForeground(Color.RED);
                    return false;
                }
            } catch (NumberFormatException e) {
                if(campos[i].contains(",")) {
                    saidaText.setText("<html>Erro: Use ponto (.) como separador decimal.</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }

                if(campos[i].matches(".*\\s+.*")) {
                    saidaText.setText("<html>Erro: Campo não deve conter espaços.</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }

                if(!campos[i].matches("-?\\d+(\\.,\\d+)?")) {
                    saidaText.setText("<html>Erro: Campo " + (i + 1) + " deve ser numérico.</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }

                

            }

        }
        return true;
    }

} 