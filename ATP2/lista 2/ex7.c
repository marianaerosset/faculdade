#include <stdio.h>
#include <string.h>

void ocorrencia(const char *S, char c, int *f, int *l){
    *f = -1;
    *l = -1;
    for(int i=0; S[i] != 0; i++){
        if(S[i]==c){
            if(*f == -1){
                *f = i;
            }
            *l = i;
        }
    }
}

int main(){
    char s[100], c;
    int p, u;

    fgets(s, sizeof(s), stdin);
    scanf("%c", &c);

    ocorrencia(s, c, &p, &u);
    
    if(p == -1){
        printf("\nNenhum caractere em comum.");
    }
    else{
        printf("\nPrimeira ocorrencia: %d", p+1);
        printf("\nUltima ocorrencia: %d", u+1);
    }

    return 0;
}