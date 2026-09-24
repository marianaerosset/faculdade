#include <stdio.h>

int ds(int **mat, int n, int i){
    if(i == n) return 0;
    else return mat[i][n-1-i] + ds(mat, n, i+1);
}

int dp(int **mat, int n, int i){
    if(i == n) return 0;
    else return mat[i][i] + dp(mat, n, i+1);
}

int main(){
    int n;
    scanf("%d", &n);
    int **mat = malloc(n*sizeof(int *));
    for (int i=0; i<n; i++){
        mat[i] = malloc(n*sizeof(int));
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            scanf("%d", &mat[i][j]);
        }
    }
    int somas = ds(mat, n, 0);
    int somap = ds(mat, n, 0);

    printf("\n%d", somas);
    printf("\n%d", somap);
}