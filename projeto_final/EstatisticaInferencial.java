
package projeto_final;

public class EstatisticaInferencial {

    // Intervalo de confiança (quando desvio padrão populacional é conhecido)
    public double[] intervaloConfiancaMediaComDesvioPadrao(double mediaAmostral, double z, double desvioPadrao, int tamanhoAmostra) {
        if (tamanhoAmostra <= 0 || desvioPadrao <= 0 || z <= 0) {
            System.out.println("Erro: parâmetros inválidos");
            return new double[]{-1, -1};
        }

        double margemErro = calcularMargemErro(z, desvioPadrao, tamanhoAmostra);
        if (margemErro < 0) {
            System.out.println("Erro: cálculo da margem de erro falhou");
            return new double[]{-1, -1};
        }

        return new double[]{mediaAmostral - margemErro, mediaAmostral + margemErro};
    }

    // Intervalo de confiança (quando desvio padrão populacional é desconhecido, usa t de Student)
    public double[] intervaloConfiancaMediaSemDesvioPadrao(double mediaAmostral, double t, double desvioAmostral, int tamanhoAmostra) {
        if (tamanhoAmostra <= 1 || desvioAmostral <= 0 || t <= 0) {
            System.out.println("Erro: parâmetros inválidos");
            return new double[]{-1, -1};
        }

        double erroPadrao = desvioAmostral / Math.sqrt(tamanhoAmostra);
        double margemErro = t * erroPadrao;

        return new double[]{mediaAmostral - margemErro, mediaAmostral + margemErro};
    }

    // Teste Z (hipótese para média com desvio padrão conhecido)
    public double testeZ(double mediaAmostral, double mediaHipotetica, double desvioPadrao, int tamanhoAmostra) {
        if (tamanhoAmostra <= 0 || desvioPadrao <= 0) {
            System.out.println("Erro: parâmetros inválidos");
            return -1;
        }

        return (mediaAmostral - mediaHipotetica) / (desvioPadrao / Math.sqrt(tamanhoAmostra));
    }

    // Teste T (hipótese para média com desvio padrão amostral)
    public double testeT(double mediaAmostral, double mediaHipotetica, double desvioAmostral, int tamanhoAmostra) {
        if (tamanhoAmostra <= 1 || desvioAmostral <= 0) {
            System.out.println("Erro: parâmetros inválidos");
            return -1;
        }

        return (mediaAmostral - mediaHipotetica) / (desvioAmostral / Math.sqrt(tamanhoAmostra));
    }

    // Margem de erro simples
    public double calcularMargemErro(double z, double desvioPadrao, int tamanhoAmostra) {
        if (tamanhoAmostra <= 0 || desvioPadrao <= 0) {
            System.out.println("Erro: parâmetros inválidos");
            return -1;
        }

        return z * (desvioPadrao / Math.sqrt(tamanhoAmostra));
    }

    // Exemplo de uso (para testes)
    public static void main(String[] args) {
        EstatisticaInferencial est = new EstatisticaInferencial();

        double[] ic = est.intervaloConfiancaMediaComDesvioPadrao(50, 1.96, 10, 100);
        System.out.println("IC (com σ conhecido): [" + ic[0] + ", " + ic[1] + "]");

        double z = est.testeZ(52, 50, 10, 100);
        System.out.println("Estatística Z: " + z);

        double t = est.testeT(52, 50, 12, 25);
        System.out.println("Estatística T: " + t);

        double margem = est.calcularMargemErro(1.96, 10, 100);
        System.out.println("Margem de erro: " + margem);
    }
}
