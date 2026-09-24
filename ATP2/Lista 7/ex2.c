void selection(int v[], int n){
    int i, j, min, temp;
    for(i=0; i<n-1; i++){
        min = i;
        for(j=i+1; j<n; j++) if(v[j]<v[min]) min = j;
        if(i != min){
            temp = v[i];
            v[i] = v[min];
            v[min] = temp;
        }
    }
}

void selectionDecres(int v[], int n){
    int i, j, max, temp;
    for(i=0; i<n-1; i++){
        max = i;
        for(j=i+1; j<n; j++) if(v[j]>v[max]) max = j;
        if(i != max){
            temp = v[i];
            v[i] = v[max];
            v[max] = temp;
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