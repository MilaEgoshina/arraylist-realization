package com.collection.arraylist;

import java.util.Comparator;

public interface CustomList<T> {

    int size();

    T get(int index);

    boolean add(T element);

    void add(int index, T element);

    boolean addAll(T[] elements);

    T remove(int index);

    boolean remove(T element);

    boolean contains(T element);

    T set(int index, T element);

    int indexOf(T elem);

    void clear();

    void sort(Comparator<? super T> comparator);


}
