// TODO: Review Generics
public class LinkedList<T> {
    public class LinkedListNode<T>
    {
        T value;
        LinkedListNode<T> next;

        public LinkedListNode(T value)
        {
            this.value = value;
        }
    }

    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    // O(1) is time complexity to add to the end of linked list.
    public void add(T value)
    {
        LinkedListNode newNode = new LinkedListNode(value);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            return;
        } else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Time complexity to get node at ith index is O(n)
    public LinkedListNode get(int index)
    {
        LinkedListNode temp = head;
        while(index > 0)
        {
            temp = temp.next;
            index--;
        }
        return temp;
    }
}
