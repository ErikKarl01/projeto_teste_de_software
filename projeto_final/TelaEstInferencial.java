package projeto_final;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaEstInferencial extends JFrame {
    public TelaEstInferencial(){
        setTitle("Estatística Inferencial");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JButton[] botao = {
            new JButton("Intervalo de confiança da média de uma população"),
            new JButton("Valor z de uma população"),
            new JButton("Teste T de uma amostra"),
            new JButton("Teste de proporção simples"),
            new JButton("Voltar")
        };

        for (int i = 0; i < botao.length; i++) {
            gbc.gridx = 0; // Coluna do botão 
            gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche horizontalmente
            gbc.gridy = i; // Define a linha do botão
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
            botao[i].setPreferredSize(new Dimension(200, 50)); // Define o tamanho preferido do botão

            String texString = botao[i].getText();
            botao[i].addActionListener(e -> {
                if(texString.equals("Intervalo de confiança da média de uma população")){
                    //TelaDistNormal telaDistNormal = new TelaDistNormal();
                    //telaDistNormal.setVisible(true);
                } else if(texString.equals("Valor z de uma população")){
                    //TelaDistBinomial telaDistBinomial = new TelaDistBinomial();
                    //telaDistBinomial.setVisible(true);
                } else if(texString.equals("Teste T de uma amostra")){
                    //TelaProbSimples telaProbSimples = new TelaprobSimples();
                    //telaProbSimples.setVisible(true);
                } else if(texString.equals("Teste de proporção simples")){
                    //TelaProbCondicional telaProbCondicional = new TelaProbCondicional();
                    //telaProbCondicional.setVisible(true);
                } else if(texString.equals("Voltar")){
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.setVisible(true);
                } 

                dispose();
            });

            panel.add(botao[i], gbc);
        }

        add(panel);
    }
}
