package dataStructures;

import nodes.LLNode;
import nodes.Node;

public class LinkedList<T> extends List<T>{

    public LinkedList() {
        this.Head = null;
        this.Tail = null;
    }

    public LinkedList(LinkedList<T> original){
        this.Head = this.copy(original);
    }

    @Override
    public void insertAtHead(T value) {
        LLNode<T> llNode = new LLNode<T>(value);
        if(this.Head == null) {
            this.Head = llNode;
            this.Tail = this.Head;
        }
        else{
            LLNode<T> prevHead = (LLNode<T>) this.Head;
            LLNode<T> currHead = llNode;

            currHead.setNext(prevHead);

            this.Head = currHead;
        }
    }

    @Override
    public void insertAtTail(T value) {
        LLNode<T> llNode = new LLNode<T>(value);
        if(this.Head == null) {
            this.Head = llNode;
            this.Tail = this.Head;
        }
        else{
            LLNode<T> currTail = (LLNode<T>) this.Tail;
            currTail.setNext(llNode);

            this.Tail = currTail.getNext();
        }
    }

    @Override
    public void insertAtIdx(T value, int idx) {
        if (idx < 0){
            throw new RuntimeException("Index must be in range");
        }
        LLNode<T> llNode = new LLNode<T>(value);
        if (idx == 0){
            this.insertAtHead(value);
        }
        else{
            LLNode<T> curr = (LLNode<T>) this.Head;
            for (int i = 0; i < idx-1 && curr != null; i++) {
                curr = curr.getNext();
            }
            if (curr != null){
                try {
                    LLNode<T> nextNextNode = curr.getNext();
                    curr.setNext(llNode);
                    curr.getNext().setNext(nextNextNode);
                }
                catch (Exception e){
                    this.insertAtTail(value);
                }
            }
            else {
                throw new NullPointerException();
            }
        }
    }

    @Override
    public void deleteAtHead() {
        if (this.Head == null){
            throw new RuntimeException("No More Nodes");
        }

        if (this.Head == this.Tail){
            this.Head = this.Tail = null;
        }
        else {
            LLNode<T> currHead = (LLNode<T>) this.Head;
            this.Head = currHead.getNext();
        }
    }

    @Override
    public void deleteAtTail() {
        if (this.Head == null){
            throw new RuntimeException("No More Nodes");
        }

        if (this.Head == this.Tail){
            this.Head = this.Tail = null;
        }
        else {
            LLNode<T> curr = (LLNode<T>) this.Head;
            while (curr.getNext().getNext() != null){
                curr = curr.getNext();
            }
            this.Tail = curr;

            LLNode<T> currTail = (LLNode<T>) this.Tail;
            currTail.setNext(null);
            this.Tail = currTail;
        }
    }

    @Override
    public void deleteAtIdx(int idx) {
        if (idx < 0){
            throw new RuntimeException("Index must be in range");
        }
        if (idx == 0){
            this.deleteAtHead();
        }
        else{
            LLNode<T> curr = (LLNode<T>) this.Head;
            for (int i = 0; i < idx-1 && curr != null; i++) {
                curr = curr.getNext();
            }

            if (curr != null) {
                LLNode<T> nextNextNode = null;
                try {
                    nextNextNode = curr.getNext().getNext();
                } catch (NullPointerException e) {
                    nextNextNode = null;
                }
                curr.setNext(nextNextNode);
            }
            else {
                throw new NullPointerException();
            }
        }
    }

    public LLNode<T> copy(LinkedList<T> original) {
        LinkedList<T> copy = new LinkedList<T>();
        LLNode<T> originalHead = (LLNode<T>)(original).getHead();
        while (originalHead != null){
            copy.insertAtTail((T)(originalHead.getValue()));
            originalHead = originalHead.getNext();
        }
        return (LLNode<T>)copy.getHead();
    }

    @Override
    public Node search(T value) {
        LLNode<T> curr = (LLNode<T>) this.Head;

        while (curr != null){
            if ((T) curr.getValue() == value){
                return curr;
            }
            curr = curr.getNext();
        }

        return null;
    }

    @Override
    public void traverse() {
        LLNode<T> curr = (LLNode<T>) this.getHead();
        while (curr != null){
            System.out.print(curr+" ");
            curr = curr.getNext();
        }
    }
}
