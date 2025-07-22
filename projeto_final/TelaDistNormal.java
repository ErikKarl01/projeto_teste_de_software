package projeto_final;
import java.awt.*;
import javax.swing.*;

public class TelaDistNormal extends JFrame {
    public TelaDistNormal() {
        setTitle("Distribuição Normal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(220, 240, 235));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton[] botoes = new JButton[]{
            new JButton("P(X < x)"),
            new JButton("P(a < X < b)"),
            new JButton("f(x)"),
            new JButton("Voltar")
        };
        botoes[0].setToolTipText("Calcula a Probabilidade acumulada normal");
        botoes[1].setToolTipText("Calcula a Probabilidade acumulada de dois pontos fornecidos e depois calcula a diferença");
        botoes[2].setToolTipText("Calcula a função de densidade de probabilidade normal para um dado ponto");
        
        for(int i = 0; i < botoes.length; i++) {
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = i;
        gbc.insets = new Insets(10, 10, 10, 10);
        botoes[i].setPreferredSize(new Dimension(200, 50));
        panel.add(botoes[i], gbc);
        String texto = botoes[i].getText();
        botoes[i].addActionListener(e -> {
            if(texto.equals("P(X < x)")) {
                TelaProbNormal telaProbNormal = new TelaProbNormal();
                telaProbNormal.setVisible(true);
            }
            else if(texto.equals("P(a < X < b)")) {
                TelaPNIntervalo telaProbDoisPontos = new TelaPNIntervalo();
                telaProbDoisPontos.setVisible(true);
            }
            else if(texto.equals("f(x)")) {
                TelaDensidadeNormal telaDensidade = new TelaDensidadeNormal();
                telaDensidade.setVisible(true);
            }
            else if(texto.equals("Voltar")) {
                TelaProbabilidade telaProb = new TelaProbabilidade();
                telaProb.setVisible(true);
                
            }
            dispose(); 
        });
        }

        add(panel);

    }

}