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
        if(checkIndex(index)){
            E removedElement = (E) elementData[index];
            removeAtIndex(index);
            return removedElement;
        }
        return null;
    }
    @Override
    public boolean remove(E element) {
        if(size == 0 )
            return false;
        int i;
        for(i = 0; i < size; i++){
            if(elementData[i] == null && element == null){
                break;
            }
            if(elementData[i] != null && elementData.equals(elementData))
                break;
        }
        if(i < size){
            removeAtIndex(i);
            return true;
        }
        return false;
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }
    @Override
    public E set(int index, E element) {
        if(checkIndex(index)){

            E oldElement = (E) elementData[index];
            elementData[index] = element;
            return oldElement;
        }
        return null;
    }

    @Override
    public int indexOf(E elem) {
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
        if ((index < size) && (index >= 0)){
            return true;
        }
        return false;
    }
    private void removeAtIndex(int index){
        for(int i = 0; i < size - 1; i ++){
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }
}
