#include <stdio.h>
#include <stdlib.h>

int main(void){
    int n;

    scanf("%d", &n);

    int *v = malloc(n*sizeof(int));

    if(!v){
        printf("Erro ao alocar memória");
    }

    for(int i=0; i<n; i++){
        printf("\nEndereco do elemento %d: %p", i+1, (void*)&v[i]);
    }

    free(v);
    return 0;
}