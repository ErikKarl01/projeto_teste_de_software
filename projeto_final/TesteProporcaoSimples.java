package projeto_final;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class TesteProporcaoSimples extends JFrame{
    public TesteProporcaoSimples(){
        setTitle("Tela teste de proporção simples");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField proposcaoAmostral = new JTextField();
        painel.add(proposcaoAmostral, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField proporcaoHipotetica = new JTextField();
        painel.add(proporcaoHipotetica, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField tamanhoAmostra = new JTextField();
        painel.add(tamanhoAmostra, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField saidaTextField = new JTextField();
        painel.add(saidaTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton calcularButton = new JButton();
        calcularButton.addActionListener(e -> {
            Double proporcaoAmostraDouble = null;
            Double proposcaoHipoteticaDouble = null;
            Integer tamanhoAmostraInteger = null;

            try {
                proporcaoAmostraDouble = Double.parseDouble(proposcaoAmostral.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                proposcaoHipoteticaDouble = Double.parseDouble(proporcaoHipotetica.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                tamanhoAmostraInteger = Integer.parseInt(tamanhoAmostra.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }

            if (proporcaoAmostraDouble != null && proposcaoHipoteticaDouble !=  null && tamanhoAmostraInteger != null) {
                if (tamanhoAmostraInteger <= 0 || proposcaoHipoteticaDouble <= 0 || proposcaoHipoteticaDouble >= 1) {
                    saidaTextField.setText("Entradas inválidas");
                } else{
                    saidaTextField.setText("Resultado: " + EstatisticaInferencial.testeProporcaoSimples(proporcaoAmostraDouble, proposcaoHipoteticaDouble, tamanhoAmostraInteger));
                }
            }
        });
        painel.add(calcularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton voltarButton = new JButton();
        voltarButton.addActionListener(e -> {
            TelaProbabilidade telaProbabilidade = new TelaProbabilidade();
            telaProbabilidade.setVisible(true);
        });
        painel.add(voltarButton, gbc);

        add(painel);
    }
}
