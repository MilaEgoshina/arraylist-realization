package com.collection.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnsureCapacityTest {

    private  MyArrayList<Integer> customArrayList;

    @BeforeEach
    public void setUp(){
        customArrayList = new MyArrayList<>();
    }

    @Test
    public void ensureCapacity_whenMinCapacityLessThanOldCapacity_shouldNotChangeCapacity() {

        customArrayList.ensureCapacity(5);

        assertEquals(10, customArrayList.getElementData().length);
    }

    @Test
    public void ensureCapacity_whenMinCapacityEqualsOldCapacity_shouldNotChangeCapacity() {

        customArrayList.ensureCapacity(10);
        assertEquals(10, customArrayList.getElementData().length);
    }

    @Test
    public void ensureCapacity_whenMinCapacityGreaterThanOldCapacity_shouldIncreaseCapacity() {

        customArrayList.ensureCapacity(15);
        assertEquals(16, customArrayList.getElementData().length);
    }

    @Test
    public void ensureCapacity_whenMinCapacityLessThanOldCapacityAndOldCapacityLessThanMinCapacity_shouldIncreaseCapacity() {

        customArrayList.ensureCapacity(5);
        customArrayList.add(1);

        customArrayList.ensureCapacity(15);

        assertEquals(22, customArrayList.getElementData().length);
    }

    @Test
    public void ensureCapacity_whenMinCapacityEqualsOldCapacityAndOldCapacityLessThanMinCapacity_shouldIncreaseCapacity() {

        customArrayList.ensureCapacity(5);
        customArrayList.add(1);
        customArrayList.ensureCapacity(10);

        assertEquals(16, customArrayList.getElementData().length);
    }

    @Test
    public void ensureCapacity_whenMinCapacityGreaterThanOldCapacityAndOldCapacityLessThanMinCapacity_shouldIncreaseCapacity() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        customArrayList.ensureCapacity(5);
        customArrayList.add(1);

        customArrayList.ensureCapacity(20);

        assertEquals(21, customArrayList.getElementData().length);
    }
}
