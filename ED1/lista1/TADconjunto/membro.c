#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int membro(int x, int *A){
    int i = 0;
    while(x != A[i]) i++;
    return i;
}

void main(){
    int *A;
    int x, n;

    SetConsoleOutputCP(65001);

    printf("Insira a quantidade de elementos do vetor: ");
    scanf("%d", &n);
    A = (int*)malloc((n+1) * sizeof(int));
    if (A == NULL) {
        printf("Erro ao alocar memória.\n");
        return;
    }

    printf("Insira os elementos do vetor: ");
    for(int i = 0; i < n; i++){
        scanf("%d", &A[i]);
    }

    printf("Insira o elemento a ser buscado: ");
    scanf("%d", &x);
    A[n] = x; // evita acesso fora do vetor

    int resultado = membro(x, A);

    if(resultado == n){
        printf("O elemento %d não está presente no vetor.\n", x);
    } else {
        printf("O elemento %d está presente no vetor.\n", x);
    }

    free(A);
}