package com.collection.arraylist;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> strList = new MyArrayList<>();
        strList.add(1);
        strList.add(2);
        strList.add(3);
        strList.add(4);
        strList.add(5);
        strList.add(1,7);
        strList.add(2,9);
        Integer integer = 15;
        strList.remove(integer);
        System.out.println(strList.size());
        System.out.println(strList);
        Comparator<Integer> stringComparator = Comparator.naturalOrder();
        QuickSort.sort(strList, stringComparator);


        System.out.println("After sorting: " + strList);
    }
}
