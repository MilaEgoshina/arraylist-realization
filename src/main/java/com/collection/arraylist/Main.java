package com.collection.arraylist;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        CustomArrayList<String> strList = new CustomArrayList<>();
        strList.add("banana");
        strList.add("apple");
        strList.add("cherry");
        strList.add("date");
        strList.add("blueberry");

        Comparator<String> stringComparator = Comparator.naturalOrder();
        QuickSort.sort(strList, stringComparator);

        System.out.println("After sorting: " + strList);
    }
}
