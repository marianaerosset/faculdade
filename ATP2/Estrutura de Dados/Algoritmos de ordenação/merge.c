// A função recebe vetores crescentes v[p...q-1] e v[q...r-1] e rearranja v[p...r-1] em ordem crescente
void intercala(int p, int q, int r, int v[]){ 
    int i, j, k, *w;
    w = malloc((r-p) * sizeof (int));
    i = p; 
    j = q; 
    k = 0;
    while(i < q && j < r){
        if(v[i] <= v[j]) w[k++] = v[i++];
        else w[k++] = v[j++];
    }
    while(i < q) w[k++] = v[i++];
    while(j < r) w[k++] = v[j++];
    for(i = p; i < r; i++) v[i] = w[i-p];
    free(w);
}

void mergeSort(int p, int r, int v[]){ // p = início do vetor, q = meio do vetor, r = final do vetor
    if(p < r-1){
        int q = (p + r)/2;
        mergeSort(p, q, v);
        mergeSort(q, r, v);
        intercala(p, q, r, v);
    }
}

/*
Custo: no pior caso O(n*log n) 
EXEMPLO:
    3   1   0   4   5

*/