#include<stdio.h>
#include<math.h>


double desvio_padrao_amostral(double lista[], int tamanho){
    double acumulador = 0;

    for (int i = 0; i != tamanho; i++)
    {
        acumulador += pow((lista[i] - media(lista, tamanho)), 2);
    }   

    return sqrt(acumulador/(tamanho - 1));

}

double moda(double lista[], int tamanho) {
    int max_freq = 0;
    double moda_valor = lista[0];

    for (int i = 0; i < tamanho; i++) {
        int freq = 0;
        for (int j = 0; j < tamanho; j++) {
            if (lista[i] == lista[j]) {
                freq++;
            }
        }

        if (freq > max_freq) {
            max_freq = freq;
            moda_valor = lista[i];
        }
    }

    return moda_valor;
}