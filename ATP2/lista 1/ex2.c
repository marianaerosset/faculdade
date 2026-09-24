#include <stdio.h>
#include <math.h>

int main(){
    FILE *arq = fopen("aula.txt", "r+");
    double i;
    fscanf(arq, "%lf", &i);
    i = sqrt(1+i*i);
//  fseek(arq, 0, SEEK_SET);
    rewind(arq);
    fprintf(arq, "%lf", i);
}