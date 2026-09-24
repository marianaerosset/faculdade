#include <stdio.h>

int main(){
    char na[100], nb[100];
    char c;

    scanf("%s", na);
    scanf("%s", nb);
    
    FILE *arq_a = fopen(na, "r"), *arq_b = fopen(nb, "w");
    
    while((c = fgetc(arq_a)) != EOF){     // copia caractere por caractere
        fputc(c, arq_b);;
    }

    fclose(arq_a);
    fclose(arq_b);
}