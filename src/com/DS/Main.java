package com.DS;

import algorithms.*;
import dataStructures.*;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Linked List Generic Class Test
        LinkedList<Integer> ll = new LinkedList<>();

        ll.insertAtHead(10);
        ll.insertAtHead(11);

        ll.insertAtTail(9);
        ll.insertAtTail(8);

        ll.insertAtIdx(99, 2);

        ll.insertAtIdx(1, 5);

        ll.traverse();
        System.out.println();


        ll.deleteAtIdx(5);

        ll.traverse();
        System.out.println();

        System.out.println(ll.search(5));

        LinkedList<Integer> ll1 = new LinkedList<>(ll);
        ll1.deleteAtTail();
        ll1.traverse();
        System.out.println();
        ll.traverse();
        System.out.println();

        //Doubly Linked List Generic Class Test
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
        dl.insertAtHead(1);
        dl.traverse();
        dl.insertAtHead(2);
        dl.insertAtTail(3);
        dl.insertAtTail(99);

        dl.insertAtIdx(55,4);

        System.out.println();

        dl.traverse();
        System.out.println();

        dl.deleteAtIdx(4);

        System.out.println(dl.search(99));
        dl.traverse();
        System.out.println();

        //Stack Generic Class Test
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st.peek());

        st.pop();
        System.out.println(st.peek());

        st.pop();
        st.pop();
        System.out.println(st.isEmpty());

        //Binary Search Tree Generic Class Test
        BST<Integer> BinarySearchTree = new BST<>();

        BinarySearchTree.insertNode(1);

        BinarySearchTree.insertNode(7);

        BinarySearchTree.insertNode(17);

        BinarySearchTree.insertNode(3);

        BinarySearchTree.insertNode(15);

        BinarySearchTree.insertNode(18);

        BinarySearchTree.insertNode(16);

        BinarySearchTree.preOrderTraversal();
        System.out.println();

        BST<Integer> BinarySearchTree1 = new BST<>(BinarySearchTree);

        BinarySearchTree.deleteNode(1);

        BinarySearchTree.inOrderTraversal();
        System.out.println();
        BinarySearchTree.preOrderTraversal();
        System.out.println();
        BinarySearchTree.postOrderTraversal();
        System.out.println();

        BinarySearchTree.clear();
        System.out.println(BinarySearchTree.getRoot());

        BinarySearchTree1.preOrderTraversal();
        System.out.println();

        //HashTable Generic Class Test
        HashTable<String,Integer> HT = new HashTable<>();
        HT.addEntry("s",1);
        HT.addEntry("z",1);
        HT.addEntry("o",1);
        HT.addEntry("i",1);
        HT.traverse();
        HT.removeEntry("i");
        HT.removeEntry("o");


        //Min Heap Generic Class Test
        Heap<Integer> minHeap = new Heap<>();
        minHeap.push(2);
        minHeap.push(6);
        minHeap.push(11);
        minHeap.push(12);
        System.out.println(minHeap.top());
        minHeap.pop();
        System.out.println(minHeap.top());
        minHeap.pop();
        System.out.println(minHeap.top());
        minHeap.pop();
        System.out.println(minHeap.top());

        //Max Heap Generic Class Test
        Heap<Integer> maxHeap = new Heap<>("max");
        maxHeap.push(9);
        maxHeap.push(7);
        maxHeap.push(8);
        maxHeap.push(4);
        maxHeap.push(88);
        System.out.println(maxHeap.top());
        maxHeap.pop();
        System.out.println(maxHeap.top());
        maxHeap.pop();
        System.out.println(maxHeap.top());
        maxHeap.pop();
        System.out.println(maxHeap.top());
        maxHeap.pop();
        System.out.println(maxHeap.top());

        /*###################################################*/
        //Algorithms Part

        //Bubble Sort Generic Function
        String[] strArr = {"Mohamed","Mustafa","Ismail","Nada","Ameen"};
        Integer[] intArr = {2,5,7,9,7,0,3,1,77};

        //Bubble Sort Algorithm
        String[] sortedStrArr = sort.bubbleSort(strArr);
        //Insertion Merge Sort Algorithm
        Integer[] sortedIntArr = sort.insertionSort(intArr);

        Stream.of(sortedStrArr).forEach(x -> System.out.print(x+" "));
        System.out.println();
        Stream.of(sortedIntArr).forEach(x -> System.out.print(x+" "));
        System.out.println();

        //In-place Merge Sort Algorithm
        sort.mergeSort(0,intArr.length-1,intArr);

        //In-place Quick Sort Algorithm
        sort.quickSort(0,strArr.length-1,intArr);

        Stream.of(intArr).forEach(x -> System.out.print(x+" "));
        System.out.println();

        //Linear Search Algorithm
        int idx = search.linearSearch(3, intArr);
        System.out.println(idx);

        //Binary Search Algorithm
        idx = search.binarySearch(0, intArr.length-1, 0, intArr);
        System.out.println(idx);

        //Naive String Search Algorithm
        stringSearch.naiveSearch("AABA","AABAACAADAABAAABA");
        //Boyer-Moore-Hors-pool String Search Algorithm
        stringSearch.boyerMooreHorspoolSearch("TRUTH","THE TRUTH IS OUT HERE");
    }
}
