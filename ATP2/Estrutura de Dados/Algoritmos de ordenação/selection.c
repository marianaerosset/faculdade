void selection(int v[], int n){ //n = tamanho do vetor
    int i, j, temp, min;
    for(i = 0; i < n-1; i++){   //primeiro a comparar
        min = i;    //assume a menor posição ainda a ser ordenada como a menor
        for(j = i+1; j < n; j++){   // compara o menor atual e o próximo número do vetor a ser percorrido
            if(v[j]<v[min]) min = j;    // vai mudando qual a posição de v em que está o menor
        }
        if(i != min){   //confere se a troca é necessária
            temp = v[i];    //armazena o número da posição a ser substituída (menor a ser ordenada)
            v[i] = v[min];  //faz a troca
            v[min] = temp;  //coloca o substituido na posição em que estava o menor a ser ordenado
        }
    }
}

/*
Custo: O(n^2) 
EXEMPLO:
    3   1   0   4   5

        i = 0
        j = 1 -> 2 -> 3 -> 4
        min = 0 -> 1 -> 2 -> 2
        temp = v[0] = 3
        v[0] = v[2] = 0
        v[2] = temp = 3

    0   1   3   4   5

        i = 1
        j = 2 -> 3 -> 4
        min = 1 -> 1 -> 1

    0   1   3   4   5

        i = 2
        j = 3 -> 4
        min = 2 -> 2

    0   1   3   4   5

        i = 3
        j = 4
        min = 3

    0   1   3   4   5
*/