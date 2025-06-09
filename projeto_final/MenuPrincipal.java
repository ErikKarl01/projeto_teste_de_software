package projeto_final;

import javax.crypto.spec.DESedeKeySpec;
import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.*;


public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        setTitle("Menu Principal");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.archor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);


        JButton btnEstBasica = new JButton("Estatística Básica");
        btnEstBasica.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEstBasica.setMaximumSize(new Dimension(200, 50));
        btnEstBasica.addActionListener(e -> {
            TelaEstBasica telaEstBasica = new TelaEstBasica();
            telaEstBasica.setVisible(true);
            dispose();
        });

        JButton btnEstInferencial = new JButton("Estatística Inferencial");
        btnEstInferencial.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEstInferencial.setMaximumSize(new Dimension(200, 50));
        btnEstInferencial.addActionListener(e -> {
            TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
            telaEstInferencial.setVisible(true);
            dispose();
        });

        JButton btnProbabilidade = new JButton("Estatística Básica");
        btnProbabilidade.setMaximumSize(new Dimension(200, 50));
        btnProbabilidade.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProbabilidade.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
            dispose();
        });

        painel.add(btnEstBasica);
        painel.add(btnEstInferencial);
        painel.add(btnProbabilidade);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }
}
