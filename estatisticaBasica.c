#include<stdio.h>
#include<math.h>

double desvio_padrao_amostral(double lista[], int tamanho, double media, ){
    double acumulador = 0;

    for (int i = 0; i != tamanho; i++)
    {
        acumulador += pow((lista[i] - media), 2);
    }   

    return sqrt(acumulador/(tamanho - 1));

}