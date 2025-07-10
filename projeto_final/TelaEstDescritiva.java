package projeto_final;
import java.awt.*;
import javax.swing.*;

public class TelaEstDescritiva extends JFrame {
    private EstatisticaBasica entradas;
    
    public TelaEstDescritiva(String dados) {
        setTitle("Tela de Estatística Descritiva");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        String[] partes = dados.split(" ");
        double[] numeros = new double[partes.length];

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
                numeros[i] = Double.parseDouble(partes[i]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Erro ao converter os números: " + partes[i], "Erro", JOptionPane.ERROR_MESSAGE);
                setVisible(false);
                SwingUtilities.invokeLater(() -> {
                    TelaEstBasica telaEstBasica = new TelaEstBasica();
                    telaEstBasica.setVisible(true);
                    this.dispose();
                });
                return;
            }
        }
        
        entradas = new EstatisticaBasica();
        entradas.processarEntradas(numeros);
        entradas.quickSort(0, numeros.length - 1);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        

        JButton[] opcoes = {
            new JButton("Média"),
            new JButton("Variância"),
            new JButton("Moda"),
            new JButton("Desvio Padrão"),
            new JButton("Mediana"),
            new JButton("Valor Máximo"),
            new JButton("Valor Mínimo"),
            new JButton("Frequência Simples"),
            new JButton("Frequência Acumulada"),
            new JButton("Frequência Relativa"),
            new JButton("Frequência Relativa Acumulada"),
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
                    double media = entradas.media_simples();
                    resultado.setText(String.valueOf(media));
                } else if (botao.getText().equals("Variância")) {
                    double variancia = entradas.calculaVarianciaAmostral();
                    resultado.setText(String.format("%.2f", variancia));
                } else if (botao.getText().equals("Moda")) {
                    double moda = entradas.calcularModa();
                    resultado.setText(String.valueOf(moda));
                } else if (botao.getText().equals("Desvio Padrão")) {
                    double desvioPadrao = entradas.calculaDesvioPadrão();
                    resultado.setText(String.format("%.2f", desvioPadrao));
                } else if (botao.getText().equals("Mediana")) {
                    double mediana = entradas.calculaMediana();
                    resultado.setText(String.format("%.2f", mediana));
                } else if (botao.getText().equals("Valor Máximo")) {
                    double valorMaximo = entradas.calculaValorMax();
                    resultado.setText(String.valueOf(valorMaximo));
                } else if (botao.getText().equals("Valor Mínimo")) {
                    double valorMinimo = entradas.calculaValorMin();
                    resultado.setText(String.valueOf(valorMinimo));
                } else if (botao.getText().equals("Frequência Simples")) {
                    resultado.setText(entradas.calculaFrequenciaSimples().toString());
                } else if (botao.getText().equals("Frequência Acumulada")) {
                    resultado.setText(entradas.calculaFrequenciaAcumulada().toString());
                } else if (botao.getText().equals("Frequência Relativa")) {
                    resultado.setText(entradas.calculaFrequenciaRelativa().toString());
                } else if (botao.getText().equals("Frequência Relativa Acumulada")) {
                    resultado.setText(entradas.calculaFrequenciaRelativaAcumulada().toString());
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