package dataStructures;

import nodes.Node;

public abstract class List<T>{

    protected Node<T> Head;
    protected Node<T> Tail;

    protected Node<T> getHead() { return this.Head; }

    protected void setHead(Node<T> head) {
        this.Head = head;
    }


    protected Node<T> getTail() {
        return this.Tail;
    }

    protected void setTail(Node<T> tail) {
        this.Tail = tail;
    }

    public abstract void insertAtHead(T value);
    public abstract void insertAtTail(T value);
    public abstract void insertAtIdx(T value, int idx);
    public abstract void deleteAtHead();
    public abstract void deleteAtTail();
    public abstract void deleteAtIdx(int idx);

    public abstract Node search(T value);
    public abstract void traverse();
}
