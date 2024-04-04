package storage;

/**
 * A simple, generic node class.
 * 
 * @author Willow Sapphire
 * @version 04/04/2024
 */
public class Node<T>
{
    /**
     * The data stored in this node.
     */
    private T data;

    /**
     * The next node in a potential chain of nodes.
     */
    private Node<T> link;

    /**
     * Creates a new node with no data and no link.
     */
    public Node()
    {
        this(null, null);
    }

    /**
     * Creates a new node with the given data and no link.
     * 
     * @param data the data to store in this node
     */
    public Node(T data)
    {
        this(data, null);
    }

    /**
     * Creates a new node with the given data and link.
     * 
     * @param data the data stored in the node.
     * @param link the node to connect to this one.
     */
    public Node(T data, Node<T> link)
    {
        setData(data);
        setLink(link);
    }

    /**
     * Sets the data of this node.
     * 
     * @param data the data to store in this node
     */
    public void setData(T data)
    {
        this.data = data;
    }

    /**
     * Sets the node connected to this one.
     * 
     * @param link the node to connect
     */
    public void setLink(Node<T> link)
    {
        this.link = link;
    }

    /**
     * Gets the data stored in this node.
     * 
     * @return data
     */
    public T getData()
    {
        return this.data;
    }

    /**
     * Getter for the next node.
     * 
     * @return a reference to the node connected to this one
     */
    public Node<T> getLink()
    {
        return this.link;
    }

    /**
     * Copies this node and the entire list it is connected to.
     * 
     * @return a copy of this node with every node in its chain copied
     */
    public Node<T> copyList()
    {
        Node<T> head = new Node<T>(this.getData());
        for (Node<T> t = this.getLink(), c = head; t.getLink() != null; t = t.getLink(), c = c.getLink())
        {
            c.setLink(new Node<T>(t.getData()));
        }
        return head;
    }
}
