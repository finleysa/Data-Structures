package AddressBookTree;

interface BinaryNodeInterface<T>
{
    /** Retrieves the data portion of this node.
     @return the object in the data portion of the node */
    public T getData();

    /** Sets the data portion of this node.
     @param newData  the data object */
    public void setData(T newData);

    public BinaryNodeInterface<T> getParent();
    public void setParent(BinaryNodeInterface node);


        /** Retrieves the left child of this node.
         @return the node that is this node�s left child */
    public BinaryNodeInterface<T> getLeftChild();

    /** Retrieves the right child of this node.
     @return the node that is this node�s right child */
    public BinaryNodeInterface<T> getRightChild();

    /** Sets the node�s left child to a given node.
     @param leftChild  a node that will be the left child */
    public void setLeftChild(BinaryNodeInterface<T> leftChild);

    /** Sets the node�s right child to a given node.
     @param rightChild  a node that will be the right child */
    public void setRightChild(BinaryNodeInterface<T> rightChild);

    /** Detects whether this node has a left child.
     @return true if the node has a left child */
    public boolean hasLeftChild();

    /** Detects whether this node has a right child.
     @return true if the node has a right child */
    public boolean hasRightChild();

    /** Detects whether this node is a leaf.
     @return true if the node is a leaf */
    public boolean isLeaf();

} // end BinaryNodeInterface
