package nodes;

public class LLNode <T> extends Node{

    protected LLNode<T> Next;

    public LLNode(T value) {
        super(value);
        this.Next = null;
    }

    public LLNode(T value, LLNode<T> next) {
        super(value);
        this.Next = next;
    }

    public LLNode<T> getNext() {
        return Next;
    }

    public void setNext(LLNode<T> next) {
        Next = next;
    }
}
