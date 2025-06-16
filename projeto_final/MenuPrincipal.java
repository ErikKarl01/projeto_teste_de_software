package projeto_final;

import projeto_final.TelaEstBasica;
import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;

public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        setTitle("Menu Principal");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JButton[] botao = {
            new JButton("Estatística Básica"),
            new JButton("Estatística Inferencial"),
            new JButton("Probabilidade")
        };

        for (JButton button : botao) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(200, 50));
            button.addActionListener(e -> {
                if (button.getText().equals("Estatística Básica")) {
                    TelaEstBasica telaEstBasica = new TelaEstBasica();
                    telaEstBasica.setVisible(true);
                } else if (button.getText().equals("Estatística Inferencial")) {
                    TelaEstInferencial telaEstInferencial = new TelaEstInferencial();
                    telaEstInferencial.setVisible(true);
                } else if (button.getText().equals("Probabilidade")) {
                    TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
                    telaProbabilidade.setVisible(true);
                }
                dispose();
            });
            painel.add(button);
        }

        for (int i = 0; i < botao.length; i++) {
            painel.add(botao[i]);
        }

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }
}
