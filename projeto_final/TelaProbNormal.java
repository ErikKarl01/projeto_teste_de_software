package projeto_final;
import java.awt.*;
import javax.swing.*;

/* Apenas um teste de integração com bibliotecas externas, 
não significa a interface final 

Importante: Ao compilar e executar os seguintes comandos, certifique-se de que esteja no diretório raiz do
projeto, a saber, projeto_teste_de_software.
Para compilar o código, execute:
javac -cp ".;lib/commons-math3-3.6.1.jar" .\projeto_final\Probabilidade.java .\projeto_final\TelaProbNormal.java 
java -cp ".;lib/commons-math3-3.6.1.jar" projeto_final.TelaProbNormal 
*/
public class TelaProbNormal extends JFrame {
    private static JTextField[] textFields;

    public TelaProbNormal() {
        setTitle("Cálculo de Probabilidade Normal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        textFields = new JTextField[]{
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15)
        };
        textFields[3].setEditable(false);
        JButton[] buttons = {
            new JButton("Calcular"),
            new JButton("Voltar")
        };

        // Adicione os componentes ao painel com as restrições desejadas
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Média:"), gbc);
        gbc.gridx = 1;
        panel.add(textFields[0], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Desvio Padrão:"), gbc);
        gbc.gridx = 1;
        panel.add(textFields[1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("X:"), gbc);
        gbc.gridx = 1;
        panel.add(textFields[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Resultado:"), gbc);
        gbc.gridx = 1;
        panel.add(textFields[3], gbc);

        for (int i = 0; i < buttons.length; i++) {
            gbc.gridx = 1;
            gbc.gridy = 5 + i; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
            buttons[i].setPreferredSize(new Dimension(200, 50));
            panel.add(buttons[i], gbc);
            String buttonText = buttons[i].getText();
            buttons[i].addActionListener(e -> {
                if (buttonText.equals("Calcular")) {
                    //Verifica se os campos estão preenchidos corretamente
                    if (!validateFields()) {
                        return;
                    }
                    

                    double media = Double.parseDouble(textFields[0].getText().trim());
                    double desvio = Double.parseDouble(textFields[1].getText().trim());
                    double x = Double.parseDouble(textFields[2].getText().trim());

                    // Calcula a probabilidade normal
                    double resultado = Probabilidade.calculaAcumuladaNormal(x, desvio, media);
                    textFields[3].setText(String.valueOf(resultado));
                } else if (buttonText.equals("Voltar")) {
                    TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
                    telaProbabilidade.setVisible(true);
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
            textFields[2].getText().trim()
        };

       for(int i = 0; i < campos.length; i++) {
            if (campos[i].isEmpty()) {
                textFields[i].setText("ERRO: Campo vazio");
                return false;
            }
            try {
                double valor = Double.parseDouble(campos[i]);
                if (i == 1 && valor <= 0) {
                    textFields[i].setText("ERRO: desvio padrão deve ser positivo");
                    return false;
                }

            } catch (Exception e) {
                if(campos[i].contains(",")) {
                    textFields[i].setText("ERRO: vírgula não é permitida");
                    
                    return false;
                }

                if(campos[i].contains("\\s+")) {
                    textFields[i].setText("ERRO: espaços em branco não são permitidos");
                    
                    return false;
                }
                
                if(!campos[i].matches("-?\\d+(\\.\\d+)?")) {
                    textFields[i].setText("ERRO: letras, símbolos ou operações são inválidos");
                    
                    return false;
                }

                
            }
        }

        return true;
    }   
    }

    
