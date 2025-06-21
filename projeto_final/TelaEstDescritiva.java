package projeto_final;

import java.awt.*;
import javax.swing.*;


public class TelaEstDescritiva extends JFrame {
    private double[] numeros;
    
    public TelaEstDescritiva(String dados) {
        setTitle("Tela de Estatística Descritiva");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] partes = dados.split(" ");
        numeros = new double[partes.length];

        if (numeros.length == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum número foi fornecido.", "Erro", JOptionPane.ERROR_MESSAGE);
            setVisible(false);
            SwingUtilities.invokeLater(() -> {
                TelaEstBasica telaEstBasica = new TelaEstBasica();
                telaEstBasica.setVisible(true);
                this.dispose();
            });
        }

        
        for (int i = 0; i < partes.length; i++) {
            try {
            numeros[i] = Double.parseDouble(partes[i].trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao converter os dados. Certifique-se de que são números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            setVisible(false);
            SwingUtilities.invokeLater(() -> {
                TelaEstBasica telaEstBasica = new TelaEstBasica();
                telaEstBasica.setVisible(true);
                this.dispose();
            });


        }
        }

        


        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();    

        JButton[] opcoes = {
            new JButton("Média"),
            new JButton("Variância"),
            new JButton("Moda"),
            new JButton("Voltar")
        };    

        JTextField resultado = new JTextField(10);
        resultado.setEditable(false);
        //resultado.setVisible(false);
        JLabel labelResultado = new JLabel("Resultado:");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelResultado, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 15, 10);
        panel.add(resultado, gbc);

        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);
        int linha = 2; // Linha inicial para os botões

        for (JButton botao : opcoes) {
            gbc.gridy = linha++;
            panel.add(botao, gbc);

            botao.setPreferredSize(new Dimension(200, 50));
            botao.addActionListener(e -> {
                if (botao.getText().equals("Voltar")) {
                    TelaEstBasica telaEstBasica = new TelaEstBasica();
                    telaEstBasica.setVisible(true);
                    dispose();
                } else if (botao.getText().equals("Média")) {
                    double media = EstatisticaBasica.media_simples(numeros);
                    resultado.setText(String.valueOf(media));
                } else if (botao.getText().equals("Variância")) {
                    double variancia = EstatisticaBasica.calculaVarianciaAmostral(numeros);
                    resultado.setText(String.format("%.2f", variancia));
                } else if (botao.getText().equals("Moda")) {
                    double moda = EstatisticaBasica.calcularModa(numeros);
                    resultado.setText(String.valueOf(moda));
                }
                resultado.setVisible(true);
                panel.revalidate();
                panel.repaint();
            });
        }

        
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

}