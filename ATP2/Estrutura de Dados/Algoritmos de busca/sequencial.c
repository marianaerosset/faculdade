int BuscaSequencial (int x, int n, int v[]) {
    int j = 0;
    while (j < n && v[j] < x) ++j;
    return j;
}


/*Custo: 
    -Melhor caso: O(1)
    -Pior e caso médio: O(n) 
EXEMPLO:
    3   1   0   4   5

*/