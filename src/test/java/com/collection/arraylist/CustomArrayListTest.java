package com.collection.arraylist;

import junit.framework.Assert;
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
        Assert.assertEquals(0, customArrayList.size());
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
        Assert.assertEquals(3,size);
    }

    @Test
    public void givenListWithElements_whenGetValidIndex_thenReturnCorrectElement(){
        // Given
        customArrayList.add(5);
        customArrayList.add(10);

        // When
        int element = customArrayList.get(1);

        // Then
        Assert.assertEquals(10, element);
    }

    @Test
    public void givenListWithElements_whenGetInvalidIndex_thenReturnNull(){
        // Given
        customArrayList.add(5);
        customArrayList.add(10);

        // When
        Integer element = customArrayList.get(2);

        // Then
        Assert.assertNull(element);
    }
    @Test
    public void givenList_whenAddElement_thenTrue() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();

        // When
        boolean result = list.add(5);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void givenListWithElements_whenGetValidIndex_thenCorrectElement() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);

        // When
        int checkInt = customArrayList.get(1);

        //Then
        Assert.assertEquals(10, checkInt);
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
        Assert.assertTrue(isContain);
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
        Assert.assertEquals(4, customArrayList.size());
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
        Assert.assertEquals(7, checkElem);
    }
    @Test
    public void givenList_whenAddElementAtIndexIsLessThanZero_thenReturnInvalidIndex(){

        try {
            customArrayList.add(-1,14);
            fail("Expected IndexOutOfBoundsException to be thrown");
        }catch (IndexOutOfBoundsException e){
            Assert.assertEquals("Index -1 out of bounds for length 16", e.getMessage());
        }
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
        Assert.assertEquals(2, customArrayList);
    }

    @Test
    public void givenList_whenRemoveElementNotInList_thenFalse() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);

        //When
        Integer checkInt = 6;

        //Then
        Assert.assertFalse(customArrayList.remove(checkInt));
    }

    @Test
    public void givenList_whenRemoveElementByValue_thenTrue() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(15);
        customArrayList.add(56);

        //When
        Integer checkInt = 10;

        //Then
        Assert.assertTrue(customArrayList.remove(checkInt));
    }

    @Test
    public void givenList_whenRemoveElementByValue_thenSizeDecremented() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(15);
        customArrayList.add(56);

        //When
        customArrayList.remove(5);

        //Then
        assertEquals(3, customArrayList.size());
    }

    @Test
    public void givenList_whenSetElementAtValidIndex_thenElementUpdated() {

        //Given
        customArrayList.add(5);
        customArrayList.add(10);

        //When


        //Then
        assertEquals(10, customArrayList.set(1, 15));
    }

    @Test
    public void givenList_whenSetElementAtInvalidIndex_thenNull() {
        customArrayList.add(5);
        customArrayList.add(10);
        assertNull(customArrayList.set(2, 15));
    }

    @Test
    public void givenList_whenIndexOfElementIncustomArrayList_thenCorrectIndex() {
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
    public void givenList_whenEnsureCapacity_thenCapacityIncreased() {

        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.ensureCapacity(3);
        assertEquals(3, customArrayList.size());
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

    @Test
    public void givenList_whenCheckIndexOutOfBounds_thenExceptionThrown() {
        assertThrows(IndexOutOfBoundsException.class, () ->  customArrayList.checkIndex(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.checkIndex(1));
    }
}
