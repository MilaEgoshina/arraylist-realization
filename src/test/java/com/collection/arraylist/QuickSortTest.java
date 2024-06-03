package com.collection.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
public class QuickSortTest {

    private CustomArrayList<Integer> customArrayList;

    @BeforeEach
    public void setUp(){
        customArrayList = new CustomArrayList<>();
    }

    @Test
    public void testSortIntArrayWithComparator() {

        customArrayList.add(3);
        customArrayList.add(1);
        customArrayList.add(5);
        customArrayList.add(2);

        QuickSort.sort(customArrayList,Comparator.naturalOrder());

        assertEquals(1, (int) customArrayList.get(0));
        assertEquals(2, (int) customArrayList.get(1));
        assertEquals(3, (int) customArrayList.get(2));
        assertEquals(5, (int) customArrayList.get(3));
    }

    @Test
    public void testSortStringArrayWithComparator() {

        CustomArrayList<String> stringCustomArrayList = new CustomArrayList<>();
        stringCustomArrayList.add("zebra");
        stringCustomArrayList.add("dog");
        stringCustomArrayList.add("cat");
        stringCustomArrayList.add("elephant");

        QuickSort.sort(stringCustomArrayList, Comparator.naturalOrder());

        assertEquals("cat", stringCustomArrayList.get(0));
        assertEquals("dog", stringCustomArrayList.get(1));
        assertEquals("elephant", stringCustomArrayList.get(2));
        assertEquals("zebra", stringCustomArrayList.get(3));
    }

    @Test
    public void testSortCustomObjectArrayWithComparator() {
        CustomArrayList<Person> arrayList = new CustomArrayList<>();

        Person person1 = new Person(2,"Bob");
        Person person2 = new Person(3,"Darry");
        Person person3 = new Person(4,"Kate");
        Person person4 = new Person(1,"Alice");
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);

        QuickSort.sort(arrayList, Comparator.comparing(Person::getName));

        assertEquals(person4, arrayList.get(0));
        assertEquals(person1, arrayList.get(1));
        assertEquals(person2, arrayList.get(2));
        assertEquals(person3, arrayList.get(3));
    }

    @Test
    public void testSortEmptyArrayWithComparator() {

        QuickSort.sort(customArrayList, Comparator.naturalOrder());
        assertEquals(0, customArrayList.size());
    }

    @Test
    public void testSortSingleElementArrayWithComparator() {

        customArrayList.add(7);
        QuickSort.sort(customArrayList, Comparator.naturalOrder());
        assertEquals(7, (int) customArrayList.get(0));
    }

    @Test
    public void testSortEmptyListWithComparable() {

        QuickSort.sort(customArrayList);
        assertEquals(0, customArrayList.size());
    }

    @Test
    public void testSortMultipleElementListWithComparable() {

        customArrayList.add(5);
        customArrayList.add(3);
        customArrayList.add(8);
        customArrayList.add(1);
        customArrayList.add(6);

        QuickSort.sort(customArrayList);

        assertEquals(5, customArrayList.size());
        assertEquals(1, customArrayList.get(0).intValue());
        assertEquals(3, customArrayList.get(1).intValue());
        assertEquals(5, customArrayList.get(2).intValue());
        assertEquals(6, customArrayList.get(3).intValue());
        assertEquals(8, customArrayList.get(4).intValue());
    }
    

     class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person {" + id + ", " + name + "}";
        }
    }
}
