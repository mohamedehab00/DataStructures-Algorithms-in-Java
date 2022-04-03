package nodes;

public class BSTNode <T> extends Node {
    protected BSTNode<T> left;
    protected BSTNode<T> right;

    public BSTNode(T value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    public BSTNode(T value, BSTNode<T> left, BSTNode<T> right) {
        super(value);
        this.left = left;
        this.right = right;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }
}
