package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SortedLinkedList<T extends Comparable<? super T>> implements Iterable<T> {

    private Node<T> head;
    private int length;

    private class SLLIterator implements Iterator<T> {
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        SLLIterator(Node<T> FirstNode) {
            currNode = FirstNode;
            nextNode = currNode.getLink();
            prevNode = null;
            calledNext = false;
        }

        public boolean hasNext() 
        {
            if (nextNode != null) {return true;}
            return false;
        }

        public T next() throws NoSuchElementException
        {
            if (nextNode == null) {
                throw new NoSuchElementException("Nothing to iterate");
            }
            T data = currNode.getData();
            currNode = nextNode;
            nextNode = nextNode.getLink();
            prevNode = currNode;
            calledNext = true;
            return data;
        }
    
        public void remove() throws IllegalStateException
        {
            if (!calledNext)
            {
                throw new IllegalStateException("No element to remove");
            }
            calledNext = false;
            
        }
    }

    public SortedLinkedList() {
        head = null; 
        length = 0;
    }

    public void add(T entry) {
        Node<T> node = new Node<T>(entry);
        if (head == null) 
        {
            head = node;
            length++;
            return;
        }
        if (entry.compareTo(head.getData()) <= 0)
        {
            node.setLink(head);
            head = node;
            length++;
            return;
        }
        for (Node<T> pointer = head; pointer != null; pointer = pointer.getLink())
        {
            if (entry.compareTo(pointer.getData()) <= 0)
            {
                Node<T> prev = getPrevious(pointer.getData());
                node.setLink(prev.getLink());
                prev.setLink(node);
                length++;
                break;
            }
        }
    }

    public T remove(int position) 
    {
        if (position >= length) {
            return null;
        }
        Node<T> pointer = head;
        int count = 0;
        while (count < position) {
            pointer = pointer.getLink();
            count++;
        }
        Node<T> retNode = pointer;
        System.out.println(String.format("retNode: %s, position: %s, count: %s", retNode.getData(), position, count));
        pointer.setLink(pointer.getLink());
        
        // DOES THGAT WORK %^^^ I DK!!!
        length--;
        return retNode.getData();
    }

    public void clear() 
    {
        head = null;
        length = 0;
    }

    public T getEntry(int position) 
    {
        int count = 0;
        for (Node<T> node = head; node != null; node = node.getLink())
        {
            if (count == position)
            {
                return node.getData();
            }
            count++;
        }
        return null;
    }

    public int getPosition(T entry) throws IllegalArgumentException
    {
        int count = 0;
        Node<T> pointer = head;
        while (pointer != null) 
        {
            if (pointer.getData() == entry)
            {
                return count;
            }
            count++;
        }
        throw new IllegalArgumentException();
    }

    public boolean contains(T entry) 
    {
        Node<T> pointer = head;
        while (pointer != null)
        {
            if (pointer.getData() == entry)
            {
                return true;
            }
        }
        return false;
    }

    public int getLength() 
    {return this.length;}

    public boolean isEmpty() 
    {
        if (length == 0)
        {
            return true;
        }
        return false;
    }

    public void display() 
    {
        Node<T> pointer = head;
        while (pointer != null)
        {
            System.out.print(pointer.getData());
        }
        System.out.print("\n");
    }

    public Iterator<T> iterator() {return new SLLIterator(head);};

    private Node<T> getPrevious(T entry) 
    {
        if (entry == head.getData()) 
        {
            return null;
        }
        Node<T> prev = head;
        Node<T> curr = head.getLink();
        while (curr != null)
        {
            if (curr.getData().compareTo(entry) > 0 && prev.getData().compareTo(entry) < 0) 
            {
                return prev;
            }
            prev = curr;
            curr = curr.getLink();
        }
        return null;
    }

}
