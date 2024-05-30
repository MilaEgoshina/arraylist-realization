package com.collection.arraylist;

public class Main {

    public static void main(String[] args) {
        CustomArrayList<Integer> integerList = new CustomArrayList<>();
        integerList.add(5);
        integerList.add(2);
        integerList.add(9);
        integerList.add(1);
        integerList.add(5);

        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(integerList);

        System.out.println("Sorted integer list: " + integerList);
    }
}
