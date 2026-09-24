#include "rb_validate.h"

static int check_properties(Node *node) {
    if (node == NIL) return 1;

    if (node->color == RED) {
        if (node->left->color == RED || node->right->color == RED) {
            return -1;
        }
    }

    int left_bh = check_properties(node->left);
    int right_bh = check_properties(node->right);

    if (left_bh == -1 || right_bh == -1 || left_bh != right_bh) {
        return -1;
    }

    if (node->color == BLACK) {
        return left_bh + 1;
    } else {
        return left_bh;
    }
}

int is_valid_rb(Node *root) {
    if (root != NIL && root->color == RED) return 0;

    return check_properties(root) != -1;
}
