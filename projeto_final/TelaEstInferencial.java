package projeto_final;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class TelaEstInferencial extends JFrame {
    public TelaEstInferencial(){
        setTitle("Estatística Inferencial");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JButton[] botao = {
            new JButton("Distribuição Normal"),
            new JButton("Distribuição Binomial"),
            new JButton("Probabilidade Simples"),
            new JButton("Probabilidade Condicional")
        };

        for (int i = 0; i < botao.length; i++) {
            gbc.gridx = 0; // Coluna do botão 
            gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche horizontalmente
            gbc.gridy = i; // Define a linha do botão
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
            botao[i].setPreferredSize(new Dimension(200, 50)); // Define o tamanho preferido do botão

            String texString = botao[i].getText();
            botao[i].addActionListener(e -> {
                if(texString.equals("Distribuição Normal")){
                    //TelaDistNormal telaDistNormal = new TelaDistNormal();
                    //telaDistNormal.setVisible(true);
                } else if(texString.equals("Distribuição Binomial")){
                    //TelaDistBinomial telaDistBinomial = new TelaDistBinomial();
                    //telaDistBinomial.setVisible(true);
                } else if(texString.equals("Probabilidade Simples")){
                    //TelaProbSimples telaProbSimples = new TelaprobSimples();
                    //telaProbSimples.setVisible(true);
                } else if(texString.equals("Probabilidade Condicional")){
                    //TelaProbCondicional telaProbCondicional = new TelaprobCondicional();
                    //telaProbCondicional.setVisible(true);
                }

                dispose();
            });

            panel.add(botao[i], gbc);
        }

        add(panel);
    }
}
