package projeto_final;
import java.awt.*;
import javax.swing.*;

/* Apenas um teste de integração com bibliotecas externas, 
não significa a interface final 

Importante: Ao compilar e executar os seguintes comandos, certifique-se de que esteja no diretório raiz do
projeto, a saber, projeto_teste_de_software.
Para compilar o código, execute:
javac -cp ".;lib/commons-math3-3.6.1.jar" .\projeto_final\Probabilidade.java .\projeto_final\TelaProbNormal.java 
java -cp ".;lib/commons-math3-3.6.1.jar" projeto_final.TelaProbNormal 
*/
public class TelaProbNormal extends JFrame {
    public TelaProbNormal() {
        setTitle("Cálculo de Probabilidade Normal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Exemplo de uso:
        JTextField mediaField = new JTextField(15);
        JTextField desvioPadraoField = new JTextField(15);
        JTextField xField = new JTextField(15);
        JButton calcularButton = new JButton("Calcular");

        // Adicione os componentes ao painel com as restrições desejadas
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Média:"), gbc);
        gbc.gridx = 1;
        panel.add(mediaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Desvio Padrão:"), gbc);
        gbc.gridx = 1;
        panel.add(desvioPadraoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("X:"), gbc);
        gbc.gridx = 1;
        panel.add(xField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(calcularButton, gbc);

        calcularButton.addActionListener(e -> {
            try {
                double media = Double.parseDouble(mediaField.getText());
                double desvioPadrao = Double.parseDouble(desvioPadraoField.getText());
                double x = Double.parseDouble(xField.getText());

                double pAN = Probabilidade.calculaAcumuladaNormal(x, desvioPadrao, media);

                JOptionPane.showMessageDialog(this, "Probabilidade acumulada: " + pAN);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaProbNormal().setVisible(true);
        });
    }
}

