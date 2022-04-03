package dataStructures;

import nodes.DLLNode;
import nodes.Node;

public class DoublyLinkedList<T> extends List<T>{

    public DoublyLinkedList() {
        this.Head = null;
        this.Tail = null;
    }

    @Override
    public void insertAtHead(T value) {
        DLLNode<T> dllNode = new DLLNode<T>(value);
        if(this.Head == null) {
            this.Head = dllNode;
            this.Tail = this.Head;
        }
        else{
            DLLNode<T> prevHead = (DLLNode<T>) this.Head;
            DLLNode<T> currHead = dllNode;

            prevHead.setPrev(currHead);
            currHead.setNext(prevHead);
            this.Head = currHead;
        }
    }

    @Override
    public void insertAtTail(T value) {
        DLLNode<T> dllNode = new DLLNode<T>(value);
        if(this.Head == null) {
            this.Head = dllNode;
            this.Tail = this.Head;
        }
        else{
            DLLNode<T> prevTail = (DLLNode<T>) this.Tail;
            DLLNode<T> currTail = dllNode;

            currTail.setPrev(prevTail);
            prevTail.setNext(currTail);
            this.Tail = currTail;
        }
    }

    @Override
    public void insertAtIdx(T value, int idx) {
        DLLNode<T> dllNode = new DLLNode<T>(value);
        if(idx == 0){
            this.insertAtHead(value);
        }
        else{
            DLLNode<T> curr = (DLLNode<T>) this.Head;
            for (int i = 0; i < idx-1 && curr != null; i++) {
                curr = (DLLNode<T>) curr.getNext();
            }
            if (curr != null){
                try{
                    DLLNode<T> nextNextNode = (DLLNode<T>) curr.getNext();

                    (dllNode).setPrev(curr);
                    (dllNode).setNext(nextNextNode);
                    nextNextNode.setPrev(dllNode);
                    curr.setNext(dllNode);
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
            DLLNode<T> currHead = (DLLNode<T>) this.Head;
            this.Head = currHead.getNext();
            currHead.setNext(null);
            ((DLLNode<T>) this.Head).setPrev(null);
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
            DLLNode<T> currTail = (DLLNode<T>) this.Tail;
            this.Tail = currTail.getPrev();
            currTail.setPrev(null);
            ((DLLNode<T>) this.Tail).setNext(null);
        }
    }

    @Override
    public void deleteAtIdx(int idx) {
        if (idx == 0){
            this.deleteAtHead();
        }
        else{
            DLLNode<T> curr = (DLLNode<T>) this.Head;
            for (int i = 0; i < idx-1 && curr != null; i++) {
                curr = (DLLNode<T>) curr.getNext();
            }

            if (curr != null) {
                DLLNode<T> nextNextNode = null;
                try {
                    nextNextNode = (DLLNode<T>) ((curr.getNext()).getNext());
                } catch (NullPointerException e) {
                    nextNextNode = null;
                }

                if (nextNextNode == null){
                    curr.setNext(nextNextNode);
                }
                else {
                    curr.setNext(nextNextNode);
                    nextNextNode.setPrev(curr);
                }
            }
            else {
                throw new NullPointerException();
            }
        }
    }

    @Override
    public Node search(T value) {
        DLLNode<T> curr = (DLLNode<T>) this.Head;

        while (curr != null){
            if (curr.getValue() == value){
                return curr;
            }
            curr = (DLLNode<T>) curr.getNext();
        }
        return null;
    }

    @Override
    public void traverse() {
        DLLNode<T> curr = (DLLNode<T>) this.Head;

        while (curr != null){
            System.out.print(curr+" ");
            curr = (DLLNode<T>) curr.getNext();
        }
    }
}
