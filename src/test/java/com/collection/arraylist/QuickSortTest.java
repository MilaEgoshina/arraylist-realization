package com.collection.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
public class QuickSortTest {

    private  MyArrayList <Integer> customArrayList;

    @BeforeEach
    public void setUp(){
        customArrayList = new MyArrayList<>();
    }

    @Test
    public void testSortIntArray() {

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
    public void testSortStringArray() {

        MyArrayList<String> stringMyArrayList = new MyArrayList<>();
        stringMyArrayList.add("zebra");
        stringMyArrayList.add("dog");
        stringMyArrayList.add("cat");
        stringMyArrayList.add("elephant");
        QuickSort.sort(stringMyArrayList, Comparator.naturalOrder());
        assertEquals("cat", stringMyArrayList.get(0));
        assertEquals("dog", stringMyArrayList.get(1));
        assertEquals("elephant", stringMyArrayList.get(2));
        assertEquals("zebra", stringMyArrayList.get(3));
    }

    @Test
    public void testSortCustomObjectArray() {
        MyArrayList<Person> arrayList = new MyArrayList<>();

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
    public void testSortEmptyArray() {

        QuickSort.sort(customArrayList, Comparator.naturalOrder());
        assertEquals(0, customArrayList.size());
    }

    @Test
    public void testSortSingleElementArray() {

        customArrayList.add(7);
        QuickSort.sort(customArrayList, Comparator.naturalOrder());
        assertEquals(7, (int) customArrayList.get(0));
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
