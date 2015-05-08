public class LinkedList 
{
    private Node head;
    private int listCount;

    public LinkedList()
    {
        head = new Node(null);
        listCount = 0;
    }

    public int size()
    {
        return listCount;
    }

    // Add node to the end of the LinkedList
    public void add(Node end)
    {
        Node current = head;

        while(current.getNext() != null)
        {
            current = current.getNext();
        }

        current.setNext(end);
        listCount++;
    }

    // Insert node at the specified index
    public void add(Node n, int index)
    {
        Node current = head;
        for(int i=0; i<index-1; i++)
        {
            current = current.getNext();
        }

        Node temp = current.getNext();
        current.setNext(n);
        n.setNext(temp);
        listCount++;
    }

    public boolean remove(int index)
    {
        // If the index is outside of the linkedList,
        // do nothing
        if(index>size() || index < 1)
        {
            return false;
        }

        Node current = head;
        for(int i=0; i<index-1; i++)
        {
            current = current.getNext();
        }

        Node rem = current.getNext();
        current.setNext(rem.getNext());
        listCount--;
        return true;
    }

    public Object get(int index)
    {
        // If the index is outside of the linkedList,
        // return null
        if(index>size() || index < 1)
        {
            return null;
        }

        Node current = head;
        for(int i=0; i<index; i++)
        {
            current = current.getNext();
        }

        return current.getData();
    }

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();

        int n_nodes = 10;
        for(Integer i=0; i<n_nodes; i++)
        {
            Node n = new Node(i);
            ll.add(n);
        }

        for(Integer i=1; i<=ll.size(); i++)
        {
            System.out.println(ll.get(i));
        }

    }
}

class Node 
{
    private Node next;
    private Object data;

    public Node(Object _data)
    {
        next = null;
        data = _data;
    }

    public Node(Object _data, Node _next)
    {
        next = _next;
        data = _data;
    }

    public Object getData()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node _next)
    {
        next = _next;
    }
}

