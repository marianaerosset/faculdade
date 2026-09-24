#include <stdio.h>

void pir(int n){
    for(int i=0; i<n; i++){
        for(int j=0; j < n-1-i; j++){
            printf(" ");
        }
        for (int k=0; k<1+2*i; k++){
            printf("*");
        }
        printf("\n");
    }
}

int main(){
    int x;
    scanf("%d", &x);
    pir(x);
}