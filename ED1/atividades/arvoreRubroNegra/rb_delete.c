#include "rb_delete.h"
#include "rb_insert.h"

// encontra o menor nó de uma subárvore
Node* rb_minimum(Node *x) {
    while (x->left != NIL) {
        x = x->left;
    }
    return x;
}

// substitui uma subárvore por outra
void rb_transplant(Node **root, Node *u, Node *v) {
    if (u->parent == NIL) {
        *root = v;
    } else if (u == u->parent->left) {
        u->parent->left = v;
    } else {
        u->parent->right = v;
    }
    v->parent = u->parent;
}

// correção após a remoção
void delete_fixup(Node **root, Node *x) {
    while (x != *root && x->color == BLACK) {
        if (x == x->parent->left) {
            Node *w = x->parent->right;
            
            if (w->color == RED) {
                w->color = BLACK;
                x->parent->color = RED;
                left_rotate(root, x->parent);
                w = x->parent->right;
            }
            if (w->left->color == BLACK && w->right->color == BLACK) {
                w->color = RED;
                x = x->parent;
            } else {
                if (w->right->color == BLACK) { 
                    w->left->color = BLACK;
                    w->color = RED;
                    right_rotate(root, w);
                    w = x->parent->right;
                }
                w->color = x->parent->color;
                x->parent->color = BLACK;
                w->right->color = BLACK;
                left_rotate(root, x->parent);
                x = *root;
            }
        } else {
            Node *w = x->parent->left;
            
            if (w->color == RED) {
                w->color = BLACK;
                x->parent->color = RED;
                right_rotate(root, x->parent);
                w = x->parent->left;
            }
            if (w->right->color == BLACK && w->left->color == BLACK) {
                w->color = RED;
                x = x->parent;
            } else {
                if (w->left->color == BLACK) {
                    w->right->color = BLACK;
                    w->color = RED;
                    left_rotate(root, w);
                    w = x->parent->left;
                }
                w->color = x->parent->color;
                x->parent->color = BLACK;
                w->left->color = BLACK;
                right_rotate(root, x->parent);
                x = *root;
            }
        }
    }
    x->color = BLACK;
}

void rb_delete(Node **root, Node *z) {
    if (z == NIL) return;

    Node *y = z;
    Node *x;
    Color y_original_color = y->color;

    if (z->left == NIL) {
        x = z->right;
        rb_transplant(root, z, z->right);
    } else if (z->right == NIL) {
        x = z->left;
        rb_transplant(root, z, z->left);
    } else {
        y = rb_minimum(z->right);
        y_original_color = y->color;
        x = y->right;
        
        if (y->parent == z) {
            x->parent = y; 
        } else {
            rb_transplant(root, y, y->right);
            y->right = z->right;
            y->right->parent = y;
        }
        
        rb_transplant(root, z, y);
        y->left = z->left;
        y->left->parent = y;
        y->color = z->color;
    }

    if (y_original_color == BLACK) {
        delete_fixup(root, x);
    }
    free(z);
}