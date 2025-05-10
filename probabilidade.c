#include <stdio.h>

double calcular_probabilidade_evento_favoravel(int favoraveis, int total) {
    if (total <= 0) {
        printf("Erro: o total de eventos deve ser maior que zero.\n");
        return -1.0;
    }
    if (favoraveis < 0 || favoraveis > total) {
        printf("Erro: número de eventos favoráveis inválido.\n");
        return -1.0;
    }
    return (double)favoraveis / total;
}
// Função para calcular a probabilidade composta (eventos independentes com operador E)
double calcular_probabilidade_composta_e(double p1, double p2) {
    if (p1 < 0 || p1 > 1 || p2 < 0 || p2 > 1) {
        printf("Erro: as probabilidades devem estar entre 0 e 1.\n");
        return -1.0;
    }
    return p1 * p2;
}

// Exemplo de uso
int main() {
    double pA = calcular_probabilidade_evento_favoravel(3, 10);  // P(A) = 0.3
    double pB = calcular_probabilidade_evento_favoravel(5, 10);  // P(B) = 0.5

    double pA_E_B = calcular_probabilidade_composta_e(pA, pB);   // P(A e B)

    if (pA_E_B >= 0)
        printf("Probabilidade de A e B ocorrerem: %.2f\n", pA_E_B);

    return 0;
}