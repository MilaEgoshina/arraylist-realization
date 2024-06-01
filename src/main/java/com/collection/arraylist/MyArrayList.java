package com.collection.arraylist;

import lombok.Getter;

@Getter
public class MyArrayList<E> implements CustomList<E>{
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] elementData;
    private int size;
    private int capacity;
    public MyArrayList(){
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
        size = 0;
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

        if(isValidElement(element)){
            ensureCapacity(size + 1);
            elementData[size++] = element;
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, E element) {

        if(checkIndex(index) && isValidElement(element)){
            ensureCapacity(size + 1);
            if(index == size){
                elementData[size] = element;
            }else{
                for(int i = size; i >= index; i--){
                    elementData[i] = elementData[i - 1];
                }
                elementData[index] = element;
            }
           size++;
        }
    }
    @Override
    public boolean addAll(E[] elements) {
        if(elements == null)
            return false;
        if(size + elements.length > elementData.length){
            ensureCapacity(size + elements.length);
        }
        for(E elem : elements){
            elementData[size++] = elem;
;        }
        return true;
    }

    @Override
    public E remove(int index) {
        E removedElement = (E) elementData[index];
        removeAtIndex(index);
        return removedElement;
    }

    @Override
    public boolean remove(E element) {
        if(size == 0 )
            return false;
        if (isValidElement(element)) {
            for(int i = 0; i < size; i++){

                if(elementData[i].equals(element)){
                    removeAtIndex(i);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }
    @Override
    public E set(int index, E element) {
        if(checkIndex(index) && isValidElement(element)){

            E oldElement = (E) elementData[index];
            elementData[index] = element;
            return oldElement;
        }
        return null;
    }

    @Override
    public int indexOf(E elem) {

        for(int i = 0; i < size; i++){
            if(elementData[i].equals(elem)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void clear() {
        elementData = new Object[10];
        size = 0;
    }
    @Override
    public String toString(){
        if(size ==0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size - 1; i++){
            sb.append(elementData[i]).append(", ");
        }
        sb.append(elementData[size - 1]).append("]");
        return sb.toString();
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
        if ((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return true;
    }
    private void removeAtIndex(int index){

        if(checkIndex(index)){
            for(int i = index; i < size - 1; i ++){

                elementData[i] = elementData[i + 1];
            }
            elementData[--size] = null;
        }
    }
    private boolean isValidElement(E element){
        if(element == null){
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        return true;
    }
}
