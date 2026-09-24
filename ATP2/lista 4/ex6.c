#include <stdio.h>

int esc(int n, int d){
    if(d == n) return 1;
    if(d > n) return 0;
    else return esc(n, d+1) + esc(n, d+2);
}

int main(){
    int qtd;
    scanf("%d", &qtd);
    printf("%d", esc(qtd, 0));
}