#include <stdio.h>

void copia(FILE *fonte, FILE *dest){
        char c;
        while((c = fgetc(fonte)) != EOF){
            fputc(c, dest);
        }
}

int main(){
    char na[30], nb[30], nc[30];

    scanf("%s", na);
    scanf("%s", nb);
    scanf("%s", nc);

    FILE *arq1 = fopen(na, "r"), *arq2 = fopen(nb, "r"), *arq3 = fopen(nc, "w");

    if(!arq1 || !arq2 || !arq3){
        printf("ERRO");
    }
    else{
        copia(arq1, arq3);
        copia(arq2, arq3);

        fclose(arq1);
        fclose(arq2);
        fclose(arq3);

        printf("SUCESSO");
    }
    
}

