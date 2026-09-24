#include <stdio.h>

void parentese(int n, int abertos, int fechados, char *s, int idx){
    if(abertos == n && fechados == n){
        s[idx] = '\n';
        printf("%s\n", s);
        return;
    }
    if(abertos<n){
        s[idx] = '(';
        parentese(n, abertos+1, fechados, s, idx+1);
    }
    if(fechados<abertos){
        s[idx] = ')';
        parentese(n, abertos, fechados+1, s, idx+1);
    }
}

int main(){
    int n = 3;
    char s[2*20 + 1];   // suficiente para n <= 20
    parentese(n, 0, 0, s, 0);
    return 0;
}