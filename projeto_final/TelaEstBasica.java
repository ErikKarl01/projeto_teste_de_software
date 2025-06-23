package projeto_final;

import java.awt.*;
import javax.swing.*;

public class TelaEstBasica extends JFrame{

    public TelaEstBasica(){
        setTitle("Estatística Básica");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton[] botao = {
            new JButton("Voltar"),
            new JButton("Refazer"),
            new JButton("Sair"),
            new JButton("Calcular estatísticas")
        };

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JTextField campoValor = new JTextField(15);
        JLabel labelValor = new JLabel("Digite os valores entre espaços:");

        // Adiciona o label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(labelValor, gbc);

        // Adiciona o campo de texto
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 15, 10);
        painel.add(campoValor, gbc);

        // Adiciona os botões
        gbc.gridwidth = 2; 
        int linha = 2; // Linha inicial para os botões
        for (JButton btn : botao) {
            gbc.gridy = linha++;
            painel.add(btn, gbc);

            btn.setPreferredSize(new Dimension(200, 40));
            btn.addActionListener(e -> {
                if (btn.getText().equals("Voltar")) {
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    dispose();
                } else if (btn.getText().equals("Calcular estatísticas")) {
                    String dados = campoValor.getText();
                    TelaEstDescritiva telaEstDescritiva = new TelaEstDescritiva(dados);
                    telaEstDescritiva.setVisible(true);
                    dispose();
                } else if (btn.getText().equals("Refazer")) {
                    campoValor.setText("");
                } else if (btn.getText().equals("Sair")) {
                    System.exit(0);
                }
            });
        }

        add(painel);
        setLocationRelativeTo(null);
    }
}