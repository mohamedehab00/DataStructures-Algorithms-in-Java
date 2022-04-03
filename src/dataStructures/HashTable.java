package dataStructures;

import entries.HashTableEntry;
import nodes.LLNode;

public class HashTable < T extends Comparable<? super T> , E >{
    private LinkedList<HashTableEntry<T,E>>[] Table;
    private int len = 4;
    private int hashFactor = 7;
    private double growthFac = 1.50;
    private double fillFac = 0.8;
    private int items = 0;

    public HashTable(){
        Table = new LinkedList[this.len];

        for (int i = 0; i < Table.length; i++) {
            Table[i] = new LinkedList<>();
        }
    }

    private int hash(T key){
        String StrForm = key.toString();
        int value = 0;
        for (int i = 0; i < StrForm.length(); i++) {
            value += (int)StrForm.charAt(i) * this.hashFactor;
        }
        return value;
    }

    private int indexer(T key){
        return hash(key) % this.len;
    }

    private int search(T key, int idx){
        int entryIdx = 0;
        LLNode<T> curr = (LLNode<T>) Table[idx].getHead();
        while (curr != null){
            HashTableEntry<T,E> currHe = (HashTableEntry<T, E>) curr.getValue();
            if (currHe.getKey() == key){
                return entryIdx;
            }
            entryIdx += 1;
            curr = curr.getNext();
        }
        return -1;
    }

    private void grow(){
        int newLen = (int)(this.len * this.growthFac);
        int prevLen = this.len;
        this.len = newLen;

        LinkedList<HashTableEntry<T,E>>[] biggerTable = new LinkedList[newLen];

        for (int i = 0; i < newLen; i++) {
            biggerTable[i] = new LinkedList<>();
        }

        for (int i = 0; i < prevLen; i++) {
            LLNode<T> curr = (LLNode<T>) Table[i].getHead();
            while (curr != null){
                HashTableEntry<T,E> currHe = (HashTableEntry<T, E>) curr.getValue();

                int newIdx = this.indexer(currHe.getKey());

                biggerTable[newIdx].insertAtHead(currHe);

                curr = curr.getNext();
            }
        }

        this.Table = biggerTable;
    }

    private void collapse(){
        if (this.len == 4){
            return;
        }
        int newLen = (int)(this.len / this.growthFac);
        if (newLen <= 0){
            newLen = 4;
        }
        int prevLen = this.len;
        this.len = newLen;

        LinkedList<HashTableEntry<T,E>>[] smallerTable = new LinkedList[newLen];

        for (int i = 0; i < newLen; i++) {
            smallerTable[i] = new LinkedList<>();
        }

        for (int i = 0; i < prevLen; i++) {
            LLNode<T> curr = (LLNode<T>) Table[i].getHead();
            while (curr != null){
                HashTableEntry<T,E> currHe = (HashTableEntry<T, E>) curr.getValue();

                int newIdx = this.indexer(currHe.getKey());

                smallerTable[newIdx].insertAtHead(currHe);

                curr = curr.getNext();
            }
        }

        this.Table = smallerTable;
    }

    public void addEntry(T key, E value) {
        HashTableEntry<T,E> entry = new HashTableEntry<>(key, value);
        int idx = indexer(key);
        int retIdx = this.search(key, idx);
        if (retIdx == -1){
            Table[idx].insertAtHead(entry);
        }
        else {
            throw new NullPointerException("Key is Duplicated!!!");
        }

        this.items += 1;

        if(((int)(this.len * this.fillFac)) <= this.items){
            this.grow();
        }
    }

    public void removeEntry(T key) {
        int idx = indexer(key);
        int retIdx = this.search(key, idx);
        if (retIdx != -1){
            if (retIdx == 0){
                Table[idx].deleteAtHead();
            }
            else {
                Table[idx].deleteAtIdx(retIdx-1);
            }
        }
        else {
            throw new NullPointerException("Key not Founded!!!");
        }

        this.items -= 1;

        if(((int)(this.len * this.fillFac)) > this.items){
            this.collapse();
        }
    }

    public void traverse(){
        System.out.println("HashTable begin :");
        for (int i = 0; i < this.len; i++) {
            boolean flag = true;
            LLNode<T> curr = (LLNode<T>) Table[i].getHead();
            while (curr != null){
                HashTableEntry<T,E> currHe = (HashTableEntry<T, E>) curr.getValue();
                System.out.print(currHe+" ");
                flag = false;
                curr = curr.getNext();
            }
            if (flag){
                System.out.print("Empty Node!!");
            }
            System.out.println();
        }
        System.out.println("HashTable end!!!");
    }
}
