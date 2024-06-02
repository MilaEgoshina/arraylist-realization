package com.collection.arraylist;

/**
 * This interface represents a custom list data structure that can store elements of type T.
 * It provides methods to add, remove, access, and manipulate elements within the list.
 * This interface is implemented by the CustomArrayClass.
 *
 * @param <T> the type of elements stored in the list
 */
public interface CustomList<T> {

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    T get(int index);

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to be added to the list
     * @return true if the element was successfully added, false otherwise
     */
    boolean add(T element);

    /**
     * Inserts the specified element at the specified index in the list.
     *
     * @param index the index at which to insert the element
     * @param element the element to be inserted
     */
    void add(int index, T element);

    /**
     * Adds all the elements in the specified array to the end of the list.
     *
     * @param elements the array of elements to be added to the list
     * @return true if all elements were successfully added, false otherwise
     */
    boolean addAll(T[] elements);

    /**
     * Removes the element at the specified index in the list.
     *
     * @param index the index of the element to be removed
     * @return the removed element
     */
    T remove(int index);

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed
     * @return true if the element was successfully removed, false otherwise
     */
    boolean remove(T element);

    /**
     * Checks if the list contains the specified element.
     *
     * @param element the element to check for in the list
     * @return true if the element is found in the list, false otherwise
     */
    boolean contains(T element);

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index the index of the element to replace
     * @param element the new element to set at the specified index
     * @return the element previously at the specified index
     */
    T set(int index, T element);

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     *
     * @param element the element to search for in the list
     * @return the index of the element, or -1 if the element is not found
     */
    int indexOf(T element);

    /**
     * Removes all elements from the list, leaving it empty.
     */
    void clear();

}
