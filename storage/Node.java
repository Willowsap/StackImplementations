package storage;

public class Node<T>
{
    private T data;
    private Node<T> link;

    public Node()
    {
        this(null, null);
    }

    public Node(T data)
    {
        this(data, null);
    }

    public Node(T data, Node<T> link)
    {
        setData(data);
        setLink(link);
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setLink(Node<T> link)
    {
        this.link = link;
    }

    public T getData()
    {
        return this.data;
    }

    public Node<T> getLink()
    {
        return this.link;
    }

    public Node<T> copyList()
    {
        Node<T> head = new Node<T>(this.getData());
        for (Node<T> t = this, c = head; t.getLink() != null; t = t.getLink(), c = c.getLink())
        {
            c.setLink(new Node<T>(t.getData()));
        }
        return head;
    }
}
