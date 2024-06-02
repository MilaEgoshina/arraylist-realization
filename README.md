# CustomArrayList

CustomArrayList is an implementation of an ArrayList data structure in Java. It is not thread-safe. It also includes a quicksort algorithm for sorting the elements within the CustomArrayList.

## Usage

1. Clone the repository:

```
git clone https://github.com/MilaEgoshina/arraylist-realization
```

2. Import the CustomArrayList class into your Java project.

3. Create a new instance of CustomArrayList:

```
CustomArrayList<Integer> list = new CustomArrayList<>();
```

4. Add elements to the list:

```
list.add(5);
list.add(3);
list.add(8);
list.add(1);
```

5. Sort the list using the quicksort algorithm:

```java
QuickSort.sort(list,Comparator.naturalOrder());
```

## API

### CustomArrayList Class

#### Constructors

- `CustomArrayList()`: Constructs an instance of CustomArrayList with the default capacity.
- `CustomArrayList(int capacity)`:Constructs an instance of CustomArrayList with the specified capacity.

#### Methods

- `add(E element)`: Adds the specified element to the end of the list.
- `add(int index, T element)`: Inserts the specified element at the specified index in the list.
- `get(int index)`: Returns the element at the specified index in the list.
- `size()`: Returns the number of elements in the list.
- `addAll(T[] elements)`: Adds all the elements in the specified array to the end of the list.
- `remove(int index)`: Removes the element at the specified index in the list.
- `remove(T element)` : Removes the first occurrence of the specified element from the list.
- `contains(T element)` : Checks if the list contains the specified element.
- `set(int index, T element)` : Replaces the element at the specified index with the specified element.
- `indexOf(T element)` : Returns the index of the first occurrence of the specified element in the list.
- `clear()` : Removes all elements from the list, leaving it empty.

### Documentation

Please, if you want to see the full documentation on English for this project, just open this [link](https://milaegoshina.github.io/arraylist-realization/).


## QuickSort Algorithm

The `QuickSort` class provides an implementation of the QuickSort algorithm to sort the elements in a list. The class contains a `sort` method that takes an CustomArrayList of any type and sorts it.

### Usage

To use the `QuickSort` algorithm, you can create an instance of the class and call the `sort` method like this:

```
CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

customArrayList.add(3);
customArrayList.add(1);
customArrayList.add(5);
customArrayList.add(2);
QuickSort.sort(customArrayList,Comparator.naturalOrder());
```

## Unit Testing

Unit tests for both the `CustomArrayList` and `QuickSort` classes can be found in the `src/test` directory. JUnit 5 is used for writing and running the tests. Each test follows the given-when-then structure to ensure clarity and correctness of the tests.

## Given-When-Then Structure

When writing unit tests using JUnit, it is good practice to follow the Given-When-Then structure to organize your test cases. This structure helps in clearly defining the setup (Given), execution (When), and verification (Then) phases of your test cases.

An example of the Given-When-Then structure in a test case:

```
@Test
void testAddElement() {
    // Given
    CustomArrayList<Integer> list = new CustomArrayList<>();
    int element = 5;

    // When
    list.add(element);

    // Then
    assertEquals(element, list.get(0));
}
```

## Contributing

If you would like to contribute to this project, feel free to submit a pull request. Remember to follow the existing code style and conventions.

Thank you for using CustomArrayList!