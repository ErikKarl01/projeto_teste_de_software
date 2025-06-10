package projeto_final;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

public class TelaProbabilidade extends JFrame{
    public TelaProbabilidade(){
        setTitle("Probabilidade");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btnProbNormal = new JButton("Distribuição Normal");
        btnProbNormal.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProbNormal.setMaximumSize(new Dimension(100, 50));
        btnProbNormal.addActionListener(e -> {
            TelaProbNormal telaProbNormal = new TelaProbNormal();
            telaProbNormal.setVisible(true);
            dispose();
        });

        JButton btnProbBinomial = new JButton("Distribuição Binomial");
        btnProbBinomial.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProbBinomial.setMaximumSize(new Dimension(100, 50));
        btnProbBinomial.addActionListener(e -> {
            TelaProbBinomial telaProbBinomial = new TelaProbBinomial();
            telaProbBinomial.setVisible(true);
            dispose();
        });

        JButton btnProbSimples = new JButton("Probabilidade Simples");
        btnProbSimples.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProbSimples.setMaximumSize(new Dimension(100, 50));
        btnProbSimples.addActionListener(e -> {
            TelaProbSimples telaProbSimples = new TelaProbSimples();
            telaProbSimples.setVisible(true);
            dispose();
        });

        JButton btnProbCondicional = new JButton("Probabilidade Condicional");
        1qw

        setLocationRelativeTo(null);
    }
}
