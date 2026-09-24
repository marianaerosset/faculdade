#ifndef TAD_RB_H
#define TAD_RB_H

#include <stdio.h>
#include <stdlib.h>

typedef enum { RED, BLACK } Color;

typedef struct Node {
    int key;
    Color color;
    struct Node *left;
    struct Node *right;
    struct Node *parent;
} Node;

/* No sentinela global (representa todas as folhas NIL). */
extern Node NIL_NODE;
extern Node *NIL;

#endif
