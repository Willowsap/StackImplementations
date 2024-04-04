package storage;

import java.util.EmptyStackException;

/**
 * Stack Abstract Data Type (ADT) implemented using a Linked List.
 * 
 * @author Willow Sapphire
 * @version 04/04/2024
 */
public class LinkedListStack<T> implements Cloneable
{
    /**
     * Reference to the top item on the stack.
     * Each successive link is the next item down on the stack.
     */
    private Node<T> top;

    /**
     * Tracker for the number of items in the stack.
     * The sole purpose is to make the size method constant time.
     */
    private int manyItems;

    /**
     * Creates a new empty stack.
     */
    public LinkedListStack()
    {
        top = null;
        manyItems = 0;
    }

    /**
     * Retrieves the element at the top of the stack.
     * The element is NOT removed from the stack.
     * 
     * @return the element at the top of the stack
     * @throws EmptyStackException if there are no elements on the stack
     */
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    /**
     * Retrieves an element from the top of the stack.
     * The element retrieved is removed from the stack.
     * 
     * @return the element at the top of the stack
     * @throws EmptyStackException if there are no elements on the stack
     */
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T dataToReturn = top.getData();
        top = top.getLink();
        manyItems--;
        return dataToReturn;
    }

    /**
     * Adds an element to the top of the stack.
     * 
     * @param data the element to add
     */
    public void push(T data)
    {
        top = new Node<>(data, top);
        manyItems++;
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return top == null;
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
    public LinkedListStack<T> clone()
    {
        try
        {
            LinkedListStack<T> clone = (LinkedListStack<T>) super.clone();
            clone.top = top == null ? null : top.copyList();
            return clone;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("Clone is not supported");
        }
        /**
         * Alternative method
         * 
         * LinkedListStack<T> clone = new LinkedListStack<T>();
         * clone.manyItems = manyItems;
         * clone.top = top == null ? null : top.copyList();
         * return clone;
         */
    }
}