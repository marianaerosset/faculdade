int shellSort(int v[], int n) {
    /* Inicia com um gap (h) e vai reduzindo */
    for (int gap = n/2; gap > 0; gap /= 2){
    /* Ordene por inserção com gaps para esse tamanho de gap*/
        for (int i = gap; i < n; i += 1){
            int temp = v[i];
            /*Desloca elementos por gaps até encontrar o local correto para a[i]*/
            int j;
            for (j = i; j >= gap && v[j - gap] > temp; j -= gap) v[j] = v[j - gap];
            v[j] = temp; // Coloque temp na posição correta
        }
    }
    return 0;
}

/*
Sequência de incremento h otimizada:
    h(s) = {
        3*h(s − 1) + 1, para s > 1
        1, para s = 1
    }
    1, 4, 13, 40, 121...
Custo: varia de O(n^2) a O(n(log n)^2)
EXEMPLO:
    3   1   0   4   5

*/