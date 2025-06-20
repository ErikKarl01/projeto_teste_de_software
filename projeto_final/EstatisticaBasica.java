package projeto_final;

public class EstatisticaBasica {

    public static double media_simples(double[] entradas) {
        double soma = 0;

        for(double num: entradas){
            soma += num;
        }

        return soma/entradas.length;
    }

    public int ordenacaoParcial(double[] array, int inicio, int fim){
        double pivo = array[fim];
        int posicao_i = inicio - 1; 

        for (int index = 0; index < fim; index++) {
            if (array[index] < pivo) {
                posicao_i++;

                double temporario = array[index];
                array[index] = array[posicao_i];
                array[posicao_i] = temporario;
            }
        }

        double temporario = array[fim];
        array[fim] = array[posicao_i + 1];
        array[posicao_i + 1] = temporario;

        return posicao_i + 1;
    }

    public void quickSort(double[] array, int inicio, int fim){
        if (inicio<fim) {
            int posicao_pivo = ordenacaoParcial(array, inicio, fim);
            quickSort(array, posicao_pivo + 1, fim);
            quickSort(array, inicio, posicao_pivo - 1);   
        }
    }

    public static double variancia_amostral(double[] entradas) {
        double soma_das_diferencas = 0;
        double media = media_simples(entradas);
        for(double num: entradas) {
            soma_das_diferencas += Math.pow(media - num, 2);
        }        

        return soma_das_diferencas/(entradas.length - 1);
    }

    public static double calcularModa(double[] entradas) {
        double moda = entradas[0];
        int maxFrequencia = 1;

        for (int i = 0; i < entradas.length; i++) {
        int frequenciaAtual = 1;

        for (int j = i + 1; j < entradas.length; j++) {
            if (entradas[i] == entradas[j]) {
                frequenciaAtual++;
            }
        }

        if (frequenciaAtual > maxFrequencia) {
            maxFrequencia = frequenciaAtual;
            moda = entradas[i];
        }
    }

    return moda;
}
}
