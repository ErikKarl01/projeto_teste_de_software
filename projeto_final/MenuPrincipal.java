package projeto_final;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Color;


public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        setTitle("Menu Principal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(46, 46, 46));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton[] botao = {
            new JButton("Estatística Básica"),
            new JButton("Estatística Inferencial"),
            new JButton("Probabilidade")
        };

        for (int i = 0; i < botao.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 10, 10, 10);
            botao[i].setPreferredSize(new Dimension(200, 50)); // Define o tamanho preferido do botão

            String texto = botao[i].getText();
            botao[i].addActionListener(e -> {
                if (texto.equals("Estatística Básica")) {
                    TelaEstBasica telaEstBasica = new TelaEstBasica();
                    telaEstBasica.setVisible(true);
                } else if (texto.equals("Estatística Inferencial")) {
                    TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
                    telaEstInferencial.setVisible(true);
                } else if (texto.equals("Probabilidade")) {
                    TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
                    telaProbabilidade.setVisible(true);
                }
                dispose();
            });

            painel.add(botao[i], gbc);
        }
        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }
}
