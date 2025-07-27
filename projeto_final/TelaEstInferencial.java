package projeto_final;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class TelaEstInferencial extends JFrame {
    public TelaEstInferencial(){
        setTitle("Estatística Inferencial");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(210, 180, 140));
        GridBagConstraints gbc = new GridBagConstraints();


        JButton[] botao = {
            new JButton("Interv. de confiança (média)"),
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
                if(texString.equals("Interv. de confiança (média)")){
                    TelaIntervaloDeConfianca telaIntervaloDeConfianca = new TelaIntervaloDeConfianca();
                    telaIntervaloDeConfianca.setVisible(true);
                } else if(texString.equals("Valor z de uma população")){
                    TelaValorCriticoZ telaValorCriticoZ = new TelaValorCriticoZ();
                    telaValorCriticoZ.setVisible(true);
                } else if(texString.equals("Teste T de uma amostra")){
                    TelaTesteTAmostra telaTesteTAmostra = new TelaTesteTAmostra();  
                    telaTesteTAmostra.setVisible(true);
                } else if(texString.equals("Teste de proporção simples")){
                    TesteProporcaoSimples telaProporcaoSimples = new TesteProporcaoSimples();
                    telaProporcaoSimples.setVisible(true);
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
