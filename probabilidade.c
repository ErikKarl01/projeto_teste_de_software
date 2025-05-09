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