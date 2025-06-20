package projeto_final;

import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.*;

public class TelaEstBasica extends JFrame{
    List<Double> valores;

    public TelaEstBasica(){
        setTitle("Estatística Básica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JButton[] botao = {
            new JButton("Voltar"),
            new JButton("Refazer"),
            new JButton("Sair"),
            new JButton("Adicionar"),
            new JButton("Mostar estatísticas")
        };

        JTextField campoValor = new JTextField(10);
        JLabel labelValor = new JLabel("Digite um valor:");
        JTextField resultado = new JTextField(10);
        resultado.setEditable(false);
        resultado.setVisible(false);
        JLabel labelResultado = new JLabel("Resultado:");

        for (JButton jButton : botao) {
            jButton.setPreferredSize(new Dimension(100, 50));
            jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            jButton.addActionListener(e -> {
                if (jButton.getText().equals("Voltar")) {
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                }else if(jButton.getText().equals("Adicionar")){
                    double valor = Double.parseDouble(campoValor.getText());
                    //Método de verificação de valores
                    valores.add(valor);
                }else if(jButton.getText().equals("Mostar estatísticas")){
                    //Método de cálculo de estatísticas
                    resultado.setVisible(true);
                    painel.revalidate();
                    painel.repaint();
                }else if(jButton.getText().equals("Refazer")){
                    campoValor.setText("");
                    resultado.setText("");
                }else if(jButton.getText().equals("Sair")){
                    System.exit(0);
                }});
        }

        painel.add(labelValor);
        painel.add(campoValor);
        painel.add(labelResultado);
        painel.add(resultado);


        for (int i = 0; i < botao.length; i++) {
            painel.add(botao[i]);
        }

        add(painel);

        setLocationRelativeTo(null);
    }
}
