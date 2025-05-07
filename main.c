#include<stdio.h>

int verifica_entrada(char entrata[], int tamanho, int *escolha){
    fgets(entrata, tamanho, stdin);

    if (sscanf(entrata, "%d", escolha) != 1)
    {
        printf("Erro ao escolher valor numérico");
        return 0;
    }
    return 1;
}

void estBasicaMenu(){
    int escolha_basica;
    double *lista = NULL;
    int tamanho = 0;

    printf("Escolha 1 para calcular média, 2 para mediana, 3 para mode, 4 para variância amostral e 5 para desvio padrão ou 0 para dair deste menu!");
    scanf("%d", escolha_basica);

    printf("Adicione valores: ");
    scanf("");

    while ()
    {
        int *temp = relloc
    }
    
}

void estInferencialMenu();
void estProbabilisticaMenu();

void opcao_inicial(int opcao_inicial){
    switch (opcao_inicial)
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

    default:
        printf("Opção incorreta!");
        break;
    }
}

void menu_area(int *encerrar){
    int escolha = 0;
    char entrata[100];

    printf("Digite 1 para estatística básica, 2 para inferencial, 3 para probabilidade"
        "e 0 para sair");


    if (verifica_entrada(entrata, sizeof(entrata), &escolha) && escolha != 0)
    {
        opcao_inicial(escolha);
    }
    if (escolha == 0)
    {
        *encerrar = 0;
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