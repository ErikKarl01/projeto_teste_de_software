package projeto_final;

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

    public double variancia_amostral() {
        double soma_das_diferencas = 0;
        double media = media_simples();
        for(double num: this.entradas) {
            soma_das_diferencas += Math.pow(media - num, 2);
        }        

        return soma_das_diferencas/(this.entradas.length - 1);
    }
}
