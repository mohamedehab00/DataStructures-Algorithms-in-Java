package nodes;

public class DLLNode <T> extends LLNode{
    private DLLNode<T> Prev;

    public DLLNode(T value, DLLNode<T> prev, DLLNode<T> next) {
        super(value, next);
        this.Prev = prev;
    }

    public DLLNode(T value) {
        super(value);
        this.Prev = null;
        this.Next = null;
    }

    public DLLNode<T> getPrev() {
        return Prev;
    }

    public void setPrev(DLLNode<T> prev) {
        Prev = prev;
    }
}
