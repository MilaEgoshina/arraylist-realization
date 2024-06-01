package com.collection.arraylist;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> strList = new MyArrayList<>();
/*        strList.add("banana");
        strList.add("apple");
        strList.add("cherry");
        strList.add("date");
        strList.add("blueberry");*/
        strList.add(0,"honey");
        strList.add(1,"bee");
        strList.add(2,"bee");
        System.out.println(strList.size());
        System.out.println(strList);
        Comparator<String> stringComparator = Comparator.naturalOrder();
        QuickSort.sort(strList, stringComparator);


        System.out.println("After sorting: " + strList);
    }
}
