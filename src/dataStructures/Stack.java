package dataStructures;

import nodes.LLNode;

public class Stack <T extends Comparable<? super T>>{
    private LinkedList<T> stack;

    public Stack()
    {
        this.stack = new LinkedList<>();
    }

    public Stack(LinkedList<T> ll) {
        this.stack = new LinkedList<>(ll);
    }

    public void push(T value){
        stack.insertAtHead(value);
    }

    public void pop(){
        stack.deleteAtHead();
    }

    public T peek(){
        LLNode<T> currHead = (LLNode<T>) stack.getHead();
        if (currHead == null){
            throw new NullPointerException("Stack is Empty!!");
        }
        else {
            return (T) currHead.getValue();
        }
    }

    public boolean isEmpty(){
        return stack.getHead() == null;
    }
}
