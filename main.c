#include<stdio.h>
#include<stdlib.h>

int verifica_entrada(char entrata[], int tamanho, int *escolha){
    fgets(entrata, tamanho, stdin);

    if (sscanf(entrata, "%d", escolha) != 1)
    {
        printf("Erro ao escolher valor numérico");
        return 0;
    }
    return 1;
}

void opcao_est_basica(int escolha){
    double *resultado = 0;
    int tamanho = 0;
    resultado = restona_list_vallores(&tamanho);
    switch (escolha)
    {
    case 1:
        
        break;

    case 2:
        /* code */
        break;

    case 3:
        /* code */
        break;

    case 4:
        /* code */
        break;

    case 5:
        /* code */
        break;
        
    default:
        break;
    }
    printf("%f", resultado);
}

double* restona_list_vallores(int *tamanho){
    int continuar = 1;
    double valor;
    double *lista = NULL;

    printf("Adicione valores: ");

    while (continuar)
    {
        scanf("%f", &valor);

        int *temp = relloc(lista, (*tamanho + 1)*sizeof(double));
        if (temp == NULL)
        {
            printf("Erro de alocação");
            free(temp);
        }

        lista = temp;
        lista[*tamanho] = valor;
        tamanho++;

        printf("Deseja continuar? 0 para não e 1 para sim");
        scanf("%d", continuar);
    }

    return lista;
}

void estBasicaMenu(){
    char entrada_basica[100];
    int escolha = 0;

    printf("Escolha 1 para calcular média, 2 para mediana, 3 para mode, 4 para variância amostral e 5 para desvio padrão!");

    while (verifica_entrada(entrada_basica, sizeof(entrada_basica), &escolha)){}
    if (escolha == 0)
    {
        return;
    }
    
    opcao_est_basica(escolha);
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