//Tipo nó
typedef struct no{
    int info;
    struct no *esq, *dir;
} no;

//Tipo árvore binária
typedef no* tree;

//
void Definir(tree t){
    t = NULL;
}

//
int Vazia(tree t){
    return t == NULL;
}

void Criar_raiz(tree t, int elem){
    tree raiz = malloc(sizeof(no));
    if(!raiz){
        printf("Memória insuficiente.\n");
        return;
    }

    raiz->esq = NULL;
    raiz->dir = NULL;
    raiz->info = elem;
    t = raiz;
}

//Retorna a altura (profundidade) da árvore
int Altura(tree t){
    if(t == NULL) return 0;
    int altE= Altura(t->esq);
    int altD = Altura(t->dir);
    if(altE > altD) return altE + 1;
    return altD + 1;
    //altura = max(altE, altD) + 1
}
