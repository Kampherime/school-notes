package storage;

public class DoubleLinkedSeq implements Cloneable
{
    private int manyNodes;
    private DoubleNode tail;
    private DoubleNode head;
    private DoubleNode cursor;
    private DoubleNode precursor;

    public DoubleLinkedSeq()
    {
        this.manyNodes = 0;
        this.tail = null;
        this.head = null;
        this.cursor = null;
        this.precursor = null;
    }

    public int size() 
    {
        return this.manyNodes;
    }

    public void addAfter(double data) 
    {
        DoubleNode node = new DoubleNode(data);
        if (manyNodes == 0)
        {
            cursor = node;
            head = node;
            tail = node;
            manyNodes++;
        }
        else if ((this.cursor == null && this.head != null) || cursor == tail)
        {
            cursor = node;
            tail.setLink(node);
            tail = node;
            manyNodes++;
        }
        else if (this.cursor != null)
        {
            node.setLink(cursor.getLink());
            cursor.setLink(node);
            precursor = cursor;
            cursor = node;
            manyNodes++;
        }
    }
    public void addBefore(double data) 
    {    
        DoubleNode node = new DoubleNode(data);
        if (manyNodes == 0)
        {
            cursor = node;
            head = node;
            tail = node;
        }
        else if ((this.cursor == null && this.head != null) || cursor == head)
        {
            node.setLink(head);
            head = node;
            cursor = node;
        }
        else if (this.cursor != null)
        {
            if (precursor != null) 
            {
                precursor.setLink(node);
            }
            node.setLink(cursor);
            cursor = node;
        }
        manyNodes++;
    }
    public void addAll(DoubleLinkedSeq addend) 
    {
        if (addend == this)
        {
            DoubleLinkedSeq seqClone = addend.clone();
            DoubleNode node = seqClone.head;
            while (node != null)
            {
                this.tail.setLink(node);
                tail = node;
                node = node.getLink();
            }
        }
        else
        {
            DoubleNode node = addend.head;
            while (node != null)
            {
                this.tail.setLink(node);
                tail = node;
                node = node.getLink();
            }
        }
    }
    public boolean isCurrent() 
    {
        if(cursor != null)
        {
            return true;
        }
        return false;
    }
    public void start() 
    {
        cursor = head;
        precursor = null;
    }
    public void advance() throws IllegalStateException
    {
        if (cursor == null) 
        {
            throw new IllegalStateException("No current element");
        }
        precursor = cursor; 
        cursor = cursor.getLink();
    }
    public double getCurrent() throws IllegalStateException 
    {
        if (cursor == null) 
        {
            throw new IllegalStateException("No current element");            
        }
        return cursor.getData();
    } 
    public void removeCurrent() throws IllegalStateException
    { 
        if (cursor == null) 
        {
            throw new IllegalStateException("No current element");            
        }
        if (precursor != null)
        {
            cursor = cursor.getLink();
            precursor.setLink(cursor);
        }
        else {
            cursor = cursor.getLink();
            head = cursor;
        }
        manyNodes--;
    }
    public DoubleLinkedSeq clone() 
    {
        DoubleLinkedSeq newSeq = new DoubleLinkedSeq();
        newSeq.manyNodes = manyNodes;
        
        if (cursor != null && precursor != null)
        {
            DoubleNode[] l1 = DoubleNode.listPart(head, precursor);
            DoubleNode[] l2 = DoubleNode.listPart(cursor, tail);
            newSeq.head = l1[0];
            newSeq.precursor = l1[1];
            newSeq.cursor = l2[0];
            newSeq.tail = l2[0];

            newSeq.precursor.setLink(newSeq.cursor);
        }
        else
        {
            DoubleNode[] headntail = DoubleNode.listCopyWithTail(head);
            if (headntail.length > 0)
            {
                newSeq.head = headntail[0];
                newSeq.tail = headntail[1];
                if (cursor == head) {newSeq.cursor = cursor;}
            }
        }
        return newSeq;
    }
    public String toString()
    {
        if (manyNodes == 0) {
            return "<>";
        }
        DoubleNode node = head;
        String return_string = "<";
        while (node.getLink() != null) {
            System.out.println(node.getLink());
            if (node == cursor) {
                return_string += String.format("[%.1f], ", node.getData()); 
            }
            else {
                return_string += String.format("%.1f, ", node.getData());
            }
            node = node.getLink();
            if (node == head) {
                break;
            }
        }
        if (node == cursor) {
            return_string += String.format("[%.1f]>", node.getData());
        }
        else {
            return_string += String.format("%.1f>", node.getData());
        }
        return return_string;
    }

    public boolean equals(Object other) 
    { 
        if (!(other instanceof DoubleLinkedSeq))
        {
            return false;
        }
        DoubleLinkedSeq otherSeq = (DoubleLinkedSeq) other;
        if (otherSeq.manyNodes != this.manyNodes)
        {
            return false;
        }
        if ((cursor == null || precursor == null) || 
        (otherSeq.cursor == null || otherSeq.precursor == null))
        {
            if (cursor == null && otherSeq.cursor == null)
            {
                return true;
            }
            if ((precursor == null && otherSeq.precursor == null) &&
             cursor.getData() == otherSeq.cursor.getData()) {
                return true;
            }
            return false;
        }
        if (otherSeq.cursor.getData() != this.cursor.getData())
        {
            return false;
        }
        if (otherSeq.precursor.getData() != precursor.getData())
        {
            return false;
        }
        DoubleNode node = head;
        DoubleNode otherNode = otherSeq.head;
        while (node != null && otherNode != null)
        {
            if (otherNode.getData() != node.getData())
            {
                return false;
            }
            node = node.getLink();
            otherNode = otherNode.getLink();
        }
        return true;
    }
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2) throws NullPointerException
    {
        if (s1 == null || s2 == null)
        {
            throw new NullPointerException("One of the sequences was null.");
        }
        if (s2.head == null) {
            return s1;
        }
        if (s1.head == null) {
            return s2;
        }
        DoubleLinkedSeq newSeq = new DoubleLinkedSeq();
        System.out.println(s1);
        System.out.println(s2);
        s1.tail.setLink(s2.head);
        newSeq.head = s1.head;
        newSeq.tail = s2.tail;
        newSeq.cursor = null;
        newSeq.precursor = null;
        newSeq.manyNodes = s1.manyNodes + s2.manyNodes;
        return newSeq;
    }
}
