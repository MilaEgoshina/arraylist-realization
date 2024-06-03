package com.collection.arraylist;

import java.util.Comparator;

/**
 * This class provides a static method for performing a quicksort algorithm on a CustomArrayList
 * containing elements that implement the Comparable interface.
 */
public class QuickSort {

    /**
     * Method to sort the elements in the given CustomArrayList using the Quick Sort algorithm.
     * It starts the method {@code quickSort(CustomArrayList<T> arrayList, int low, int high, Comparator<? super T> comparator)} and launches
     * the quick sort algorithm.
     *
     * @param <T> the type of elements that this QuickSort class can sort
     * @param arrayList the CustomArrayList to be sorted
     * @param comparator the comparator to determine the order of the elements
     */
    public static <T> void sort(CustomArrayList<T> arrayList, Comparator<T> comparator){

        if(arrayList == null || arrayList.size() == 0){
            return;
        }
        quickSort(arrayList,0,arrayList.size() - 1, comparator);
    }

    /**
     * Recursively performs the Quick Sort algorithm on the CustomArrayList based on the comparator.
     *
     * This method first checks if the low index is less than the high index. If true, it means that the subarray
     * contains more than one element and sorting is required. If the low index is greater than or equal to the high index,
     * it means that the subarray contains one element or less, and no sorting is needed.
     *
     * The  method is called recursively on the left subarray (from low to pivotIndex - 1) and the right
     * subarray (from pivotIndex + 1 to high). This process is repeated until all subarrays are sorted.
     *
     * @param <T> the type of elements that this QuickSort class can sort
     * @param arrayList the CustomArrayList to be sorted
     * @param low the starting index of the sublist to be sorted
     * @param high the ending index of the sublist to be sorted
     * @param comparator the comparator to determine the order of the elements
     */
    private static <T> void quickSort(CustomArrayList<T> arrayList, int low, int high,
                                      Comparator<? super T> comparator){
        // if low is more than high, then the subarray contains one element or less and no sorting is required.
        if(low < high){
            int pivotIndex = partition(arrayList, low, high, comparator);
            quickSort(arrayList,low,pivotIndex - 1, comparator);
            quickSort(arrayList,pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Partitions the sublist in the CustomArrayList based on the comparator and returns the index of the pivot element.
     *
     * The method first calculates the middle index of the array and selects the pivot element at that index.
     * It then swaps the pivot element with the element at the high index.
     *
     * The method then iterates through the array from the low index to the high index and compares each element to
     * the pivot using the comparator. If the element is less than the pivot, it increments the index i and swaps the
     * elements at indexes i and j.
     *
     * After iterating through the array, the method swaps the pivot element (which is currently at the high index) with
     * the element at index i + 1. This places the pivot element in its correct sorted position in the array based on the
     * comparisons made earlier.
     *
     * @param <T> the type of elements that this QuickSort class can sort
     * @param arrayList the CustomArrayList containing the sublist to be partitioned
     * @param low the starting index of the sublist to be partitioned
     * @param high the ending index of the sublist to be partitioned
     * @param comparator the comparator to determine the order of the elements
     * @return the index of the pivot element after partitioning
     */
    private static <T> int partition(CustomArrayList<T> arrayList, int low, int high,
                                     Comparator<? super T> comparator){

        int middle = low + (high - low) / 2;
        T pivot = arrayList.get(middle);

        T temp = arrayList.get(middle);
        arrayList.set(middle,arrayList.get(high));
        arrayList.set(high,temp);

        int i = low - 1;
        for(int j = low; j < high; j++){
            if(comparator.compare(arrayList.get(j), pivot) < 0){
                i++;
                T pi = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,pi);
            }
        }
        T tempPivot = arrayList.get(i + 1);
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,tempPivot);
        return i + 1;
    }

    /**
     * Sorts the elements in the given CustomArrayList using the quicksort algorithm.
     * It starts the method {@code quicksort(CustomArrayList<T> arr, int low, int high)} and launches
     * the quick sort algorithm.
     * @param arr the CustomArrayList to be sorted
     * @param <T> the type of elements in the CustomArrayList, must implement Comparable interface
     */
    public static <T extends Comparable<T>> void sort(CustomArrayList<T> arr) {

        if(arr == null || arr.size() == 0){
            return;
        }
        quickSort(arr, 0, arr.size() - 1);
    }

    /**
     * Recursively divides the CustomArrayList into subarrays and sorts them.
     *
     * The method first checks if the value of "low" is less than "high", which is the base case for the recursive
     * quicksort algorithm. If the condition is met, the method proceeds to call the partition method to rearrange
     * the elements of the array such that all elements less than a chosen pivot point are on the left side, and all
     * elements greater than the pivot are on the right side.
     *
     * After partitioning the array, the method recursively calls quicksort on the left subarray (from low to pi-1) and
     * the right subarray (from pi+1 to high) to sort them separately.
     *
     * @param arr the CustomArrayList to be sorted
     * @param low the index of the first element in the subarray
     * @param high the index of the last element in the subarray
     * @param <T> the type of elements in the CustomArrayList.
     */
    private static <T extends Comparable<T>> void quickSort(CustomArrayList<T> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    /**
     * Partitions the CustomArrayList based on a pivot element.
     *
     * The method first calculates the middle index of the range and selects the element at that index as the pivot element.
     * It then swaps the pivot element with the element at the high index in the list.
     *
     * Next, the method initializes a variable `i` to low - 1. It iterates over the elements in the range from low to high,
     * comparing each element to the pivot element. If an element is less than the pivot, it increments `i` and swaps the
     * element at index `i` with the element at index `j`. This process effectively partitions the elements into two groups
     * those less than the pivot on one side and those greater than or equal to the pivot on the other side.
     *
     * After iterating through all elements in the range, the method swaps the pivot element from the high index with
     * the element at index `i+1`.
     * @param arrayList the CustomArrayList to be partitioned
     * @param low the index of the first element in the subarray
     * @param high the index of the last element in the subarray
     * @param <T> the type of elements in the CustomArrayList.
     * @return the index of the pivot element after partitioning
     */
    private static <T extends Comparable<T>> int partition(CustomArrayList<T> arrayList, int low, int high) {
        int middle = low + (high - low) / 2;
        T pivot = arrayList.get(middle);

        T temp = arrayList.get(middle);
        arrayList.set(middle,arrayList.get(high));
        arrayList.set(high,temp);

        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arrayList.get(j).compareTo(pivot)< 0){

                i++;
                T pi = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,pi);
            }
        }
        T tempPivot = arrayList.get(i + 1);
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,tempPivot);
        return i + 1;
    }

}
