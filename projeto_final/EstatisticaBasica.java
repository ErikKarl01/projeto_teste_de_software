package projeto_final;

import java.util.HashMap;
import java.util.Map;

public class EstatisticaBasica {

    public static double media_simples(double[] entradas) {
        double soma = 0;

        for(double num: entradas){
            soma += num;
        }

        return soma/entradas.length;
    }

    public static int ordenacaoParcial(double[] array, int inicio, int fim){
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

    public static void quickSort(double[] array, int inicio, int fim){
        if (inicio<fim) {
            int posicao_pivo = ordenacaoParcial(array, inicio, fim);
            quickSort(array, posicao_pivo + 1, fim);
            quickSort(array, inicio, posicao_pivo - 1);   
        }
    }

    public static double calculaMediana(double[] entradas) {
        if(entradas == null){
            System.err.println("Sem valores na lista!");
            return 0;
        }

        if (entradas.length%2 != 0) {
            int index = entradas.length/2;
            return entradas[index];
        }else{
            int index_sup = entradas.length/2;
            int index_inf = entradas.length/2 - 1;
            return (entradas[index_sup] + entradas[index_inf])/2;
        }
    }

    public static double calculaVarianciaAmostral(double[] entradas) {
        double soma_das_diferencas = 0;
        double media = media_simples(entradas);
        for(double num: entradas) {
            soma_das_diferencas += Math.pow(media - num, 2);
        }        

        return soma_das_diferencas/(entradas.length - 1);
    }

    public static double calculaDesvioPadrão(double[] entradas) {
        return Math.sqrt(calculaVarianciaAmostral(entradas));
    }

    public static double calculaValorMin(double [] entradas) {
        return entradas[0];
    }

    public static double calculaValorMax(double [] entradas) {
        return entradas[entradas.length];
    }

    public static Map<Double, Integer> calculaFrequenciaSimples(double[] entradas) {
        Map<Double, Integer> mapa = new HashMap<>();

        for (int index = 0; index < entradas.length; index++) {
            double chave = entradas[index];
            mapa.put(chave, mapa.getOrDefault(chave, 0)+1); 
        }

        return mapa;
    }

    public static Map<Double, Integer> calculaFrequenciaAcumulada(double[] entradas) {
        Map<Double, Integer> mapa = calculaFrequenciaSimples(entradas);
        int soma = 0;

        for (Map.Entry<Double, Integer> entry : mapa.entrySet()) {
            soma += entry.getValue();
            mapa.put(entry.getKey(), soma);
        }
        return mapa;
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
