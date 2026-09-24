typedef struct
{
   int valor;
   //char nome[30];
   //... (caso tenha outros campos)
} tipo_dado;

//Tipo nó
typedef struct no
{
   tipo_dado info;
   int fb; //Fator de balanceamento
   struct no *esq;
   struct no *dir;
} no;

//Tipo árvore binária (AB)
typedef struct no *tree;

tree Definir(void);
tree Criar_raiz(tipo_dado elem);
tree Busca(tree raiz, tipo_dado elem);
tree Busca_menor_a_direita(tree node);
void preOrdem(tree t);
int Altura(tree t);
tree Busca_insere(tree raiz, tipo_dado elem);
tree Remove_no(tree p);
tree Busca_remove(tree raiz, tipo_dado elem);
int calculaFB(tree t);
tree rotacaoEsquerda(tree raiz);
tree rotacaoDireita(tree raiz);
tree rotacaoCompostaEsquerda(tree raiz);
tree rotacaoCompostaDireita(tree raiz);
tree balancear(tree raiz);