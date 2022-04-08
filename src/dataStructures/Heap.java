package dataStructures;

public class Heap <T extends Comparable<? super T>>{
    private T[] heapArr;
    private int capacity;
    private int n;
    private String type = "min";

    public Heap(){
        this.n = 0;
        this.capacity = 0;
        this.heapArr = (T[]) new Comparable[this.capacity];
    }

    public Heap(String type){
        if (type.equalsIgnoreCase("max")){
            this.type = type;
        }
        this.n = 0;
        this.capacity = 0;
        this.heapArr = (T[]) new Comparable[this.capacity];
    }

    private void heapify(){
        for (int i = this.n-1; i >= 0; i--) {
            int parent = (i-1)/2;

            T val = this.heapArr[parent];

            if (parent >= 0){
                if (this.type.equals("min")){
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

    private void shrink(){
        int newCap = this.capacity / 2;
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

        this.heapify();
    }

    public void pop(){
        if (this.n <= 0){
            System.out.println("No more elements");
        }
        else{
            T temp = this.heapArr[0];
            this.heapArr[0] = this.heapArr[this.n-1];
            this.heapArr[this.n-1] = temp;

            this.n -= 1;

            if (this.n < this.capacity / 2){
                this.shrink();
            }

            this.heapify();
        }
    }

    public T top(){
        if (this.n > 0){
            return this.heapArr[0];
        }
        else {
            return null;
        }
    }

}
