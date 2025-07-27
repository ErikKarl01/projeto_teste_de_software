package projeto_final;

import org.apache.commons.math3.special.Erf;
import java.math.BigInteger;
public class Probabilidade {

    public static double calcularProbabilidadeSimples(double eventosFavoraveis, double eventosPossiveis){
        if(eventosFavoraveis < 0 || eventosPossiveis <= 0){
            System.out.println("Erro: eventos favoráveis devem ser >= 0 e eventos possíveis > 0");
            return -1;
        }

        return eventosFavoraveis / eventosPossiveis;
    }

    public static double calcularProbabilidadeCondicional(double probabilidade_aeb, double probabilidade_b){
        return probabilidade_aeb/probabilidade_b;
    }

    public static BigInteger fatorial(int n) {
        if(n < 0) {
            System.out.println("Erro: número negativo");
            return BigInteger.valueOf(-1);
        }

        if(n == 0) {
            return BigInteger.ONE;
        } else{
            return BigInteger.valueOf(n).multiply(fatorial(n - 1));
        }
    }


    public static BigInteger qtd_combinacoes(int n, int k) {
        if(n == k) {
            return BigInteger.ONE;
        } if(n < k) {
        System.out.println("Erro: nao foi possivel realizar o calculo porque o primeiro parametro e menor do que o segundo");
            return BigInteger.valueOf(-1);
        }

        BigInteger n_fatorial = fatorial(n);
        BigInteger k_fatorial = fatorial(k);
        BigInteger d_fatorial = fatorial(n - k);

        return (n_fatorial).divide((k_fatorial).multiply(d_fatorial));
    }

    public static double calcularProbabilidadeBinomial(double probabilidade, int repeticoes, int sucessos){
        if(probabilidade < 0 || probabilidade > 1){
            System.out.println("Erro: valor da probabilidade deve ser 0, 1 ou estar entre estes");
            return -1;
        }

        BigInteger coeficiente_binomial = qtd_combinacoes(repeticoes, sucessos);

        double resultado = coeficiente_binomial.doubleValue() *
                Math.pow(probabilidade, sucessos) *
                Math.pow(1 - probabilidade, repeticoes - sucessos);

        return resultado;
    }

    public static double calcularDensidadeNormal(double x, double desvioPadrao, double media){
        double pi = Math.PI;
        double e = Math.E;

        double expoente = -1*(Math.pow(x - media, 2)/(2 * Math.pow(desvioPadrao, 2)));
        double normal = Math.pow(e, expoente)/(desvioPadrao * Math.sqrt(2 * pi));
        return normal;
    }

    public static double calculaAcumuladaNormal(double x, double desvioPadrao, double media) {
        if (desvioPadrao <= 0) {
            System.out.println("Erro: desvio padrão deve ser maior que zero");
            return -1;
        }

        double z = (x - media) / desvioPadrao;
        return 0.5 * (1 + Erf.erf(z / Math.sqrt(2)));
    }

}

