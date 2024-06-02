package com.collection.arraylist;

import lombok.Getter;

/**
 * This class represents a custom implementation of a dynamic array list data structure.
 * It implements the CustomList interface and provides methods to add, remove, get elements, and more.
 * The list automatically expands in capacity when needed to accommodate additional elements.
 *
 * @param <E> the type of elements stored in the list
 */
@Getter
public class MyArrayList<E> implements CustomList<E>{
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] elementData;
    private int size;
    private int capacity;

    /**
     * Constructs an instance of MyArrayList with the default capacity.
     */
    public MyArrayList(){
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
        size = 0;
    }

    /**
     * Constructs an instance of MyArrayList with the specified capacity.
     *
     * @param capacity the initial capacity of the list
     */
    public MyArrayList(int capacity){

        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return size - the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method to get the element at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    @Override
    public E get(int index) {
        if(checkIndex(index)){
            return (E) elementData[index];
        }
        return null;
    }

    /**
     * Method to add the specified element to the end of the list.
     *
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     */
    @Override
    public boolean add(E element) {

        if(isValidElement(element)){
            ensureCapacity(size + 1);
            elementData[size++] = element;
            return true;
        }
        return false;
    }

    /**
     * Method to insert the specified element at the specified index in the list.
     *
     * @param index the index at which to insert the element
     * @param element the element to insert in the list
     */
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

    /**
     * Method to add all the elements in the specified array to the end of the list.
     *
     * @param elements an array of elements to be added
     * @return true if all elements were successfully added, false otherwise
     */
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

    /**
     * Method to remove the element at the specified index from the list.
     *
     * @param index the index of the element to remove
     * @return the removed element
     */
    @Override
    public E remove(int index) {
        E removedElement = (E) elementData[index];
        removeAtIndex(index);
        return removedElement;
    }

    /**
     * Method to remove the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed
     * @return true if the element was found and removed, false otherwise
     */
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

    /**
     * Method to check if the list contains the specified element.
     *
     * @param element the element to check for
     * @return true if the element is found in the list, false otherwise
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    /**
     * Method to replace the element at the specified index with the specified element.
     *
     * @param index the index of the element to replace
     * @param element the new element to set
     * @return the old element at the specified index
     */
    @Override
    public E set(int index, E element) {
        if(checkIndex(index) && isValidElement(element)){

            E oldElement = (E) elementData[index];
            elementData[index] = element;
            return oldElement;
        }
        return null;
    }

    /**
     * Method which returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param elem the element to search for
     * @return the index of the specified element in this list, or -1 if not found
     */
    @Override
    public int indexOf(E elem) {

        for(int i = 0; i < size; i++){
            if(elementData[i].equals(elem)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call.
     */
    @Override
    public void clear() {
        elementData = new Object[10];
        size = 0;
    }

    /**
     * Method which returns a string representation of this list. The string representation consists of a list of
     * the elements enclosed in square brackets ("[]"), separated by commas and spaces.
     *
     * @return a string representation of this list
     */
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

    /**
     * Method to increase the capacity of this CustomArrayList instance, if necessary, to ensure that it can hold at least
     * the number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity of this CustomArrayList.
     */
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

    /**
     * Method to check if the given index is within the bounds of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is more than size of array or if index is less than zero.
     * @return true if the index is more than zero and less than array size, false otherwise
     */
    private boolean checkIndex(int index){
        if ((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return true;
    }

    /**
     * Method which removes the element at the specified index in this list.
     *
     * @param index the index of the element to be removed
     */
    private void removeAtIndex(int index){

        if(checkIndex(index)){
            for(int i = index; i < size - 1; i ++){

                elementData[i] = elementData[i + 1];
            }
            elementData[--size] = null;
        }
    }

    /**
     * Method to check if the provided element is valid (not null).
     *
     * @param element the element to check
     * @throws IllegalArgumentException if the element is null
     * @return true if the element is null, false otherwise
     */
    private boolean isValidElement(E element){
        if(element == null){
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        return true;
    }
}
