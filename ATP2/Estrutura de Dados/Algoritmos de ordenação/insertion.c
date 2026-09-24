void insertion(int v[], int n){ //n = tamanho do vetor
    int i, j, temp;
    for(j = 1; j < n; j++){ //assume que o primeiro já está ordenado
        temp = v[j];
        //compara com o elemento anterior e, se for maior, o leva para frente até achar a posição do v[j]
        for(i = j-1; i >= 0 && v[i] > temp; i--) v[i+1]=v[i];
        v[i+1] = temp;
    }
}

/*
Custo: 
    -Melhor caso: 2(n − 1)
    -Pior caso: (n^2)/2 − n/2
EXEMPLO:
    29  10  14  37  13

        i = 0, j = 1, temp = 10
        v[0] = 29 > 10
        v[1] = v[0] = 29

    29  29  14  37  13

        i = -1, j = 1, temp = 10
        v[0] = 10

    10  29  14  37  13

        i = 1, j = 2, temp = 14
        v[1] = 29 > 14
        v[2] = v[1] = 29

    10  29  29  37  13
        i = 0, j = 2, temp = 14

        v[0] = 10 >! 14
        v[1] = 14

    10  14  29  37  13

        i = 2, j = 3, temp = 37
        v[2] = 29 >! 37
        v[2] = 37

    10  14  29  37  13

        i = 3, j = 4, temp = 13
        v[3] = 37 > 13
        v[4] = v[3] = 37

    10  14  29  37  37

        i = 2, j = 4, temp = 13
        v[2] = 29 > 13
        v[3] = v[2] = 29
        
    10  14  29  29  37

        i = 1, j = 4, temp = 13
        v[1] = 14 > 13
        v[2] = v[1] = 14

    10  14  14  29  37

        i = 0, j = 4, temp = 13
        v[0] = 10 >! 13
        v[1] = 13

    10  13  14  29  37
*/
