#include <stdio.h>

int main(){
    FILE *arq = fopen("aula.txt", "r+");
    if(arq==NULL){
        printf("num foi");
        return 1;
    }
    else{
        int i;
        fscanf(arq, "%d", &i);
        i = i+1;
//      fseek(arq, 0, SEEK_SET);
        rewind(arq);
        fprintf(arq, "%d", i);
        fclose(arq);
        printf("foi");
        return 0;
    }
    
}