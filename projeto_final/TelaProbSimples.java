package projeto_final;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Insets;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;

public class TelaProbSimples extends JFrame{
    public TelaProbSimples(){
        setTitle("Probabilidade simples / inserção de dados");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(220, 240, 235));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton[] botao = {
            new JButton("Calcular"),
            new JButton("Voltar")
        };

        //Label de casos favoráveis
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 10);
        JLabel casosFavoraveisLabel = new JLabel();
        casosFavoraveisLabel.setFont(new Font("Arial", Font.BOLD, 16));
        casosFavoraveisLabel.setText("Casos favoráveis: ");
        painel.add(casosFavoraveisLabel, gbc);

        //Text field de casos favoráveis
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        JTextField casosFavoraveisField = new JTextField(15);
        painel.add(casosFavoraveisField, gbc);

        //Label de total
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 10);
        JLabel totalLabel = new JLabel();
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setText("Total: ");
        painel.add(totalLabel, gbc);

        //Text field de total
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        JTextField totalField = new JTextField(15);
        painel.add(totalField, gbc);

        //JLabel de saída
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel saida = new JLabel("<html>Ponto e vírgola são diferenciados, vírgola não aceita</html>");
        saida.setPreferredSize(new Dimension(250, 100));
        saida.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(saida, gbc); 

        for (int i = 0; i < botao.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 0, 0, 0);
            botao[i].setPreferredSize(new Dimension(200, 50));

            String texto = botao[i].getText();
            botao[i].addActionListener(e -> {
                if(texto.equals("Calcular")){
                    Double total = null;
                    Double casosFavoraveis = null;
                    try {
                        casosFavoraveis = Double.parseDouble(casosFavoraveisField.getText().trim());
                    } catch (NumberFormatException ex) {
                        saida.setText("<html>Valor de casos favoráveis inválido ou nulo<html>");
                        return;
                    }
                    try {
                        total = Double.parseDouble(totalField.getText().trim());
                    } catch (NumberFormatException ex) {
                        saida.setText("<html>Valor de total inválido ou nulo</html>");
                        return;
                    }

                    if (casosFavoraveis != null && total != null) {
                        if (casosFavoraveis < 0 || total <= 0) {
                            saida.setText("<html>eventos favoráveis ≥ 0 e total > 0</html>");
                        } else if(casosFavoraveis > total) {
                            saida.setText("<html>Valor de casos favoráveis deve ser\n menor ou igual que total</html>");
                        } else if (total > 1000000000 || casosFavoraveis > 1000000000) {
                            saida.setText("<html>Valores muito grandes detectados, limite 1000000000</html>");
                        } else {
                            double resultado = Probabilidade.calcularProbabilidadeSimples(casosFavoraveis, total);
                            saida.setText("<html>Probabilidade = " + resultado*100+"%<html>");
                        }
                    }
                }
                else if (texto.equals("Voltar")) {
                    TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
                    telaProbabilidade.setVisible(true);
                    dispose();
                }
            });
            painel.add(botao[i], gbc);
        }
        add(painel);
    }
}