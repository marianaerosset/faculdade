//shell
int shellSort(int v[], int n) {
    /* Inicia com um gap (h) e vai reduzindo */
    for (int gap = n/2; gap > 0; gap /= 2){
    /* Ordene por inserção com gaps para esse tamanho de gap*/
        for (int i = gap; i < n; i++){
            int temp = v[i];
            /*Desloca elementos por gaps até encontrar o local correto para a[i]*/
            int j;
            for (j = i; j >= gap && v[j - gap] > temp; j -= gap) v[j] = v[j - gap];
            v[j] = temp; // Coloque temp na posição correta
        }
    }
    return 0;
}
int shellSortDecres(int v[], int n) {
    /* Inicia com um gap (h) e vai reduzindo */
    for (int gap = n/2; gap > 0; gap /= 2){
    /* Ordene por inserção com gaps para esse tamanho de gap*/
        for (int i = gap; i < n; i += 1){
            int temp = v[i];
            /*Desloca elementos por gaps até encontrar o local correto para a[i]*/
            int j;
            for (j = i; j >= gap && v[j - gap] < temp; j -= gap) v[j] = v[j - gap]; // SÓ MUDA AQUI
            v[j] = temp; // Coloque temp na posição correta
        }
    }
    return 0;
}

//knuth

int shellSort(int v[], int n) {
    int gap = 1;    //inicia como 1
    while(gap < n) gap = (gap*3)+1; //chega no maior caso de gap
    /*
    int gaps[32];
    int numGaps = 0;
    gaps[numGaps++] = 1;
    int k = 1;
    while (1) {
        // Formula: ((3^k)-1)/2
        long nextGap = ((long)pow(3, k) - 1)/2;
        if (nextGap >= n) break;
        gaps[numGaps++] = (int)nextGap;
        k++;
    }
    for (int g = numGaps - 1; g >= 0; g--) {
        int gap = gaps[g];
        ...
    */
    for (gap = gap/3; gap > 0; gap /= 3){
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

