#include <stdio.h>

float media_simple(float lista[], int tamanho); 

int main() {
    float media, lista[] = {1, 2, 3, 4, 5};
    int tamanho = sizeof(lista)/sizeof(lista[0]);
    media = media_simple(lista, tamanho);

    printf(" %.2f ", media);
    return 0;
}

float media_simple(float lista[], int tamanho) {
    float media, soma = 0;
    
    for (int i = 0; i < tamanho; i++){
        soma += lista[i];
    }

    media = soma/tamanho;

    return media;
}