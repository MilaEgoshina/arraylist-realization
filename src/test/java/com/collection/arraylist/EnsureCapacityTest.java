package com.collection.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnsureCapacityTest {

    private CustomArrayList<Integer> customArrayList;

    @BeforeEach
    public void setUp(){
        customArrayList = new CustomArrayList<>();
    }

    @Test
    public void ensureCapacity_whenMinCapacityLessThanOldCapacity_shouldNotChangeCapacity() {

        customArrayList.ensureCapacity(5);

        assertEquals(16, customArrayList.getCapacity());
    }

    @Test
    public void ensureCapacity_whenMinCapacityGreaterThanOldCapacity_shouldIncreaseCapacity() {

        customArrayList.ensureCapacity(18);
        assertEquals(25, customArrayList.getCapacity());
    }

    @Test
    public void ensureCapacity_whenMinCapacityMoreThanOldCapacityAndOldCapacityLessThanMinCapacity_shouldIncreaseCapacity() {

        CustomArrayList<Integer> list = new CustomArrayList<>(2);
        Integer[] elements = {5, 10, 15};
        list.addAll(elements);
        assertEquals(4, list.getCapacity());
    }

    @Test
    public void ensureCapacity_whenMinCapacityEqualsOldCapacityAndOldCapacityLessThanMinCapacity_shouldNotChangeCapacity() {

        customArrayList.ensureCapacity(5);
        customArrayList.add(1);
        customArrayList.ensureCapacity(16);

        assertEquals(16, customArrayList.getCapacity());
    }

    @Test
    public void ensureCapacity_whenMinCapacityGreaterThanOldCapacityAndOldCapacityLessThanMinCapacity_shouldIncreaseCapacity() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        customArrayList.ensureCapacity(5);
        customArrayList.add(1);

        customArrayList.ensureCapacity(20);

        assertEquals(25, customArrayList.getCapacity());
    }
}
