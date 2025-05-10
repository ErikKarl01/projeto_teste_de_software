#include <stdio.h>
#include <math.h>

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
        return (lista[tamanho / 2 - 1] + lista[tamanho / 2]) / 2.0;
    } else {
        // Se for ímpar, valor do meio
        return lista[tamanho / 2];
    }
}

// Função para calcular a média
float media(float lista[], int tamanho) {
    float soma = 0;

    for (int i = 0; i < tamanho; i++) {
        soma += lista[i];
    }

    return soma / tamanho;
}

// Função para calcular o desvio padrão amostral
float desvio_padrao_amostral(float lista[], int tamanho) {
    float m = media(lista, tamanho);
    float soma = 0;

    for (int i = 0; i < tamanho; i++) {
        soma += pow(lista[i] - m, 2);
    }

    return sqrt(soma / (tamanho - 1));
}

// Função para calcular a variância amostral
float calcula_variancia_amostral(float lista[], int tamanho) {
    float m = media(lista, tamanho);
    float soma = 0;

    for (int i = 0; i < tamanho; i++) {
        soma += pow(lista[i] - m, 2);
    }

    return soma / (tamanho - 1);
}

// Função para calcular a moda
float moda(float lista[], int tamanho) {
    int max_freq = 0;
    float moda_valor = lista[0];

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

// Função main para exemplo de uso
int main() {
    float dados[] = {10, 20, 20, 30, 40, 50, 50};
    int tamanho = sizeof(dados) / sizeof(dados[0]);

    printf("Média: %.2f\n", media(dados, tamanho));
    printf("Mediana: %.2f\n", calcular_mediana(dados, tamanho));
    printf("Moda: %.2f\n", moda(dados, tamanho));
    printf("Desvio Padrão Amostral: %.2f\n", desvio_padrao_amostral(dados, tamanho));
    printf("Variância Amostral: %.2f\n", calcula_variancia_amostral(dados, tamanho));

    return 0;
}


