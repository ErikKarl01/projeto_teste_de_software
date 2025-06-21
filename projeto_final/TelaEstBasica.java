package projeto_final;


import java.awt.*;
import javax.swing.*;

public class TelaEstBasica extends JFrame{

    public TelaEstBasica(){
        setTitle("Estatística Básica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelInterno = new JPanel();
        painelInterno.setLayout(new BoxLayout(painelInterno, BoxLayout.Y_AXIS));

        painelInterno.add(Box.createVerticalGlue());

        JButton[] botao = {
            new JButton("Voltar"),
            new JButton("Refazer"),
            new JButton("Sair"),
            new JButton("Calcular estatísticas")
        };

        JTextField campoValor = new JTextField(10);
        JLabel labelValor = new JLabel("Digite os valores entre espaços:");

        for (JButton jButton : botao) {
            jButton.addActionListener(e -> {
                if (jButton.getText().equals("Voltar")) {
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    dispose();
                }else if(jButton.getText().equals("Calcular estatísticas")){
                    String dados = campoValor.getText();
                    TelaEstDescritiva telaEstDescritiva = new TelaEstDescritiva(dados);
                    telaEstDescritiva.setVisible(true);
                    dispose();
                }else if(jButton.getText().equals("Refazer")){
                    campoValor.setText("");
                }else if(jButton.getText().equals("Sair")){
                    System.exit(0);
                }});
        }

        painelInterno.add(labelValor);
        painelInterno.add(campoValor);
        painelInterno.add(Box.createVerticalStrut(20)); // Espaço entre o campo de texto e os botões
        painelInterno.add(Box.createVerticalGlue()); // Espaço flexível para centralizar os botões


        for (JButton btn : botao) {
            btn.setPreferredSize(new Dimension(100, 50));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelInterno.add(btn);
            painelInterno.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        }
        painelInterno.add(Box.createVerticalGlue()); // Espaço flexível para centralizar os botões
        
        JPanel painelExterno = new JPanel(new GridBagLayout());
        painelExterno.add(painelInterno);

        add(painelExterno);
        setLocationRelativeTo(null);
    }
}
