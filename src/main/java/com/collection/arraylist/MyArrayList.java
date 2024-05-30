package com.collection.arraylist;

public class MyArrayList<E> implements CustomList<E>{
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] elementData;
    private int size = 0;
    private int capacity = 0;

    public MyArrayList(){
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
    }

    public MyArrayList(int capacity){

        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if(checkIndex(index)){
            return (E) elementData[index];
        }
        return null;
    }

    @Override
    public boolean add(E element) {

        ensureCapacity(size + 1);
        elementData[size++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {

        if(index < 0){
            return;
        }
        ensureCapacity(size + 1);
        if(index < size){
            index = size;
        }
        for(int i = size; i >= index; i--){
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
    }

    @Override
    public boolean addAll(E[] elements) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(E elem) {
        return 0;
    }

    @Override
    public void clear() {

    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            E[] oldData = (E[]) elementData;
            capacity = (oldCapacity * 3) / 2 + 1;
            if (capacity < minCapacity)
                capacity = minCapacity;

            elementData = (E[]) new Object[capacity];
            System.arraycopy(oldData, 0, elementData, 0, size);
        }
    }
    private boolean checkIndex(int index){
        if ((index < size) && (index >= 0)){
            return true;
        }
        return false;
    }


}
