import java.util.ArrayList;
import java.util.List;

// HashTable (HashMap) implementation using Separate Chaining (for collisions)
// References: https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
public class HashTable<K,V>
{
    // This class is not necessary. Can use Java's LinkedList instead.
    public class HashNode<K,V>
    {
        K key;
        V value;

        // References to next node
        HashNode<K, V> next;

        // Constructor
        public HashNode(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private List<HashNode<K, V>> bucketArray;

    private int numBuckets;

    private int size;

    public HashTable()
    {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for(int i = 0; i < numBuckets; i++) bucketArray.add(null);
    }

    public void add(K key, V value)
    {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Check if the key is already in the table
        while(head != null)
        {
            if(head.key.equals(key))
            {
                head.value = value;
                return;
            }

            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // Load Factor
        if((1.0*size)/numBuckets >= 0.7)
        {
            List<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = numBuckets * 2;
            size = 0;
            for(int i = 0; i < numBuckets; i++) bucketArray.add(null);

            for(HashNode<K, V> headNode: temp)
            {
                while(headNode != null)
                {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V remove(K key)
    {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;

        while(head != null)
        {
            if(head.key.equals(key))
            {
                break;
            }

            prev = head;
            head = head.next;
        }

        if(head == null)
        {
            return null;
        }
        else
        {
            size--;
            if(prev != null)
            {
                prev. next = head.next;
            }
            else
            {
                bucketArray.set(bucketIndex, head.next);
            }

            return head.value;
        }
    }

    public V get(K key)
    {
        int bucketIndex = getBucketIndex(key);

        HashNode<K,V> head = bucketArray.get(bucketIndex);

        while(head != null)
        {
            if(head.key.equals(key))
            {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = Math.abs((hashCode % numBuckets));
        return index;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}