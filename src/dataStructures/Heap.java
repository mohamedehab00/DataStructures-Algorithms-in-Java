package dataStructures;

import java.util.Locale;

public class Heap <T extends Comparable<? super T>>{
    private T[] heapArr;
    private int capacity;
    private int n;
    private String type;

    public Heap(){
        this.type = "min";
        this.n = 0;
        this.capacity = 0;
        this.heapArr = (T[]) new Comparable[this.capacity];
    }

    public Heap(String type){
        if (type.toLowerCase() == "max"){
            this.type = type;
        }
        else {
            this.type = "min";
        }
        this.n = 0;
        this.capacity = 0;
        this.heapArr = (T[]) new Comparable[this.capacity];
    }

    private void heapfiy(){
        for (int i = this.n-1; i >= 0; i--) {
            int parent = (i-1)/2;

            T val = this.heapArr[parent];

            if (parent >= 0){
                if (this.type == "min"){
                    if(val.compareTo(this.heapArr[i]) > 0){
                        T temp = this.heapArr[i];
                        this.heapArr[i] = this.heapArr[parent];
                        this.heapArr[parent] = temp;
                    }
                }
                else {
                    if(val.compareTo(this.heapArr[i]) < 0){
                        T temp = this.heapArr[i];
                        this.heapArr[i] = this.heapArr[parent];
                        this.heapArr[parent] = temp;
                    }
                }
            }
        }
    }

    private void grow(){
        int newCap = (this.capacity * 2) + 1;
        T[] newArr = (T[]) new Comparable[newCap];

        for (int i = 0; i < this.n; i++) {
            newArr[i] = this.heapArr[i];
        }

        this.capacity = newCap;
        this.heapArr = newArr;
    }

    public void push(T value){
        if (this.n + 1 > this.capacity){
            this.grow();
        }

        this.n += 1;
        this.heapArr[this.n-1] = value;

        this.heapfiy();
    }

    public void pop(){
        this.n -= 1;
        this.heapfiy();
    }

    public T top() throws Exception{
        if (this.n > 0){
            return this.heapArr[this.n-1];
        }
        else {
            throw new Exception("No remaining elements");
        }
    }

}
