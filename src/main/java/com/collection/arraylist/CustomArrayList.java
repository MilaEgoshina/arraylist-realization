package com.collection.arraylist;

import java.util.Comparator;

public class CustomArrayList<T> implements CustomList<T>{

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] elementData;
    private int size = 0;

    private int capacity = 0;

    public CustomArrayList(){
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
    }

    public CustomArrayList(int capacity){

        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {

        if((index >= size) && (index < 0)){

            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elementData[index];
    }

    @Override
    public boolean add(T element) {

        if(size == elementData.length){
            increaseCapacity();
        }

        elementData[size++] = element;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if ((index >= size) && (index < 0)) {

            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        if(size == elementData.length){
            increaseCapacity();
        }
        System.arraycopy(elementData,index,elementData,index + 1,size - index);
        elementData[index] = element;
        size++;
    }

 /*   public void addAll(T[] elements) {
        if (size + elements.length >= array.length) {
            array = Arrays.copyOf(array, Math.max(array.length * 2, size + elements.length));
        }
        System.arraycopy(elements, 0, array, size, elements.length);
        size += elements.length;
    }*/
    @Override
    public boolean addAll(T[] elements) {

        if(size + elements.length > elementData.length){
            increaseCapacity(size + elements.length);
        }

        System.arraycopy(elements,0, elementData, size, elements.length);
        size += elements.length;
        return true;
    }

    @Override
    public T remove(int index) {
        if ((index >= size) && (index < 0)) {

            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        T removed = (T) elementData[index];
        shiftToLeft(index);

        return removed;
    }

    @Override
    public boolean remove(T element) {

        if(size == 0){
            return  false;
        }

        int i;
        for(i = 0; i < size; i++){

            if(elementData[i] == null && element == null){
                break;
            }
            if(elementData[i] != null && elementData[i].equals(element)){
                break;
            }
        }

        if(i < size){
            shiftToLeft(i);
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(T elem) {

        if(elem == null){
            for(int i = 0; i < size; i++){
                if(elementData[i] == null){
                    return i;
                }
            }
        }else {
            for(int i = 0; i < size; i++){
                if(elementData[i].equals(elem)){
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public boolean contains(T element) {

        return indexOf(element) >= 0;
    }

    @Override
    public T set(int index, T element) {

        if ((index >= size) && (index < 0)) {

            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        T oldElement = (T) elementData[index];
        elementData[index] = element;
        return oldElement;
    }

    @Override
    public void clear() {

        elementData = new Object[10];
        size = 0;
    }

    private void increaseCapacity(){
        int oldCapacity = elementData.length;
        capacity = (oldCapacity * 3) / 2 + 1;
        Object[] newArray = new Object[capacity];
        System.arraycopy(elementData,0, newArray,0, size);
        elementData = newArray;
    }

    private void increaseCapacity(int minCapacity){
         capacity = Math.min(elementData.length * 2, minCapacity);
         Object[] newArray = new Object[capacity];
         System.arraycopy(elementData,0, newArray, 0, size);
         elementData = newArray;
    }

    private void shiftToLeft(int start){

        size--;

        if(size <= 0) return;

        if(size != start){
            System.arraycopy(elementData, start + 1, elementData, start, size - start);
        }
    }
}
