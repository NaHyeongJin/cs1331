package hw5;

public class MyList<E> implements List<E> {

    private final Object[] EMPTY_ELEMENT = {};

    private Object[] elements;
    private int size;

    MyList() {
        this(INITIAL_CAPACITY);
    }

    MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else if (capacity == 0) {
            elements = EMPTY_ELEMENT;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    private Object[] grow() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        return newElements;
    }

    /**
     * Insert element to the back of the list. If the list is is at capacity, double
     * the capacity
     *
     * @param e the element to be added to the list
     * @throws IllegalArgumentException if invalid `E` is given
     */
    @Override
    public void add(E e) {
        if (elements.length == size) {
            elements = grow();
        }
        elements[size] = e;
        size++;
    }

    /**
     * Get an element from the list.
     * 
     * @return E is returning an element of type E for the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     *
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("List range out");
        }
        return (E) elements[index];
    }

    /**
     * Replace all instances of e with replaceWith.
     *
     * @param e           to be replaced in the list
     * @param replaceWith to replace e in the list
     * @throws IllegalArgumentException if one or both invalid `E`'s are passed in
     *                                  the method
     */
    @Override
    public void replace(E e, E replaceWith) {
        // TODO Auto-generated method stub

    }

    /**
     * Removes all instances of element e in the list and returns the count
     *
     * @param e the element to be removed from the list
     * @return int representing the count
     */
    @Override
    public int remove(E e) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Counts the number of times element e occurs in the list
     *
     * @param e the element to be counted in the list
     * @return int representation of the count
     */
    @Override
    public int contains(E e) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Returns if the list is empty or not
     * 
     * @return boolean (true or false) if list is empty or not
     *
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Clears all elements in the list
     *
     */
    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    /**
     * Counts the number of elements in the list
     * 
     * @return int representing the number of elements in the list
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    /**
     * Returns the E[] parameter containing as many non-null elements in the list as
     * it can fit
     * 
     * @param e the array to store all of the non null elements in
     * @return E[] an array that contains the non null elements
     *
     */
    @Override
    public E[] toArray(E[] e) {
        // TODO Auto-generated method stub
        return null;
    }

}
