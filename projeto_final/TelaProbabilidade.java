package projeto_final;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.Insets;


public class TelaProbabilidade extends JFrame{
    public TelaProbabilidade(){
        setTitle("Probabilidade");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JButton[] botao = {
            new JButton("Distribuição Normal"),
            new JButton("Distribuição Binomial"),
            new JButton("Probabilidade Simples"),
            new JButton("Probabilidade Condicional"),
            new JButton("Voltar")
        };

        for (int i = 0; i < botao.length; i++) {
            gbc.gridx = 0; // Coluna do botão 
            gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche horizontalmente
            gbc.gridy = i; // Define a linha do botão
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
            botao[i].setPreferredSize(new Dimension(200, 50)); // Define o tamanho preferido do botão

            String texto = botao[i].getText();
            botao[i].addActionListener(e -> {
                if (texto.equals("Distribuição Normal")) {
                    //TelaProbNormal telaProbNormal = new TelaProbNormal();
                    //telaProbNormal.setVisible(true);
                } else if (texto.equals("Distribuição Binomial")) {
                    //TelaProbBinomial telaProbBinomial = new TelaProbBinomial();
                    //telaProbBinomial.setVisible(true);
                } else if (texto.equals("Probabilidade Simples")) {
                    //TelaProbSimples telaProbSimples = new TelaProbSimples();
                    //telaProbSimples.setVisible(true);
                } else if (texto.equals("Probabilidade Condicional")) {
                    //TelaProbCondicional telaProbCondicional = new TelaProbCondicional();
                    //telaProbCondicional.setVisible(true); 
                } else if (texto.equals("Voltar")) {
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.setVisible(true);
                }
                dispose();
            });
            panel.add(botao[i], gbc);
        }
        add(panel);
        setLocationRelativeTo(null);
    }
}
