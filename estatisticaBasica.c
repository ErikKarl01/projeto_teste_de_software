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

//Media Simples
float media(float lista[],int tamanho) {
    float media, soma = 0;
    //int tamanho = sizeof(lista)/sizeof(lista[0]);

    for (int i = 0; i < tamanho; i++){
        soma += lista[i];
    }

    media = soma/tamanho;

    return media;
}

float calcula_variancia_amostral(float lista[], int tamanho) {
    float media = 0;
    media = media(lista, tamanho);
    float soma_das_diferencas = 0; 
     for(int i = 0; i < tamanho; i++) {
         soma_das_diferencas += pow(lista[i] - media, 2);
     }
     float s2 = soma_das_diferencas/(tamanho - 1);
     
     return s2;
 }
// Função auxiliar para ordenar a lista (Bubble Sort)
void ordenar(float lista[], int tamanho) {
    for (int i = 0; i < tamanho - 1; i++) {
        for (int j = 0; j < tamanho - i - 1; j++) {
            if (lista[j] > lista[j + 1]) {
                float temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }
}
// Função que calcula a mediana
float calcular_mediana(float lista[], int tamanho) {
    ordenar(lista, tamanho);

    if (tamanho % 2 == 0) {
        // Se for par, média dos dois do meio
        return (lista[tamanho/2 - 1] + lista[tamanho/2]) / 2.0;
    } else {
        // Se for ímpar, valor do meio
        return lista[tamanho/2];
    }
}