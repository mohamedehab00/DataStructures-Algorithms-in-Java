package dataStructures;

import nodes.BSTNode;

public class BST <T extends Comparable<? super T>> extends Tree{
    private BSTNode<T> root;

    public BST() {
        this.root = null;
    }

    public BST(BSTNode<T> root) {
        this.root = root;
    }

    public BST(BST<T> bst) throws RuntimeException{
        if (bst.getRoot() != null){
            this.root = copyUtility(this.getRoot(), bst.getRoot());
        }
        else {
            throw new RuntimeException("Copying a Null Value Tree");
        }
    }

    public BSTNode<T> copyUtility(BSTNode<T> newNode, BSTNode root){
        if(root != null){
            newNode = new BSTNode<T>((T) root.getValue());
            newNode.setLeft(copyUtility(newNode.getLeft(), root.getLeft()));
            newNode.setRight(copyUtility(newNode.getRight(), root.getRight()));
            return newNode;
        }
        else {
            return null;
        }
    }

    public BSTNode<T> getRoot() {
        return root;
    }

    private void setRoot(BSTNode<T> root) {
        this.root = root;
    }

    private BSTNode<T> insertUtility(BSTNode<T> root, BSTNode<T> nodeToBeInserted){
        if (root == null){
            return nodeToBeInserted;
        }
        else {
            T nodeValue = (T) nodeToBeInserted.getValue();
            T rootValue = (T) root.getValue();

            if (nodeValue.compareTo(rootValue) == 0 || nodeValue.compareTo(rootValue) == 1){
                root.setRight(insertUtility(root.getRight(), nodeToBeInserted));
                return root;
            }
            else {
                root.setLeft(insertUtility(root.getLeft(), nodeToBeInserted));
                return root;
            }
        }
    }

    public void insertNode(T value){
        BSTNode<T> bstNode = new BSTNode<>(value);
        if (this.getRoot() == null){
            this.root = bstNode;
        }
        else {
            insertUtility(this.root, bstNode);
        }
    }

    public BSTNode<T> leftmostNode(BSTNode<T> root){
        if (root.getLeft() == null){
            return root;
        }
        return leftmostNode(root.getLeft());
    }

    public BSTNode<T> delLeftmostNode(BSTNode<T> root){
        if (root.getLeft() == null){
            return deleteSingleNode(root);
        }
        return delLeftmostNode(root.getLeft());
    }

    public BSTNode<T> deleteSingleNode(BSTNode<T> node){
        if(node == null){
            return null;
        }
        else{
            BSTNode<T> Left = node.getLeft();
            BSTNode<T> Right = node.getRight();

            if (Left == null && Right == null){
                node = null;
            }
            else if(Left != null && Right == null){
                node = Left;
            }
            else if(Left == null && Right != null){
                node = Right;
            }
            else{
                BSTNode<T> newParent = leftmostNode(node.getRight());

                node.getRight().setLeft(delLeftmostNode(node.getRight()));

                newParent.setLeft(node.getLeft());
                newParent.setRight(node.getRight());

                return newParent;
            }
            return node;
        }
    }

    public BSTNode<T> deleteUtility(BSTNode<T> root, T value){
        if(root == null){
            return null;
        }
        if(((T)root.getValue()).compareTo(value) == 0){
            root = deleteSingleNode(root);
        }
        else if (((T)root.getValue()).compareTo(value) == 1){
            root.setLeft(deleteUtility(root.getLeft(), value));
        }
        else {
            root.setRight(deleteUtility(root.getRight(), value));
        }
        return root;
    }

    public void deleteNode(T value){
        this.root = deleteUtility(this.root, value);
    }

    private void inOrderUtility(BSTNode root){
        if(root != null){
            inOrderUtility(root.getLeft());

            System.out.print(root.getValue()+" ");

            inOrderUtility(root.getRight());
        }
    }

    @Override
    public void inOrderTraversal() {
        inOrderUtility(this.root);
    }

    private void preOrderUtility(BSTNode root){
        if(root != null){
            System.out.print(root.getValue()+" ");

            preOrderUtility(root.getLeft());

            preOrderUtility(root.getRight());
        }
    }

    @Override
    public void preOrderTraversal() {
        preOrderUtility(this.root);
    }

    private void postOrderUtility(BSTNode root){
        if(root != null){
            postOrderUtility(root.getLeft());

            postOrderUtility(root.getRight());

            System.out.print(root.getValue()+" ");
        }
    }

    @Override
    public void postOrderTraversal() {
        postOrderUtility(this.root);
    }

    public void clear(){
        this.root = null;
    }

    public BSTNode<T> searchUtility(BSTNode<T> root, T value){
        if(root == null){
            return null;
        }
        if(((T)root.getValue()).compareTo(value) == 0){
            return root;
        }
        else if (((T)root.getValue()).compareTo(value) == 1){
            return searchUtility(root.getLeft(), value);
        }
        else {
            return searchUtility(root.getRight(), value);
        }
    }

    public BSTNode<T> search(T value){
        return searchUtility(this.root, value);
    }
}
