package projeto_final;
import java.awt.*;
import javax.swing.*;

public class TelaPNIntervalo extends JFrame {
   private static JLabel saidaText;
   private static JTextField[] textFields;
   public TelaPNIntervalo(){
    setTitle("Probabilidade Normal entre dois pontos");
    setSize(1000,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.setBackground(new Color(220, 240, 235));
    GridBagConstraints gbc = new GridBagConstraints();

    textFields = new JTextField[]{
            new JTextField(15), //TextField da média
            new JTextField(15), //TextField do desvio padrão
            new JTextField(15), //TextField do valor a
            new JTextField(15), //TextField do valor b
        };
        JButton[] buttons = {
            new JButton("Calcular"),
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
        JLabel textoDP = new JLabel("<html>Insira o valor do desvio padrão: </html>"); //JLabel do desvio padrão
        textoDP.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoDP, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[1].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(10, 0, 0, 10);
        JLabel textoA = new JLabel("<html>Insira o menor valor do intervalo: </html>"); //JLabel de a
        textoA.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoA, gbc);
        gbc.gridx = 1;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[2].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 10);
        JLabel textoB = new JLabel("<html>Insira o maior valor do intervalo: </html>"); //JLabel do valor b
        textoB.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(textoB, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);
        textFields[3].setPreferredSize(new Dimension(100, 30));
        panel.add(textFields[3], gbc);


        //JLabel para exibição de mensagens de erro e resultados
        gbc.gridx = 0;
        gbc.gridy = 4;
        saidaText = new JLabel();
        saidaText.setPreferredSize(new Dimension(250, 80));
        saidaText.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(saidaText, gbc);

        for (int i = 0; i < buttons.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = 6 + i; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 0, 0, 0); // Espaçamento entre os botões
            buttons[i].setPreferredSize(new Dimension(100, 30));
            panel.add(buttons[i], gbc);
            String buttonText = buttons[i].getText();
            buttons[i].addActionListener(e -> {
                if (buttonText.equals("Calcular")) {
                    
                    if (!validateFields()) {
                        return;
                    }
                    

                    double media = Double.parseDouble(textFields[0].getText().trim());
                    double desvio = Double.parseDouble(textFields[1].getText().trim());
                    double a = Double.parseDouble(textFields[2].getText().trim());
                    double b = Double.parseDouble(textFields[3].getText().trim());

                    // Calcula a probabilidade normal
                    double probabilidade = Probabilidade.calculaAcumuladaNormal(b, desvio, media) - Probabilidade.calculaAcumuladaNormal(a, desvio, media);
                    String textoProb = String.format("%.4f", probabilidade * 100) + "%";
                    if(textoProb.contains("-")) {
                       textoProb = textoProb.replace("-", "");
                    } 
                    saidaText.setText("Resultado: " + textoProb);
                    saidaText.setForeground(Color.BLACK);
                    
                } else if (buttonText.equals("Voltar")) {
                    TelaDistNormal telaDistNormal = new TelaDistNormal();
                    telaDistNormal.setVisible(true);
                    dispose(); 
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
                saidaText.setForeground(Color.RED);
                textFields[i].setText("");
                return false;
            }
            try {
                double valor = Double.parseDouble(campos[i]);
                if (i == 1 && valor <= 0) {
                    saidaText.setText("<html>ERRO: Desvio padrão deve ser positivo</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }

            } catch (Exception e) {
                if(campos[i].contains(",")) {
                    saidaText.setText("<html>ERRO: Digite os números separados por (.)</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }

                if(campos[i].matches(".*\\s+.*")) {
                    saidaText.setText("<html>ERRO: espaços em branco não são permitidos</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }
                
                if(!campos[i].matches("-?\\d+(\\.\\d+)?")) {
                    saidaText.setText("<html>ERRO: letras, símbolos ou operações são inválidos</html>");
                    saidaText.setForeground(Color.RED);
                    textFields[i].setText("");
                    return false;
                }

                
            }
        }

        return true;
    } 

} 


