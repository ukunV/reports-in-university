/*
*	Operating System Lab
*	    Lab2 (Synchronization)
*	    Student id : 32163006 / 32164420
*	    Student name : �̰ǿ� / ������
*
*   lab2_bst.c :
*       - thread-safe bst code.
*       - coarse-grained, fine-grained lock code
*
*   Implement thread-safe bst for coarse-grained version and fine-grained version.
*/

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <pthread.h>
#include <string.h>
#include <errno.h>
#include "lab2_sync_types.h"

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER; //mutex variable

/*
 * TODO
 *  Implement funtction which traverse BST in in-order
 *
 *  @param lab2_tree *tree  : bst to print in-order.
 *  @return                 : status (success or fail)
 */
int lab2_node_print_inorder(lab2_tree* tree) {
    // You need to implement lab2_node_print_inorder function.
    if (tree->root == NULL) {
        return LAB2_SUCCESS; // root�� ��� �ִ� ��� �̸� ��ȯ (����Լ����� ���)
    }

    else {
        lab2_tree* Templeft = (lab2_tree*)malloc(sizeof(lab2_tree));
        Templeft->root = tree->root->left; // �ӽ� Ʈ���� ����, ����� ����
        lab2_node_print_inorder(Templeft);

        //        printf(" %d ", tree->root->key);

        lab2_tree* Tempright = (lab2_tree*)malloc(sizeof(lab2_tree));
        Tempright->root = tree->root->right;
        lab2_node_print_inorder(Tempright);
    }
}

/*
 * TODO
 *  Implement function which creates struct lab2_tree
 *  ( refer to the ./include/lab2_sync_types.h for structure lab2_tree )
 *
 *  @return                 : bst which you created in this function.
 */
lab2_tree* lab2_tree_create() {
    // You need to implement lab2_tree_create function.
    lab2_tree* NewTree = (lab2_tree*)malloc(sizeof(lab2_tree));
    NewTree->root = NULL; //NewTree�� ��Ʈ�� NULL�� �ʱ�ȭ
    return NewTree;
}

/*
 * TODO
 *  Implement function which creates struct lab2_node
 *  ( refer to the ./include/lab2_sync_types.h for structure lab2_node )
 *
 *  @param int key          : bst node's key to creates
 *  @return                 : bst node which you created in this function.
 */
lab2_node* lab2_node_create(int key) {
    // You need to implement lab2_node_create function.
    lab2_node* NewNode = (lab2_node*)malloc(sizeof(lab2_node)); // ���ο� ��� �����Ҵ� 
    NewNode->key = key;
    NewNode->left = NULL;
    NewNode->right = NULL;          // ����� left, right�� NULL�� �ʱ�ȭ
    pthread_mutex_init(&NewNode->mutex, NULL); //����ü�� ������ �ʱ�ȭ 
    return NewNode;
}

/*
 * TODO
 *  Implement a function which insert nodes from the BST.
 *
 *  @param lab2_tree *tree      : bst which you need to insert new node.
 *  @param lab2_node *new_node  : bst node which you need to insert.
 *  @return                 : satus (success or fail)
 */
int lab2_node_insert(lab2_tree* tree, lab2_node* new_node) {
    // You need to implement lab2_node_insert function.
    lab2_node* p = tree->root; // �θ��带 ��Ʈ�� �ʱ�ȭ
    lab2_node* q = 0; // �θ��� �θ� ��� 

    if (p == NULL) {           // ��Ʈ�� ����ִ� ���
        tree->root = new_node; // �� ��带 ��Ʈ�� ���� 
        return LAB2_SUCCESS;
    }

    else {
        while (p) { // �����ؾ��� ��ġ �˻�
            q = p;
            if (new_node->key == p->key) {
                return LAB2_ERROR;
            }
            else if (new_node->key < p->key) {
                p = p->left;
            }
            else {
                p = p->right;
            }
        } // p�� �����Ϳ� new node�� �����͸� ���ϸ� �˻�

        // q�� �ܸ����, p�� NULL�� ��
        if (new_node->key < q->key) {
            q->left = new_node;
        }  // new node�� �����Ͱ� q����� �����ͺ��� ������ q�� �����ڽĿ� ��带 �߰�
        else {
            q->right = new_node;
        }  // new node�� �����Ͱ� q����� �����ͺ��� ũ�� q�� �������ڽĿ� ��带 �߰�
    }
    return LAB2_SUCCESS;
}

/*
 * TODO
 *  Implement a function which insert nodes from the BST in fine-garined manner.
 *
 *  @param lab2_tree *tree      : bst which you need to insert new node in fine-grained manner.
 *  @param lab2_node *new_node  : bst node which you need to insert.
 *  @return                     : status (success or fail)
 */
int lab2_node_insert_fg(lab2_tree* tree, lab2_node* new_node) {
    // You need to implement lab2_node_insert_fg function.
    lab2_node* pp = NULL;        // �θ��� �θ��带 NULL�� �ʱ�ȭ
    lab2_node* p = tree->root;   // �θ��带 ��Ʈ�� �ʱ�ȭ
    
    if (p == NULL) {   // Ʈ���� ����ִ� ���
        tree->root = new_node;  // new node�� ��Ʈ�� ����
        return LAB2_SUCCESS;
    }
    
    else {
        while (p)  // �����ؾ��� ��ġ �˻�
        {
            pp = p;
            if (new_node->key < p->key) {
                p = p->left;
            }

            else if (new_node->key == p->key)
            {
                return LAB2_ERROR;
            }

            else {
                p = p->right;
            }
        }
    } // p�� �����Ϳ� new node�� �����͸� ���ϸ� �˻�
    // q�� �ܸ����, p�� NULL�� ��

    pthread_mutex_lock(&mutex);  // new node�� �����ϴ� �������� �ٸ� ��尡 ���Ե��� �ʵ��� lock
    if (new_node->key < pp->key) {
            pp->left = new_node;
    }  // new node�� �����Ͱ� q����� �����ͺ��� ������ q�� �����ڽĿ� ��带 �߰�
    else {
            pp->right = new_node;
    } // new node�� �����Ͱ� q����� �����ͺ��� ũ�� q�� �������ڽĿ� ��带 �߰�

    pthread_mutex_unlock(&mutex);  // new node�� ������ �������Ƿ� lock ����
    return LAB2_SUCCESS;
}


/*
 * TODO
 *  Implement a function which insert nodes from the BST in coarse-garined manner.
 *
 *  @param lab2_tree *tree      : bst which you need to insert new node in coarse-grained manner.
 *  @param lab2_node *new_node  : bst node which you need to insert.
 *  @return                     : status (success or fail)
 */
int lab2_node_insert_cg(lab2_tree* tree, lab2_node* new_node) {
    // You need to implement lab2_node_insert_cg function.
    pthread_mutex_lock(&mutex); // lock�� ������ �Լ� ��ü�� ũ�� ����
    lab2_node* pp = NULL;    // �θ��� �θ��带 NULL�� �ʱ�ȭ
    lab2_node* p = tree->root; // �θ��带 Ʈ���� ��Ʈ�� �ʱ�ȭ

    if (p == NULL)  // Ʈ���� ����ִ� ���
    {
        tree->root = new_node;  // new node�� Ʈ���� ��Ʈ�� ������ ��
        pthread_mutex_unlock(&mutex); // lock ����
        return LAB2_SUCCESS;
    }

    else
    {
        while (p)  // �����ؾ��� ��ġ �˻�
        {
            pp = p;
            if (new_node->key < p->key)
            {
                p = p->left;
            }

            else if (new_node->key == p->key)
            {
                pthread_mutex_unlock(&mutex);  // ���� �����Ͱ� �ִ� ��� lock ����
                return LAB2_ERROR;
            }

            else
            {
                p = p->right;
            }
        }   // p�� �����Ϳ� new node�� �����͸� ���ϸ� �˻�
        // q�� �ܸ����, p�� NULL�� ��

        if (new_node->key < pp->key)
        {
            pp->left = new_node;  // new node�� �����Ͱ� q����� �����ͺ��� ������ q�� �����ڽĿ� ��带 �߰�
        }

        else
        {
            pp->right = new_node;  // new node�� �����Ͱ� q����� �����ͺ��� ũ�� q�� �������ڽĿ� ��带 �߰�
        }
    }
    pthread_mutex_unlock(&mutex); // �Լ� ������ lock ����
    return LAB2_SUCCESS;
}


/*
 * TODO
 *  Implement a function which remove nodes from the BST.
 *
 *  @param lab2_tree *tree  : bst tha you need to remove node from bst which contains key.
 *  @param int key          : key value that you want to delete.
 *  @return                 : status (success or fail)
 */
int lab2_node_remove(lab2_tree* tree, int key) {
    // You need to implement lab2_node_remove function.

    lab2_node* p = tree->root; //�θ��带 ��Ʈ�� �ʱ�ȭ 
    lab2_node* q = NULL; //�θ��� �θ��带 NULL�� �ʱ�ȭ

    if (p == NULL) {
        return LAB2_ERROR; // Ʈ���� ��������� ���� ����
    }

    while (p != NULL && p->key != key) { // ���� ��ġ Ž��
        q = p;
        if (p->key < key) { // ã�� �����Ͱ� p�� �����ͺ��� ū ���
            p = p->right;   // p�� p ����� ������ �ڽĳ��� �̵�
        }

        else if (p->key > key) { // ã�� �����Ͱ� p�� �����ͺ��� ���� ��� 
            p = p->left;    // p�� p ����� ���� �ڽĳ��� �̵�
        }
    }

    if (p->left != NULL && p->right != NULL) { // p�� �ڽ��� �� �� ���� ���
        lab2_node* s = p->left; // s��带 ���� �ڽ�����
        lab2_node* ps = p; // ps�� p����

        while (s->right != NULL) { //���� ����Ʈ���� �ִ밪 ã��
            ps = s;
            s = s->right;
        }
        p->key = s->key;
        p = s;
        q = ps;
    }

    lab2_node* temp = (lab2_node*)malloc(sizeof(lab2_node)); // temp ��� ���� �Ҵ�

    if (p->left == NULL) { // p�� ���� �ڽ��� ���� ���
        temp = p->right; // p�� ������ �ڽ� ��带 temp��
    }
    else {
        temp = p->left;  // �ݴ� ���, p�� ���� �ڽĳ�带 temp��
    }

    if (p == tree->root) { // p�� ��Ʈ�� ���
        tree->root = temp;  // temp�� Ʈ���� ��Ʈ��
        lab2_node_delete(p); // p��� ����
    }
    else { // p�� ��Ʈ�� �ƴ� ���
        if (p == q->left) {  // p�� q�� �����ڽ��� ���
            q->left = temp;  // temp�� q�� �����ڽ�����
            lab2_node_delete(p); // p��� ����
        }
        else { // �ݴ� ���
            q->right = temp;  // temp�� q�� �������ڽ�����
            lab2_node_delete(p);  // p��� ����
        }
    }

    return LAB2_SUCCESS;
}


/*
 * TODO
 *  Implement a function which remove nodes from the BST in fine-grained manner.
 *
 *  @param lab2_tree *tree  : bst tha you need to remove node in fine-grained manner from bst which contains key.
 *  @param int key          : key value that you want to delete.
 *  @return                 : status (success or fail)
 */


int lab2_node_remove_fg(lab2_tree* tree, int key) {
    // You need to implement lab2_node_remove_fg function.
    
    lab2_node* pp = NULL;  // �θ��� �θ��带 NULL�� �ʱ�ȭ
    lab2_node* p = tree->root; // p�� Ʈ���� ��Ʈ�� �ʱ�ȭ

    if (p == NULL) {   // �� Ʈ���� ���
        return LAB2_ERROR;  // ���� ����
    }

    while (p != NULL && p->key != key) {  // ���� ��ġ Ž��
        pp = p;
        if (p->key < key) {  // Ž�� �����Ͱ� p�� �����ͺ��� ū ���
            p = p->right;  // p�� p�� ������ �ڽ�����
        }

        else if (p->key > key) {  // Ž�� �����Ͱ� p�� �����ͺ��� ���� ���
            p = p->left;  // p�� p�� ���� �ڽ�����
        }
    }

    pthread_mutex_lock(&mutex);  // �ٸ� ���� ��� �����Ͱ� ������ �ʵ��� lock
    if (p->left != NULL && p->right != NULL) {
        lab2_node* s = p->left;  // s�� p�� �����ڽ�����
        lab2_node* ps = p;  // ps�� p ����

        while (s->right != NULL) {  // ���� ����Ʈ���� �ִ� Ž��
            ps = s;
            s = s->right;
        }
        p->key = s->key;
        p = s;
        pp = ps;
    }


    lab2_node* temp = (lab2_node*)malloc(sizeof(lab2_node));  // temp��� ���� �Ҵ�

    if (p->left == NULL) {  // p�� ���� �ڽ��� ���� ���
        temp = p->right;  // p�� ������ �ڽ� ��带 temp��
    }

    else {  // �ݴ� ���
        temp = p->left; // p�� ���� �ڽĳ�带 temp��
    }

    if (p == tree->root) {  // p�� ��Ʈ�� ���
        tree->root = temp;  // temp�� Ʈ���� ��Ʈ��
    }

    else {  //�ݴ� ���
        if (p == pp->left){  // p�� pp�� ���� ���� ������
            pp->left = temp;  // temp�� pp�� ���ʳ���
        }
        // �ݴ� ���
        else pp->right = temp; // temp�� pp�� �����ʳ���
    }
    lab2_node_delete(p);  // p ��� ����
    pthread_mutex_unlock(&mutex); // lock ����
    return LAB2_SUCCESS;
}

/*
 * TODO
 *  Implement a function which remove nodes from the BST in coarse-grained manner.
 *
 *  @param lab2_tree *tree  : bst tha you need to remove node in coarse-grained manner from bst which contains key.
 *  @param int key          : key value that you want to delete.
 *  @return                 : status (success or fail)
 */
int lab2_node_remove_cg(lab2_tree* tree, int key) {
    // You need to implement lab2_node_remove_cg function.
    pthread_mutex_lock(&mutex); // lock ������ �Լ� ��ü�� ����
    lab2_node* pp = NULL;  // �θ��� �θ��带  NULL�� �ʱ�ȭ
    lab2_node* p = tree->root; // �θ��带 Ʈ���� ��Ʈ�� �ʱ�ȭ

    if (p == NULL) {  // �� Ʈ���� ���
        pthread_mutex_unlock(&mutex);  // lcok ����
        return LAB2_ERROR;  // ���� ����
    }

    while (p != NULL && p->key != key) {  // ���� ��ġ Ž��
        pp = p;
        if (p->key < key) {  // Ž�� �����Ͱ� p�� �����ͺ��� ū ���
            p = p->right; // p�� p�� ������ �ڽ�����
        }

        else if (p->key > key) {  // Ž�� �����Ͱ� p�� �����ͺ��� ���� ���
            p = p->left;  // p�� p�� ���� �ڽ�����
        }
    }

    if (p->left != NULL && p->right != NULL) {
        lab2_node* s = p->left;  // s�� p�� �����ڽ�����
        lab2_node* ps = p;       // ps�� p ����

        while (s->right != NULL) {  // ���� ����Ʈ���� �ִ� Ž��
            ps = s;
            s = s->right;
        }
        p->key = s->key;
        p = s;
        pp = ps;
    }

    lab2_node* temp = (lab2_node*)malloc(sizeof(lab2_node));  // temp��� ���� �Ҵ�

    if (p->left == NULL) {  // p�� ���� �ڽ��� ���� ���
        temp = p->right;  // p�� ������ �ڽ��� temp����
    }

    else {  // �ݴ� ���
        temp = p->left;  // p�� ���� �ڽ��� temp��
    }

    if (p == tree->root) { // p�� ��Ʈ�� ���
        tree->root = temp; // temp�� Ʈ���� ��Ʈ��
    }

    else {  // �ݴ� ���
        if (p == pp->left) {  // p�� pp�� ���ʳ��� ������
            pp->left = temp;  // temp�� pp�� ���ʳ���
        }

        else pp->right = temp;  // �ݴ���, temp�� pp�� ������ ����
    }
    lab2_node_delete(p);  // p ��� ����
    pthread_mutex_unlock(&mutex); // lock ����
    return LAB2_SUCCESS;
}


/*
 * TODO
 *  Implement function which delete struct lab2_tree
 *  ( refer to the ./include/lab2_sync_types.h for structure lab2_node )
 *
 *  @param lab2_tree *tree  : bst which you want to delete.
 *  @return                 : status(success or fail)
 */ 
void lab2_tree_delete(lab2_tree* tree) {
    // You need to implement lab2_tree_delete function.
    free(tree);
    tree->root = NULL;
    // tree�� �����Ҵ� ����
}

/*
 * TODO
 *  Implement function which delete struct lab2_node
 *  ( refer to the ./include/lab2_sync_types.h for structure lab2_node )
 *
 *  @param lab2_tree *tree  : bst node which you want to remove.
 *  @return                 : status(success or fail)
 */
void lab2_node_delete(lab2_node* node) {
    // You need to implement lab2_node_delete function.
    free(node);
    node = NULL;
    // node�� �����Ҵ� ����
}