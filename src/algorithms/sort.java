package algorithms;

import java.util.Arrays;

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
}
