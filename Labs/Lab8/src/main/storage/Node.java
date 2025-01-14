package storage;
/**
 * @author ??? 
 */
public class Node<T> 
{
    // Invariant of the DoubleNode class:
    // 1. The node's double data is in the instance variable data.
    // 2. For the final node of a list, the link part is null.
    // Otherwise, the link part is a reference to the
    // next node of the list.

    /** The value associated with this node in the list. */
    private T data;

    /**
     * The link to the next node in the list, or null if this is the last node
     * in the the list.
     */
    private Node<T> link;

    /**
     * Initializes a node with a specified initial data and link to the next
     * node. Note that the initial link may be the null reference, which
     * indicates that the new node has nothing after it.
     * 
     * @param data the initial data of this new node.
     * @param link a reference to the node after this new node &ndash; this
     *      reference may be null to indicate that there is no node after
     *      this new node.
     * 
     * @postcondition This node contains the specified data
     *      and link to the next node.
     */
    public Node(T data, Node<T> link)
    {
        this.data = data;
        this.link = link;
    }

    /**
     * Constructor takes an initial data value.
     * 
     * @param data The data value for the new node.
     */
    public Node(T data)
    {
        this(data, null);
    }

    /**
     * No-args constructor.
     */
    public Node()
    {
        this(null, null);
    }

    

    /**
     * Add a new node after this node.
     * 
     * @param data The data to place in the new node.
     * 
     * @postcondition A new node has been created and placed after this node.
     *      The data for the new node is data. Any other nodes that
     *      used to be after this node are now after the new node.
     */
    public void addNodeAfter(T data)
    {
        this.link = new Node(data, this.link);
    }

    /**
     * Removes the node after this node in a linked list.
     * 
     * @precondition This node must not be the tail node of the list.
     * 
     * @postcondition The node after this node has been removed from the linked
     *      list. If there were further nodes after that one, they are
     *      still present on the list.
     * 
     * @throws NullPointerException Indicates that this was the tail
     *      node of the list, so there is nothing after it to remove.
     */
    public void removeNodeAfter() throws NullPointerException
    {
        /*
         * Thanks to Daniel Wilkins (CS 2440 student, Fall 2015) for finding 
         * an error in checking for the last element in the list. Previously, 
         * it checked "if (link.link == null)."
         */
        link = link.link;
    }

    /**
     * Accessor method to get the data from this node.
     * 
     * @return the data from this node.
     */
    public T getData()
    {
        return data;
    }

    /**
     * Gets a reference to the next node after this node.
     * 
     * @return a reference to the node after this node (or the null
     *         reference if there is nothing after this node).
     */
    public Node<T> getLink()
    {
        return link;
    }

    /**
     * Sets the data in this node of a linked list.
     * 
     * @param data
     *            the new data to place in this node
     * 
     * @postcondition The data of this node has been set to data.
     */
    public void setData(T data)
    {
        this.data = data;
    }

    /**
     * Set the link to the next node after this node.
     * 
     * @param link
     *            a reference to the node that should appear after this node in
     *            the linked list, or the null reference if there is no node
     *            after this node.
     * 
     * @postcondition The link to the node after this node has been set to
     *                link. Any other node that used to be in this link is no
     *                longer connected to this node.
     */
    public void setLink(Node<T> link)
    {
        this.link = link;
    }
}
