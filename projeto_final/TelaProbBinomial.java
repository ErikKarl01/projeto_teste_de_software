package projeto_final;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class TelaProbBinomial extends JFrame{
    public TelaProbBinomial(){
        setTitle("Probabilidade binomial");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField variavelXField = new JTextField();
        painel.add(variavelXField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField mediaField = new JTextField();
        painel.add(mediaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField desvioPadraoField = new JTextField();
        painel.add(desvioPadraoField, gbc);

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
            Double probabilidade = null;
            Integer repeticoes = null;
            Integer sucessos = null;

            try {
                probabilidade = Double.parseDouble(variavelXField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                repeticoes = Integer.parseInt(desvioPadraoField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }
            try {
                sucessos = Integer.parseInt(mediaField.getText().trim());
            } catch (NumberFormatException ex) {
                saidaTextField.setText("ERRO: Valor não numérico detectado");
            }

            if (probabilidade != null && repeticoes !=  null && sucessos != null) {
                if (probabilidade > 0 && probabilidade <= 1) {
                    saidaTextField.setText("Resultado: " + Probabilidade.calcularProbabilidadeBinomial(probabilidade, repeticoes, sucessos));
                }else{
                    saidaTextField.setText("Probabilidade deve estar entre 0 e 1");
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