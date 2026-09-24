//pos = low + ((high-low)/(v[high]-v[low]))*(x-v[low])

int buscaInterpolacao(int arr[], int n, int x) {
int low = 0, high = n - 1;
    while (low <= high && x >= arr[low] && x <= arr[high]) {
        int pos = low + ((double)(high - low) / (arr[high] - arr[low]) * (x - arr[low]));
        // Se o valor está na posição pos
        if (arr[pos] == x) return pos;
        // Ajusta os limites de busca
        if (arr[pos] < x) low = pos + 1; // Continua na metade superior
        else high = pos - 1; // Continua na metade inferior
    }
    return -1; // Retorna -1 se o valor não for encontrado
}

int buscaInterpolacaoR(int arr[], int inicio, int fim, int x) {
    if (inicio <= fim && x >= arr[inicio] && x <= arr[fim]) {
        if (arr[inicio] == arr[fim]) {
            if (arr[inicio] == x) return inicio;
            return -1;
        }
        int pos = inicio + (((double)(fim - inicio) / (arr[fim] - arr[inicio])) * (x - arr[inicio]));
        if (arr[pos] == x) return pos;
        if (arr[pos] < x) return buscaInterpolacaoR(arr, pos + 1, fim, x);
        if (arr[pos] > x) return buscaInterpolacaoR(arr, inicio, pos - 1, x);
    }
    return -1;
}

/*Custo: 
    -Melhor e caso médio (igualmente distribuídos): O(log log n)
    -Pior caso (desigualmente distribuídos): O(n) 
EXEMPLO:
    3   1   0   4   5

*/