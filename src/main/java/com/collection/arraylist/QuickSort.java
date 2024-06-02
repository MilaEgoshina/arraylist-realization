package com.collection.arraylist;

import java.util.Comparator;

/**
 * This class represents a generic implementation of the Quick Sort algorithm.
 * It is capable of sorting elements of any type that extends the Comparable interface.
 *
 * @param <T> the type of elements that this QuickSort class can sort
 */
public class QuickSort<T extends Comparable<T>> {

    /**
     * Method to sort the elements in the given CustomArrayList using the Quick Sort algorithm.
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
            if(comparator.compare(arrayList.get(j), pivot) < 0){ // if current elem is higher or equal to pivot element, so we need
                //to switch them
                i++; // increase i pointer to determine where to put current element
                T pi = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,pi);
            }
        }
        //after the loop completes, all elements with lower values are collected to the left of the pivot.
        // index i point to the last from the first group of partition
        // we put pivot between two groups after the partition
        T tempPivot = arrayList.get(i + 1); // put the pivot in temp
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,tempPivot); // put the pivot on the i + 1 position
        // return index of the pivot after partition
        return i + 1;
    }
}
