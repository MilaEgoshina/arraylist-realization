package com.collection.arraylist;

public class QuickSort<T extends Comparable<T>> {


    public void sort(CustomArrayList<T> arrayList){

        if(arrayList == null || arrayList.size() == 0){
            return;
        }
        quickSort(arrayList,0,arrayList.size() - 1);
    }

    private void quickSort(CustomArrayList<T> arrayList, int low, int high){
        // if low is more than high, then the subarray contains one element or less and no sorting is required.
        if(low < high){
            int pivotIndex = partition(arrayList,low,high);
            quickSort(arrayList,low,pivotIndex - 1);
            quickSort(arrayList,pivotIndex + 1, high);
        }
    }

    private int partition(CustomArrayList<T> arrayList, int low, int high){

        int middle = low + (high - low) / 2;
        T pivot = arrayList.get(middle);
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arrayList.get(j).compareTo(pivot) <= 0){ // if current elem is higher or equal to pivot element, so we need
                //to switch them
                i++; // increase i pointer to determine where to put current element
                T temp = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,temp);
            }
        }
        //after the loop completes, all elements with lower values are collected to the left of the pivot.
        // index i point to the last from the first group of partition
        // we put pivot between two groups after the partition
        T temp = arrayList.get(i + 1); // put the pivot in temp
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,temp); // put the pivot on the i + 1 position
        // return index of the pivot after partition
        return i + 1;
    }
}
