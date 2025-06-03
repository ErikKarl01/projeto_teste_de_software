package projeto_final;

public class EstatisticaBasica {
    double[] entradas;

    double media_simples(){
        double soma = 0;

        for(double num: this.entradas){
            soma += num;
        }

        return soma/this.entradas.length;
    }
}
