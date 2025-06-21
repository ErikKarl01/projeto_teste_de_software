package projeto_final;

import java.math.*;
import java.util.HashMap;
import java.util.Map;

public class EstatisticaBasica {
    double[] entradas;

    public double media_simples(){
        double soma = 0;

        for(double num: this.entradas){
            soma += num;
        }

        return soma/this.entradas.length;
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

    public double calculaMediana(){
        if(entradas == null){
            System.err.println("Sem valores na lista!");
            return 0;
        }

        if (this.entradas.length%2 != 0) {
            int index = entradas.length/2;
            return entradas[index];
        }else{
            int index_sup = entradas.length/2;
            int index_inf = entradas.length/2 - 1;
            return (entradas[index_sup] + entradas[index_inf])/2;
        }
    }

    public double calculaVarianciaAmostral() {
        double soma_das_diferencas = 0;
        double media = media_simples();
        for(double num: this.entradas) {
            soma_das_diferencas += Math.pow(media - num, 2);
        }        

        return soma_das_diferencas/(this.entradas.length - 1);
    }

    public double calculaDesvioPadrão(){
        return Math.sqrt(calculaVarianciaAmostral());
    }

    public double calculaValorMin(){
        return this.entradas[0];
    }

    public double calculaValorMax(){
        return this.entradas[entradas.length];
    }

    public Map<Double, Integer> calculaFrequenciaSimples(){
        Map<Double, Integer> mapa = new HashMap<>();

        for (int index = 0; index < entradas.length; index++) {
            double chave = entradas[index];
            mapa.put(chave, mapa.getOrDefault(chave, 0)+1); 
        }

        return mapa;
    }

    public Map<Double, Integer> calculaFrequenciaAcumulada(){
        Map<Double, Integer> mapa = calculaFrequenciaSimples();
        int soma = 0;

        for (Map.Entry<Double, Integer> entry : mapa.entrySet()) {
            soma += entry.getValue();
            mapa.put(entry.getKey(), soma);
        }
        return mapa;
    }

    public double calcularModa() {
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
