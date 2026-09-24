int buscaBin(int x, int n, int v[]){
    int e, m, d; //esquerda, meio, direita
    e = -1;
    d = n;
    while(e < d-1){
        m = (e+d)/2;
        if(v[m] < x) e = m;
        else d = m;
    }
    return d;
}

//recursivamente
int buscaBinR(int x, int e, int d, int v[]){
    if(e == d-1) return d;
    else{
        int m = (e+d)/2;
        if(v[m] < x) return buscaBinR(x, m, d, v);
        else return buscaBinR(x, e, m, v);
    }
}

/*Custo: log2 n
EXEMPLO:
    3   1   0   4   5

*/