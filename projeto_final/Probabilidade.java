package projeto_final;

public class Probabilidade {

public static int fatorial(int n) {
        if(n < 0) {
            System.out.println("Erro: número negativo");
            return -1;
        }

        if(n == 0) {
            return 1;
        } else{
            return n * fatorial(n - 1);
        }
    }

    public static int qtd_combinacoes(int n, int k) {
    if(n == k) {
        return 1;
    } if(n < k) {
       System.out.println("Erro: nao foi possivel realizar o calculo porque o primeiro parametro e menor do que o segundo");
        return -1; 
    }

    int n_fatorial = fatorial(n);
    int k_fatorial = fatorial(k);
    int d_fatorial = fatorial(n - k);

    return (n_fatorial)/((k_fatorial)*(d_fatorial));
}

    public static double probabilidade_binomial(double probabilidade, int repeticoes, int sucessos){
        if(probabilidade < 0 || probabilidade > 1){
            System.out.println("Erro: valor da probabilidade deve ser 0, 1 ou estar entre estes");
            return -1;
        }

        int coeficiente_binomial = qtd_combinacoes(repeticoes, sucessos);

        return coeficiente_binomial*Math.pow(probabilidade, sucessos)*Math.pow(1 - probabilidade, repeticoes - sucessos);
    }
}
