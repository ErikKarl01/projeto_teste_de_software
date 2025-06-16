package projeto_final;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.*;

public class TelaProbabilidade extends JFrame{
    public TelaProbabilidade(){
        setTitle("Probabilidade");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JButton[] botao = {
            new JButton("Distribuição Normal"),
            new JButton("Distribuição Binomial"),
            new JButton("Probabilidade Simples"),
            new JButton("Probabilidade Condicional")
        };

        for (JButton button : botao) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(200, 50));
            button.addActionListener(e -> {
                if (button.getText().equals("Distribuição Normal")) {
                    TelaProbNormal telaProbNormal = new TelaProbNormal();
                    telaProbNormal.setVisible(true);
                } else if (button.getText().equals("Distribuição Binomial")) {
                    TelaProbBinomial telaProbBinomial = new TelaProbBinomial();
                    telaProbBinomial.setVisible(true);
                } else if (button.getText().equals("Probabilidade Simples")) {
                    TelaProbSimples telaProbSimples = new TelaProbSimples();
                    telaProbSimples.setVisible(true);
                } else if (button.getText().equals("Probabilidade Condicional")) {
                    TelaProbCondicional telaProbCondicional = new TelaProbCondicional();
                    telaProbCondicional.setVisible(true);
                }
                dispose();
            });
        }

        for (JButton button : botao) {
            panel.add(button);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre os botões
        }

        setLocationRelativeTo(null);
    }
}
