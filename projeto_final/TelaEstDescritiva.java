package projeto_final;

import java.awt.*;
import javax.swing.*;

public class TelaEstDescritiva extends JFrame {
    private EstatisticaBasica entradas;

    public TelaEstDescritiva(String dados) {
        setTitle("Tela de Estatística Descritiva");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] partes = dados.trim().split("\\s+");
        double[] numeros = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Double.parseDouble(partes[i]);
        }

        entradas = new EstatisticaBasica();
        entradas.processarEntradas(numeros);
        entradas.quickSort(0, numeros.length - 1);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(46, 46, 46)
);
        GridBagConstraints gbc = new GridBagConstraints();

        // Campo de resultado
        JTextField resultado = new JTextField(20);
        resultado.setEditable(false);
        JLabel labelResultado = new JLabel("Resultado:");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelResultado, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 15, 10);
        panel.add(resultado, gbc);

        // Botões de estatísticas
        String[] nomesBotoes = {
            "Média", "Variância", "Moda", "Desvio Padrão",
            "Mediana", "Valor Máximo", "Valor Mínimo",
            "Frequência Simples", "Frequência Acumulada",
            "Frequência Relativa", "Frequência Relativa Acumulada"
        };

        int[] colunasPorLinha = {4, 3, 2, 2};
        int botaoIndex = 0;
        int linhaInicial = 2;

        for (int linha = 0; linha < colunasPorLinha.length; linha++) {
            int colunas = colunasPorLinha[linha];
            int colunaInicial = (4 - colunas) / 2;

            for (int col = 0; col < colunas && botaoIndex < nomesBotoes.length; col++) {
                gbc.gridx = colunaInicial + col;
                gbc.gridy = linha + linhaInicial;
                gbc.gridwidth = 1;
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.CENTER;

                String textoBotao = nomesBotoes[botaoIndex];
                JButton botao = new JButton(textoBotao);
                botao.setPreferredSize(new Dimension(200, 50));

                botao.addActionListener(e -> {
                    switch (textoBotao) {
                        case "Média" -> resultado.setText(String.format("%.5f", entradas.media_simples()));
                        case "Variância" -> resultado.setText(String.format("%.2f", entradas.calculaVarianciaAmostral()));
                        case "Moda" -> resultado.setText(String.valueOf(entradas.calcularModa()));
                        case "Desvio Padrão" -> resultado.setText(String.format("%.2f", entradas.calculaDesvioPadrão()));
                        case "Mediana" -> resultado.setText(String.format("%.2f", entradas.calculaMediana()));
                        case "Valor Máximo" -> resultado.setText(String.valueOf(entradas.calculaValorMax()));
                        case "Valor Mínimo" -> resultado.setText(String.valueOf(entradas.calculaValorMin()));
                        case "Frequência Simples" -> resultado.setText(entradas.calculaFrequenciaSimples().toString());
                        case "Frequência Acumulada" -> resultado.setText(entradas.calculaFrequenciaAcumulada().toString());
                        case "Frequência Relativa" -> resultado.setText(entradas.calculaFrequenciaRelativa().toString());
                        case "Frequência Relativa Acumulada" -> resultado.setText(entradas.calculaFrequenciaRelativaAcumulada().toString());
                    }
                    resultado.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                });

                panel.add(botao, gbc);
                botaoIndex++;
            }
        }

        // Botão Voltar (sozinho)
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setPreferredSize(new Dimension(200, 50));
        btnVoltar.addActionListener(e -> {
            TelaEstBasica telaEstBasica = new TelaEstBasica();
            telaEstBasica.setVisible(true);
            dispose();
        });

        gbc.gridy = linhaInicial + colunasPorLinha.length + 1;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnVoltar, gbc);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
}