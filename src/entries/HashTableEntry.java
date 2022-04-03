package entries;

public class HashTableEntry <T,E> {
    private T Key;
    private E ActualValue;

    public HashTableEntry(T key, E value) {
        this.Key = key;
        this.ActualValue = value;
    }

    public E getActualValue() {
        return this.ActualValue;
    }

    public void setActualValue(E value) {
        this.ActualValue = value;
    }

    public T getKey() {
        return Key;
    }

    public void setKey(T key) {
        Key = key;
    }

    @Override
    public String toString() {
        return "Key=" + Key + ", Value=" + ActualValue;
    }
}
