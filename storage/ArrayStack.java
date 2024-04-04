package storage;

import java.util.EmptyStackException;

/**
 * Stack Abstract Data Type (ADT) implemented using an Array.
 * 
 * @author Willow Sapphire
 * @version 04/04/2024
 */
public class ArrayStack<T> implements Cloneable
{
    /**
     * The capacity of the array to use when none is provided.
     */
    public static final int DEFAULT_CAPACITY = 10;

    /**
     * Items in the stack. The bottom of the stack is data[0].
     * The top of the stack is data[manyItems - 1].
     */
    private Object[] data;

    /**
     * Tracks the number of items in the stack.
     */
    private int manyItems;

    /**
     * Creates a new empty stack with default capacity.
     */
    public ArrayStack()
    {
        data = new Object[DEFAULT_CAPACITY];
        manyItems = 0;
    }

    /**
     * Creates a new empty stack with a provided capacity.
     * Note that this constructor exposes to the user that an array is being used.
     * 
     * @param initialCapacity the capacity to set the array to.
     */
    public ArrayStack(int initialCapacity)
    {
        data = new Object[initialCapacity];
        manyItems = 0;
    }

    /**
     * Retrieves the element at the top of the stack.
     * The element is NOT removed from the stack.
     * 
     * @return the element at the top of the stack
     * @throws EmptyStackException if there are no elements on the stack
     */
    @SuppressWarnings("unchecked")
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return (T) data[manyItems];
    }

    /**
     * Retrieves an element from the top of the stack.
     * The element retrieved is removed from the stack.
     * 
     * @return the element at the top of the stack
     * @throws EmptyStackException if there are no elements on the stack
     */
    @SuppressWarnings("unchecked")
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return (T) data[manyItems--];
    }

    /**
     * Adds an element to the top of the stack.
     * 
     * @param data the element to add
     */
    public void push(T item)
    {
        if (size() == getCapacity())
        {
            ensureCapacity(size() * 2 + 1);
        }
        data[manyItems++] = item;
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return manyItems == 0;
    }

    /**
     * Getter for the number of elements in the stack.
     * 
     * @return the number of elements in the stack.
     */
    public int size()
    {
        return manyItems;
    }

    /**
     * Creates a deep copy of the stack.
     * Objects stored in the stack do not get deep copied.
     * 
     * @return the cloned stack.
     */
    @Override
    @SuppressWarnings("unchecked")
    public ArrayStack<T> clone()
    {
        try
        {
            ArrayStack<T> clone = (ArrayStack<T>) super.clone();
            System.arraycopy(data, 0, clone.data, 0, manyItems);
            return clone;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("Clone is not supported");
        }
        /**
         * Alternative method
         * 
         * ArrayStack<T> clone = new ArrayStack<T>();
         * clone.manyItems = manyItems;
         * System.arraycopy(data, 0, clone.data, 0, manyItems);
         * return clone;
         */
    }

    /*
     * The following three methods are specific to the array implementation.
     * One could argue that they should be private so that users do not know the
     * underlying implementation. However, making them public allows the users
     * to control the structure in more detail.
     */

    /**
     * Getter for the capacity of the data array.
     * 
     * @return data.length
     */
    public int getCapacity()
    {
        return data.length;
    }

    /**
     * Compare the capacity of data to the provided capacity.
     * If the capacity provided is greater, data is expanded to that size.
     * 
     * @param capacity the size desired for the data array.
     */
    public void ensureCapacity(int capacity)
    {
        if (capacity > getCapacity())
        {
            Object[] newData = new Object[capacity];
            for (int i = 0; i < manyItems; i++)
            {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    /**
     * Reduces the size of the data array to manyItems.
     */
    public void trimToSize()
    {
        Object[] newData = new Object[manyItems];
        for (int i = 0; i < manyItems; i++)
        {
            newData[i] = data[i];
        }
        data = newData;
    }
}