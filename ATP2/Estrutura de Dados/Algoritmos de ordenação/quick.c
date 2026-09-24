int separa(int p, int r, int v[]){
    int c, j, k, t;
    c = v[r];
    j = p;
    for(k = p; k < r; k++){
        if(v[k] <= c){
            t = v[j];
            v[j] = v[k];
            v[k] = t;
            j++;
        }
    }
    v[r] = v[j];
    v[j] = c;
    return j;
}

//ou 

int Separa (int p, int r, int v[]) {
    int c, j, k, t;
    c = v[r]; j = p; k = r - 1;
    while (j <= k) {
        if (v[j] <= c) j++;
        else if (v[k] > c) k--;
        else {
            t = v[j]; v[j] = v[k]; v[k] = t;
            j++;
            k--;
        }
    }
    v[r] = v[j]; 
    v[j] = c;
    return j;
}

void quickSort(int p, int r, int v[]){
    int j;
    if(p < r){
        j = separa(p, r, v);
        quickSort(p, j-1, v);
        quickSort(j+1, r, v);
    }
}

/*
Custo: 
    -Melhor e caso médio: O(n log n); 
    -Pior caso: O(n^2) 
EXEMPLO:
    3   1   0   4   5

*/