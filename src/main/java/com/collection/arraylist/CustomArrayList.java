package com.collection.arraylist;

import java.util.Comparator;

public class CustomArrayList<T> implements CustomList<T>{


    private static final int DEFAULT_CAPACITY = 16;

    private static final int CUT_RATE = 4;
    private Object[] elementData;
    private int size;

    public CustomArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public CustomArrayList(int capacity){
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public boolean addAll(T[] elements) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {

    }
}
