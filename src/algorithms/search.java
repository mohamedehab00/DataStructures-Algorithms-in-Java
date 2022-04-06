package algorithms;

public class search {
    public static <T extends Comparable<? super T>> int linearSearch(T value, T[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(value) == 0){
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> int binarySearch(int l, int r, T value, T[] arr){
        if (l > r){
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid].compareTo(value) == 0){
            return mid;
        }

        if (arr[mid].compareTo(value) > 0){
            return binarySearch(l, mid-1, value, arr);
        }
        else {
            return binarySearch(mid+1, r, value, arr);
        }
    }
}
