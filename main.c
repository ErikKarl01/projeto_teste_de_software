#include<stdio.h>

void verifica_entrada(char entrata[], int tamanho, int *escolha){
    fgets(entrata, tamanho, stdin);

    if (sscanf(entrata, "%d", escolha) != 1)
    {
        printf("Erro ao escolher valor numérico");
        return;
    }
}

void estBasicaMenu();
void estInferencialMenu();
void estProbabilisticaMenu();

void menu_area(int *encerrar){
    int escolha = 0;
    char entrata[100];

    printf("Digite 1 para estatística básica, 2 para inferencial, 3 para probabilidade"
        "e 0 para sair");

    verifica_entrada(entrata, sizeof(entrata), &escolha);

    switch (escolha)
    {
    case 1:
        estBasicaMenu();
        break;

    case 2:
        estInferencialMenu();
        break;
    
    case 3:
        estProbabilisticaMenu();
        break;

    case 0:
        *encerrar = 0;
        break;

    default:
        printf("Opção incorreta!");
        break;
    }
}


int main ()
{
    int encerrar = 1;

    do
    {
        menu_area(&encerrar);
        
    } while (encerrar);
    

    return 0;
}