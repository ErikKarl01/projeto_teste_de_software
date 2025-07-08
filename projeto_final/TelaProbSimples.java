package projeto_final;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class TelaProbSimples extends JFrame{
    public TelaProbSimples(){
        setTitle("Probabilidade simples / inserção de dados");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton[] botao = {
            new JButton("Calcular"),
            new JButton("Voltar")
        };

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField casosFavoraveisField = new JTextField();
        painel.add(casosFavoraveisField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField totalField = new JTextField();
        painel.add(totalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saida = new JTextField("Resultado");
        painel.add(saida, gbc);

        for (int i = 0; i < botao.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            botao[i].setPreferredSize(new Dimension(200, 50));

            String texto = botao[i].getText();
            botao[i].addActionListener(e -> {
                if(texto.equals("Calcular")){
                    double total = -1;
                    double casosFavoraveis = -1;
                    try {
                        casosFavoraveis = Double.parseDouble(casosFavoraveisField.getText().trim());
                    } catch (NumberFormatException ex) {
                        saida.setText("Valor 1 inválido");
                    }
                    try {
                        total = Double.parseDouble(totalField.getText().trim());
                    } catch (NumberFormatException ex) {
                        saida.setText("Valor 2 inválido");
                    }

                    if (casosFavoraveis != -1 && total != -1) {
                        if (casosFavoraveis < 0 || total <= 0) {
                            saida.setText("Erro: eventos favoráveis ≥ 0 e possíveis > 0");
                        } else {
                            double resultado = Probabilidade.calcularProbabilidadeSimples(casosFavoraveis, total);
                            saida.setText("Probabilidade = " + resultado);
                        }
                    }
                }
                else if (texto.equals("Voltar")) {
                    TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
                    telaProbabilidade.setVisible(true);
                }
            });
            painel.add(botao[i], gbc);
        }
        add(painel);
    }
}
