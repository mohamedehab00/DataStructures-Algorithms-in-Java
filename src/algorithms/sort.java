package algorithms;

import java.util.Arrays;
import java.util.Random;

public class sort {

    public static <T extends Comparable<? super T>> T[] bubbleSort(T[] arr){
        T[] copyArr = Arrays.copyOf(arr,arr.length);
        for (int i = 0; i < copyArr.length; i++) {
            boolean enhance = true;
            for (int j = 0; j < copyArr.length-1; j++) {
                int comp = copyArr[j].compareTo(copyArr[j+1]);
                if (comp >= 1){
                    T temp = copyArr[j];
                    copyArr[j] = copyArr[j+1];
                    copyArr[j+1] = temp;
                    enhance = false;
                }
            }
            if (enhance){
                break;
            }
        }
        return copyArr;
    }

    public static <T extends Comparable<? super T>> T[] insertionSort(T[] arr){
        T[] copyArr = Arrays.copyOf(arr,arr.length);

        for (int i = 1; i < copyArr.length; i++) {
            int j = i;
            while (j-1 >= 0 && copyArr[j-1].compareTo(copyArr[j]) >= 1){
                T temp = copyArr[j];
                copyArr[j] = copyArr[j-1];
                copyArr[j-1] = temp;
                j-=1;
            }
        }

        return copyArr;
    }

    private static <T extends Comparable<? super T>> void merge(int l , int mid , int r , T[] arr){
        if ( l < r ){
            int n1 = (mid - l) + 1;
            int n2 = r - mid;

            Comparable[] left = new Comparable[n1];
            Comparable[] right = new Comparable[n2];

            for (int i = 0; i < n1; i++) {
                left[i] = arr[l+i];
            }

            for (int j = 0; j < n2; j++) {
                right[j] = arr[(mid+1)+j];
            }

            int i = 0;
            int j = 0;
            int k = l;

            while (i < n1 && j < n2){
                if (left[i].compareTo(right[j]) <= 0){
                    arr[k] = (T) left[i];
                    i+=1;
                }
                else {
                    arr[k] = (T) right[j];
                    j+=1;
                }
                k+=1;
            }
            while (i < n1){
                arr[k] = (T) left[i];
                i+=1;
                k+=1;
            }
            while (j < n2){
                arr[k] = (T) right[j];
                j+=1;
                k+=1;
            }
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(int l , int r, T[] arr){
        if (l < r){
            int mid = l + (r-l) / 2;

            mergeSort(l,mid,arr);

            mergeSort(mid+1,r,arr);

            merge(l,mid,r,arr);
        }
    }

    private static <T extends Comparable<? super T>> int partition(int l , int r, T[] arr){
        int idx_random = (int)Math.floor(Math.random()*(r-l+1)+l);

        T pivot = arr[idx_random];

        T temp = arr[idx_random];
        arr[idx_random] = arr[r];
        arr[r] = temp;


        int j = l-1;
        for (int i = l; i <= r-1; i++) {
            if (arr[i].compareTo(pivot) < 0){
                j++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[r];
        arr[r] = arr[j+1];
        arr[j+1] = temp;

        return j+1;
    }

    public static <T extends Comparable<? super T>> void quickSort(int l , int r, T[] arr){
        if (l < r){
            int idx = partition(l,r,arr);

            quickSort(l,idx-1,arr);

            quickSort(idx+1,r,arr);
        }
    }
}
