package projeto_final;

import java.util.*;

public class EstatisticaBasica {
    double[] entrada;

    public void processarEntradas(double[] entrada) {
        this.entrada = entrada; 
    }

    public EstatisticaBasica(){}

    public double media_simples() {
        double soma = 0;

        for(double num: this.entrada){
            soma += num;
        }

        return soma / this.entrada.length;
    }

    public int ordenacaoParcial(int inicio, int fim){
        double pivo = this.entrada[fim];
        int posicao_i = inicio - 1;

        for (int index = inicio; index < fim; index++) {
            if (this.entrada[index] < pivo) {
                posicao_i++;

                double temporario = this.entrada[index];
                this.entrada[index] = this.entrada[posicao_i];
                this.entrada[posicao_i] = temporario;
            }
        }

        double temporario = this.entrada[fim];
        this.entrada[fim] = this.entrada[posicao_i + 1];
        this.entrada[posicao_i + 1] = temporario;

        return posicao_i + 1;
    }

    public void quickSort(int inicio, int fim){
        if (inicio < fim) {
            int posicao_pivo = ordenacaoParcial(inicio, fim);
            quickSort(posicao_pivo + 1, fim);
            quickSort(inicio, posicao_pivo - 1);
        }
    }

    public double calculaMediana() {
        if(this.entrada == null){
            System.err.println("Sem valores na lista!");
            return 0;
        }

        if (this.entrada.length % 2 != 0) {
            int index = this.entrada.length / 2;
            return this.entrada[index];
        }else{
            int index_sup = this.entrada.length / 2;
            int index_inf = this.entrada.length / 2 - 1;
            return (this.entrada[index_sup] + this.entrada[index_inf]) / 2;
        }
    }

    public double calculaVarianciaAmostral() {
        double soma_das_diferencas = 0;
        double media = media_simples();
        for(double num: this.entrada) {
            soma_das_diferencas += Math.pow(media - num, 2);
        }        

        return soma_das_diferencas / (this.entrada.length - 1);
    }

    public double calculaDesvioPadrão() {
        return Math.sqrt(calculaVarianciaAmostral());
    }

    public double calculaValorMin() {
        return this.entrada[0];
    }

    public double calculaValorMax() {
        return this.entrada[this.entrada.length - 1];
    }

    public Map<Double, Double> calculaFrequenciaSimples() {
        Map<Double, Double> mapa = new HashMap<>();

        for (int index = 0; index < this.entrada.length; index++) {
            double chave = this.entrada[index];
            mapa.put(chave, mapa.getOrDefault(chave, 0.0) + 1.0);
        }

        return mapa;
    }

    public Map<Double, Double> calculaFrequenciaAcumulada() {
        Map<Double, Double> mapa = calculaFrequenciaSimples();
        double soma = 0;

        for (Map.Entry<Double, Double> entry : mapa.entrySet()) {
            soma += entry.getValue();
            mapa.put(entry.getKey(), soma);
        }
        return mapa;
    }

    public Map<Double, Double> calculaFrequenciaRelativa() {
        Map<Double, Double> mapa = calculaFrequenciaSimples();
        int totalEntradas = this.entrada.length;

        for (Map.Entry<Double, Double> entry : mapa.entrySet()) {
            double frequencia = entry.getValue();
            mapa.put(entry.getKey(), frequencia / totalEntradas);
        }

        return mapa;
    }

    public Map<Double, Double> calculaFrequenciaRelativaAcumulada() {
        Map<Double, Double> mapa = calculaFrequenciaSimples();
        double soma = 0;
        int totalEntradas = this.entrada.length;

        for (Map.Entry<Double, Double> entry : mapa.entrySet()) {
            soma += entry.getValue() / totalEntradas;
            mapa.put(entry.getKey(), soma);
        }

        return mapa;
    }

    public double calcularModa() {
        double moda = this.entrada[0];
        int maxFrequencia = 1;

        for (int i = 0; i < this.entrada.length; i++) {
            int frequenciaAtual = 1;

            for (int j = i + 1; j < this.entrada.length; j++) {
                if (this.entrada[i] == this.entrada[j]) {
                    frequenciaAtual++;
                }
            }

            if (frequenciaAtual > maxFrequencia) {
                maxFrequencia = frequenciaAtual;
                moda = this.entrada[i];
            }
        }

        return moda;
    }

    public static void main(String[] args){
        EstatisticaBasica estatisticaBasica = new EstatisticaBasica();
        estatisticaBasica.quickSort(0, estatisticaBasica.entrada.length - 1);
        System.out.println("Entrada: " + Arrays.toString(estatisticaBasica.entrada));
        System.out.println("Média Simples: " + estatisticaBasica.media_simples());
        System.out.println("Mediana: " + estatisticaBasica.calculaMediana());
        System.out.println("Desvio Padrão: " + estatisticaBasica.calculaDesvioPadrão());
        System.out.println("Valor Mínimo: " + estatisticaBasica.calculaValorMin());
        System.out.println("Valor Máximo: " + estatisticaBasica.calculaValorMax());
        System.out.println("Frequência Simples: " + estatisticaBasica.calculaFrequenciaSimples());
        System.out.println("Frequência Acumulada: " + estatisticaBasica.calculaFrequenciaAcumulada());
        System.out.println("Frequência Relativa: " + estatisticaBasica.calculaFrequenciaRelativa());
        System.out.println("Frequência Relativa Acumulada: " + estatisticaBasica.calculaFrequenciaRelativaAcumulada());
        System.out.println("Moda: " + estatisticaBasica.calcularModa());
        System.out.println("Variância Amostral: " + estatisticaBasica.calculaVarianciaAmostral());
    }
}
