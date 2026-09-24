#include "tad_rb.h"
#include "rb_insert.h"

void left_rotate(Node **root, Node *x) {
    Node *y = x->right;
    x->right = y->left;
    
    if (y->left != NIL)
        y->left->parent = x;
        
    y->parent = x->parent;
    
    if (x->parent == NIL)
        *root = y;
    else if (x == x->parent->left)
        x->parent->left = y;
    else
        x->parent->right = y;
        
    y->left = x;
    x->parent = y;
}

void right_rotate(Node **root, Node *y) {
    Node *x = y->left;
    y->left = x->right;
    
    if (x->right != NIL)
        x->right->parent = y;
        
    x->parent = y->parent;
    
    if (y->parent == NIL)
        *root = x;
    else if (y == y->parent->right)
        y->parent->right = x;
    else
        y->parent->left = x;
        
    x->right = y;
    y->parent = x;
}

void insert_fixup(Node **root, Node *z) {
    while (z->parent->color == RED) {
        if (z->parent == z->parent->parent->left) {
            Node *y = z->parent->parent->right; /* tio */
            if (y->color == RED) {
                /* Caso 1 */
                z->parent->color = BLACK;
                y->color = BLACK;
                z->parent->parent->color = RED;
                z = z->parent->parent;
            } else {
                if (z == z->parent->right) {
                    /* Caso 2 */
                    z = z->parent;
                    left_rotate(root, z);
                }
                /* Caso 3 */
                z->parent->color = BLACK;
                z->parent->parent->color = RED;
                right_rotate(root, z->parent->parent);
            }
        } else {
            Node *y = z->parent->parent->left;
            
            if (y->color == RED) {
                z->parent->color = BLACK;
                y->color = BLACK;
                z->parent->parent->color = RED;
                z = z->parent->parent;
            } else {
                if (z == z->parent->left) {
                    z = z->parent;
                    right_rotate(root, z);
                }
                z->parent->color = BLACK;
                z->parent->parent->color = RED;
                left_rotate(root, z->parent->parent);
            }
        }
    }
    (*root)->color = BLACK;
}

void rb_insert(Node **root, int key) {
    Node *z = (Node *)malloc(sizeof(Node));
    z->key = key;
    z->left = NIL;
    z->right = NIL;
    z->color = RED;

    Node *y = NIL;
    Node *x = *root;

    while (x != NIL) {
        y = x;
        if (z->key < x->key)
            x = x->left;
        else
            x = x->right;
    }

    z->parent = y;
    if (y == NIL) {
        *root = z;
    } else if (z->key < y->key) {
        y->left = z;
    } else {
        y->right = z;
    }

    // chama função de correção para restaurar as propriedades
    insert_fixup(root, z); 
}