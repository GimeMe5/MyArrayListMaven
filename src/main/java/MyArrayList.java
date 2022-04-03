import java.util.Iterator;

/**
 * The class is a self-expanding list with an array at the base
 *
 * @version 1.0
 * @see MyList
 */
public class MyArrayList<T> implements MyList<T> {
    /**
     * field indicates the default capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * field indicates the maximum capacity
     */
    private static final int MAX_CAPACITY = Integer.MAX_VALUE;

    /**
     * field with base array
     */
    private T[] array;
    /**
     * field indicates current capacity
     */
    private int capacity;
    /**
     * field indicates current size
     */
    private int size;

    /**
     * Default constructor without arguments
     * creates {@link MyArrayList} with default capacity
     *
     * @see MyArrayList
     */
    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = (T[]) new Object[capacity];
    }

    /**
     * Constructor with current capacity
     *
     * @param capacity - initial capacity
     * @see MyArrayList
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <=0");
        } else {
            this.capacity = capacity;
            array = (T[]) new Object[capacity];
        }
    }

    /**
     * Method creates a new array of a larger size and copies elements into it
     */
    private void grow() {
        int newCapacity;
        if (capacity == MAX_CAPACITY) {
            throw new OutOfMemoryError();
        } else if (capacity > (int) (capacity * 1.5 + 1)) {
            newCapacity = MAX_CAPACITY;
        } else {
            newCapacity = (int) (capacity * 1.5 + 1);
        }
        capacity = newCapacity;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * Method adds elements to the internal array
     *
     * @param e - new element
     */
    @Override
    public boolean add(T e) {
        if (capacity == size) {
            grow();
        }
        array[size] = e;
        size++;
        return true;
    }

    /**
     * Method for getting element from array
     *
     * @param index - index of element in internal array
     */
    @Override
    public T get(int index) {
        return array[index];
    }

    /**
     * Method for remove element from internal array
     * and shift all subsequent elements to the left
     *
     * @param index - index of element in internal array
     */
    @Override
    public boolean remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, array.length - (index + 1));
        size--;
        return true;
    }

    /**
     * Method checks if there is an element in internal array
     *
     * @param e - element for check
     */
    @Override
    public boolean contains(T e) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method returns the number of occupied array cells
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method returns {@link Iterator}
     *
     * @see Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                return array[cursor++];
            }
        };
    }

//    /**
//     * Method for initiate quick sort {@link Comparable} elements
//     *
//     * @see Comparable
//     * @see MyArrayList#quickSort(Comparable[], int, int)
//     */
//    public void qSort() {
//        T[] source = (T[]) this.array;
//        int left = 0;
//        int right = size;
//        quickSort(source, left, right);
//    }
//
//    /**
//     * Method for quick sort {@link Comparable} elements
//     *
//     * @see Comparable
//     */
//    public <T extends Comparable<T>> void quickSort(T[] source, int left, int right) {
//        int leftMarker = left;
//        int rightMarker = right;
//        T pivot = source[(leftMarker + rightMarker) / 2];
//        do {
//            while (pivot.compareTo(source[leftMarker]) > 0) {
//                leftMarker++;
//            }
//            while (pivot.compareTo(source[rightMarker]) < 0) {
//                rightMarker--;
//            }
//            if (leftMarker <= rightMarker) {
//                if (leftMarker < rightMarker) {
//                    swap(source, leftMarker, rightMarker);
//                }
//                leftMarker++;
//                rightMarker--;
//            }
//        } while (leftMarker <= rightMarker);
//        if (leftMarker < right) {
//            quickSort(source, leftMarker, right);
//        }
//        if (left < rightMarker) {
//            quickSort(source, left, rightMarker);
//        }
//    }

    /**
     * Method swap two elements in array
     */
    private <T> void swap(T[] array, int wall, int currentElement) {
        T temp = array[wall];
        array[wall] = array[currentElement];
        array[currentElement] = temp;
    }
}
