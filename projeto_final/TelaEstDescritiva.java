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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));    

        JButton[] opcoes = {
            new JButton("Média"),
            new JButton("Variância"),
            new JButton("Moda"),
            new JButton("Voltar")
        };    

        JTextField resultado = new JTextField(10);
        resultado.setEditable(false);
        resultado.setVisible(false);
        JLabel labelResultado = new JLabel("Resultado:");
        
        for (JButton botao : opcoes) {
            botao.setPreferredSize(new Dimension(200, 50));
            botao.setAlignmentX(Component.CENTER_ALIGNMENT);
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

        panel.add(Box.createVerticalStrut(20)); // Espaço vertical
        panel.add(labelResultado);
        panel.add(resultado);
        panel.add(Box.createVerticalStrut(20)); // Espaço vertical
        for (JButton botao : opcoes) {
            panel.add(botao);
            panel.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        }
        add(panel);
    }

}