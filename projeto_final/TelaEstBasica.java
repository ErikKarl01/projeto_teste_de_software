package projeto_final;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class TelaEstBasica extends JFrame{
    private static JTextField campoValor;
    
    public TelaEstBasica(){
        setTitle("Estatística Básica");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        painel.setBackground(new Color(46, 46, 46));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton[] botao = {
            new JButton("Voltar"),
            new JButton("Refazer"),
            new JButton("Sair"),
            new JButton("Calcular estatísticas")
        };

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        campoValor = new JTextField(15);
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
                    if(verificaDados(dados)) {
                        TelaEstDescritiva telaEstDescritiva = new TelaEstDescritiva(dados);
                        telaEstDescritiva.setVisible(true);
                        dispose();
                    }
                } else if (btn.getText().equals("Refazer")) {
                    campoValor.setText("");
                } else if (btn.getText().equals("Sair")) {
                    System.exit(0);
                }
            });
        }

        add(painel);
    }

    private static boolean verificaDados(String dados) {
        if (dados == null || dados.trim().isEmpty()) {
            campoValor.setText("Erro: Digite pelo menos um valor.");
            return false;
        }

        String[] valores = dados.trim().split("\\s+");
        for (String valor : valores) {
            try {
                double valorDouble = Double.parseDouble(valor);
                if(valorDouble < -1000000000 || valorDouble > 1000000000) {
                    campoValor.setText("Erro: valor está fora do intervalo permitido (-1.000.000.000 a 1.000.000.000)");
                    return false;
                }
            } catch (NumberFormatException e) {
                
                if (valor.contains(",")) {
                    campoValor.setText("Erro: vírgula (,) não é um parâmetro válido. Use ponto (.) para separar os números decimais.");
                    return false;
                }
                // verifica se o valor atual foi uma letra ou símbolo
                else if (!valor.matches("-?\\d+([\\.,]\\d+)?")) {
                    campoValor.setText("Erro: não é permitido letras, símbolos ou operações matemáticas. Digite apenas números");
                    return false;
                }   

            }
        }

        return true;
    }

}