package com.collection.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    private  MyArrayList<Integer> customArrayList;

    @BeforeEach
    public void setUp(){
        customArrayList = new MyArrayList<>();
    }

    @Test
    public void givenEmptyListWhenSizeIsZeroThenReturnZero(){
        assertEquals(0, customArrayList.size());
    }

    @Test
    public void givenListWithElements_whenSize_thenReturnCorrectSize(){

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(16);

        //When
        int size = customArrayList.size();

        //Then
        assertEquals(3,size);
    }

    @Test
    public void givenListWithElements_whenGetValidIndex_thenReturnCorrectElement(){
        // Given
        customArrayList.add(5);
        customArrayList.add(10);

        // When
        int element = customArrayList.get(1);

        // Then
        assertEquals(10, element);
    }

    @Test
    public void givenListWithElements_whenGetInvalidIndex_thenReturnNull(){
        // Given
        customArrayList.add(5);
        customArrayList.add(10);

        // When
        Integer element = customArrayList.get(2);

        // Then
        assertNull(element);
    }
    @Test
    public void givenList_whenAddElement_thenTrue() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();

        // When
        boolean result = list.add(5);

        // Then
        assertTrue(result);
    }

    @Test
    public void givenList_whenAddElement_thenContainsElement() {
        //Given
        customArrayList.add(5);
        customArrayList.add(5);
        customArrayList.add(10);

        //When
        boolean isContain = customArrayList.contains(5);

        //Then
        assertTrue(isContain);
    }

    @Test
    public void givenList_whenAddElement_thenSizeIncremented() {
        //Given
        customArrayList.add(5);
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(5);

        //When
        int size = customArrayList.size();

        //Then
        assertEquals(4, size);
    }

    @Test
    public void givenList_whenAddElementAtSpecificIndex_thenElementAdded() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(1, 7);

        //When
        int checkElem = customArrayList.get(1);

        //Then
        assertEquals(7, checkElem);
    }

    @Test
    public void givenList_whenAddElementAtSpecificIndex_thenReturnCorrectListSize(){

        //Given
        customArrayList.add(0,1);
        customArrayList.add(1,45);
        customArrayList.add(2,56);
        customArrayList.add(3,21);

        //When
        int size = customArrayList.size();

        //Then
        assertEquals(4, size);
    }
    @Test
    public void givenList_whenAddNullElement_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            customArrayList.add(4);
            customArrayList.add(2);
            customArrayList.add(null);
        });
    }

    @Test
    public void givenList_whenAddElementAtIndexIsLessThanZero_thenReturnInvalidIndex(){

        customArrayList.add(0,13);
        customArrayList.add(1,4);

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            customArrayList.add(-1,14);
        });

        String expectedMessage = "Index: -1, Size 2";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void givenList_whenAddElementAtSpecificIndexIsMoreThanSize_thenIndexOutOfBoundsExceptionThrown(){

        customArrayList.add(0, 1);
        customArrayList.add(1, 2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            customArrayList.add(3, 3);
        });
    }

    @Test
    public void givenList_whenRemoveElement_thenElementRemoved() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);

        //When
        int checkElem = customArrayList.remove(1);

        //Then
        assertEquals(10, checkElem);
    }

    @Test
    public void givenList_whenRemoveElement_thenSizeDecremented() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(10);
        customArrayList.remove(0);

        //When
        int sizeAfterRemove = customArrayList.size();

        //Then
        assertEquals(2, sizeAfterRemove);
    }
    @Test
    void givenList_whenRemoveElementAtSpecificIndexIsMoreThanSize_thenIndexOutOfBoundsExceptionThrown() {

        customArrayList.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            customArrayList.remove(-1);
        });
    }

    @Test
    void givenList_whenRemoveElementAtSpecificIndexIsLessThanZero_thenIndexOutOfBoundsExceptionThrown() {

        customArrayList.add(8);
        customArrayList.add(57);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            customArrayList.remove(3);
        });
    }

    @Test
    public void givenList_whenRemoveElementNotInList_thenFalse() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);

        //When
        Integer removedElem = 6;

        //Then
        assertFalse(customArrayList.remove(removedElem));
    }

    @Test
    public void givenList_whenRemoveElementByValue_thenTrue() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(15);
        customArrayList.add(56);

        //When
        Integer removedElem = 10;

        //Then
        assertTrue(customArrayList.remove(removedElem));
    }

    @Test
    public void givenList_whenRemoveElementByValue_thenSizeDecremented() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(15);
        customArrayList.add(56);

        //When
        Integer removedElem = 5;
        customArrayList.remove(removedElem);

        //Then
        assertEquals(3, customArrayList.size());
    }

    @Test
    public void  givenList_whenRemoveElementByValueAndClearList_thenReturnFalse() {

        //Given
        Integer elemToRemoved = 90;
        customArrayList.add(8);
        customArrayList.add(15);

        //When
        customArrayList.clear();

        assertFalse(customArrayList.remove(elemToRemoved));
    }

    @Test
    public void  givenList_whenRemoveElementValueIsNull_thenIllegalArgumentExceptionThrows() {

        customArrayList.add(8);
        customArrayList.add(15);

        assertThrows(IllegalArgumentException.class, () -> customArrayList.remove(null));
    }

    @Test
    public void givenList_whenSetElementAtValidIndex_thenElementUpdated() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);

        //When
        int oldElem = customArrayList.set(1,15);

        //Then
        assertEquals(10, oldElem);
    }

    @Test
    public void givenList_whenSetElementAtInvalidIndex_thenNull() {
        customArrayList.add(5);
        customArrayList.add(10);

        assertNull(customArrayList.set(2, 15));
    }
    @Test
    void givenList_whenSetElementAtIndexIsLessThanZero_thenIndexOutOfBoundsExceptionThrows() {
        customArrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            customArrayList.set(-1, 2);
        });
    }

    @Test
    void givenList_whenSetElementAtIndexIsMoreThanSize_thenIndexOutOfBoundsExceptionThrows() {

        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            customArrayList.set(4, 10);
        });
    }

    @Test
    void givenList_whenSetNullElementAtIndex_thenIllegalArgumentExceptionThrows() {

        customArrayList.add(1);
        assertThrows(IllegalArgumentException.class, () -> {
            customArrayList.set(0, null);
        });
    }
    @Test
    public void givenList_whenIndexOfElementInList_thenCorrectIndex() {
        customArrayList.add(5);
        customArrayList.add(10);
        assertEquals(0, customArrayList.indexOf(5));
    }

    @Test
    public void givenList_whenIndexOfElementNotInList_thenNegativeOne() {
        customArrayList.add(5);
        customArrayList.add(10);
        assertEquals(-1, customArrayList.indexOf(15));
    }

    @Test
    public void givenList_whenEnsureCapacity_thenElementsPreserved() {
        MyArrayList<Integer> customArrayList = new MyArrayList<>(2);
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.ensureCapacity(3);
        assertEquals(5, customArrayList.get(0));
        assertEquals(10, customArrayList.get(1));
    }

    @Test
    public void givenList_whenAddAllElements_thenAllAdded() {
        Integer[] elements = {5, 10, 15};
        customArrayList.addAll(elements);
        assertEquals(3, customArrayList.size());
        assertTrue(customArrayList.contains(5));
        assertTrue(customArrayList.contains(10));
        assertTrue(customArrayList.contains(15));
    }
    @Test
    public void givenList_whenAddAllNullArray_thenFalse(){
        assertFalse(customArrayList.addAll(null));
    }

    @Test
    public void givenList_whenAddAllElementsExceedCapacity_thenCapacityIncreased() {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        Integer[] elements = {5, 10, 15};
        list.addAll(elements);
        assertEquals(3, list.size());
    }

}
