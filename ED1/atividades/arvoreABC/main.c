#include <stdio.h>
#include <math.h>

void preOrdem (int t[], int i, int n);
void inOrdem (int t[], int i, int n);
void posOrdem (int t[], int i, int n);

int main(){
    int h, n;
    
    printf("Insira a altura da arvore: ");
    scanf("%d", &h);
    n = pow(2, h) - 1;

    int t[n+1];
    
    for(int i = 1; i < n+1; i++){
        scanf("%d", &t[i]);
    }

    printf("\nPre-ordem: ");
    preOrdem(t, 1, n);
    printf("\nIn-ordem: ");
    inOrdem(t, 1, n);
    printf("\nPos-ordem: ");
    posOrdem(t, 1, n);

    return 0;
}

void preOrdem (int t[], int i, int n){
    if(i < n+1){
        printf("%d ", t[i]);
        preOrdem(t, 2*i, n); //esquerda
        preOrdem(t, 2*i + 1, n); //direita
    }
}

void inOrdem (int t[], int i, int n){
    if(i < n+1){
        inOrdem(t, 2*i, n); //esquerda
        printf("%d ", t[i]);
        inOrdem(t, 2*i + 1, n); //direita
    }
}

void posOrdem (int t[], int i, int n){
    if(i < n+1){
        posOrdem(t, 2*i, n); //esquerda
        posOrdem(t, 2*i + 1, n); //direita
        printf("%d ", t[i]);
    }
}