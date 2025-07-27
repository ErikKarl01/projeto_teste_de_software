package projeto_final;
import java.awt.*;
import javax.swing.*;


public class TelaIntervaloDeConfianca extends JFrame {
    private static JTextField[] textFields;
    private static JLabel saidaText;

    public TelaIntervaloDeConfianca() {
        setTitle("Cálculo de Intervalo de Confiança");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(210, 180, 140));
        GridBagConstraints gbc = new GridBagConstraints();

        textFields = new JTextField[]{
            new JTextField(15), //TextField da média amostral
            new JTextField(15), //TextField do valor de z
            new JTextField(15), //TextField do desvio padrão
            new JTextField(15), //TextField do tamanho da amostra
        };

        JButton[] buttons = {
            new JButton("Calcular Intervalo com z"),
            new JButton("Calcular Intervalo com t"),
            new JButton("Voltar")
        };

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 10);
        JLabel textoMed = new JLabel("<html>Insira o valor da média: </html>"); //JLabel de média
        textoMed.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoMed, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[0].setPreferredSize(new Dimension(100, 30)); 
        panel.add(textFields[0], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 10);
        JLabel textoZ = new JLabel("<html>Insira o valor de z: </html>"); //JLabel do valor de z
        textoZ.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoZ, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[1].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(10, 0, 0, 10);
        JLabel textoDP = new JLabel("<html>Insira o valor do desvio padrão: </html>"); //JLabel do desvio padrão
        textoDP.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoDP, gbc);
        gbc.gridx = 1;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[2].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel textoTamanho = new JLabel("<html>Insira o tamanho da amostra: </html>"); //JLabel do tamanho da amostra
        textoTamanho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoTamanho, gbc);
        gbc.gridx = 1;
        textFields[3].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[3], gbc);

        //JLabel para exibição de mensagens de erro e resultados
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        saidaText = new JLabel();
        saidaText.setPreferredSize(new Dimension(300, 80));
        saidaText.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(saidaText, gbc);

        for (int i = 0; i < buttons.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = 5 + i; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 0, 0, 0); // Espaçamento entre os botões
            buttons[i].setPreferredSize(new Dimension(100, 30));
            panel.add(buttons[i], gbc);
            String buttonText = buttons[i].getText();
            buttons[i].addActionListener(e -> {
                if (buttonText.equals("Calcular Intervalo com z")) {
                    
                    if (!validateFields()) {
                        return;
                    }
                    

                    double media = Double.parseDouble(textFields[0].getText().trim());
                    double z = Double.parseDouble(textFields[1].getText().trim());
                    double dp = Double.parseDouble(textFields[2].getText().trim());
                    int tamanho =  Integer.parseInt(textFields[3].getText().trim());

                    
                    double[] intervalo = EstatisticaInferencial.intervaloConfiancaMediaComDesvioPadrao(media, z, dp, tamanho);
                    String inter ="[" + String.format("%.2f", intervalo[0]) + "; " + String.format("%.2f", intervalo[1]) + "]";
                    saidaText.setText("Intervalo de confiança: " + inter);
                    saidaText.setForeground(Color.BLACK);

                }  if (buttonText.equals("Voltar")) {
                    TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
                    telaEstInferencial.setVisible(true);
                    dispose();
                
                }  if (buttonText.equals("Calcular Intervalo com t")) {
                    
                    if (!validateFields()) {
                        return;
                    }
                    
                    double media = Double.parseDouble(textFields[0].getText().trim());
                    double t = Double.parseDouble(textFields[1].getText().trim());
                    double dp = Double.parseDouble(textFields[2].getText().trim());
                    int tamanho = Integer.parseInt(textFields[3].getText().trim());

                    if (tamanho <= 1) {
                        saidaText.setText("<html>ERRO: Tamanho da amostra deve ser maior que 1</html>");
                        saidaText.setForeground(Color.BLACK);
                        return;
                    }

                    
                    double[] intervalo = EstatisticaInferencial.intervaloConfiancaMediaSemDesvioPadrao(media, t, dp, tamanho);
                    String inter ="[" +String.format("%.2f", intervalo[0]) + "; " + String.format("%.2f", intervalo[1]) + "]";
                    saidaText.setText("Intervalo de confiança: " + inter);
                    saidaText.setForeground(Color.BLACK);
                    
                }
            });

            
        }
    
        add(panel);
    }

       private static boolean validateFields() {
        String[] campos = {
            textFields[0].getText().trim(),
            textFields[1].getText().trim(),
            textFields[2].getText().trim(),
            textFields[3].getText().trim()
        };

       for(int i = 0; i < campos.length; i++) {
            if (campos[i].isEmpty()) {
                saidaText.setText("<html>ERRO: Campo vazio detectado</html>");
                saidaText.setForeground(Color.BLACK);
                return false;
            }
            try {
                double valor = Double.parseDouble(campos[i]);
                // média (índice 0) pode ser qualquer número
                if (i != 0 && valor <= 0) {
                    saidaText.setText("<html>ERRO: Valor deve ser positivo e maior do que 0 (exceto média)</html>");
                    saidaText.setForeground(Color.BLACK);
                    return false;
                }

                // tamanho da amostra deve ser inteiro
                if (i == 3 && valor % 1 != 0) {
                    saidaText.setText("<html>ERRO: Tamanho da amostra deve ser um número inteiro</html>");
                    saidaText.setForeground(Color.BLACK);
                    textFields[3].setText("");
                    return false;
                }

            } catch (Exception e) {
                if(campos[i].contains(",")) {
                    saidaText.setText("<html>ERRO: Digite os números separados por (.)</html>");
                    saidaText.setForeground(Color.BLACK);
                    textFields[i].setText("");
                    return false;
                }

                if(campos[i].matches(".*\\s+.*")) {
                    saidaText.setText("<html>ERRO: espaços em branco não são permitidos</html>");
                    saidaText.setForeground(Color.BLACK);
                    textFields[i].setText("");
                    return false;
                }
                
                if(!campos[i].matches("-?\\d+(\\.\\d+)?")) {
                    saidaText.setText("<html>ERRO: letras, símbolos ou operações são inválidos</html>");
                    saidaText.setForeground(Color.BLACK);
                    textFields[i].setText("");
                    return false;
                }

                
            }
        }

        return true;

        
    }
}