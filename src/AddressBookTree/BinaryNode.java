package AddressBookTree;

class BinaryNode<AddressMate> implements BinaryNodeInterface<AddressMate>
{
    private AddressMate data;
    private BinaryNodeInterface<AddressMate> left;
    private BinaryNodeInterface<AddressMate> right;
    private BinaryNodeInterface<AddressMate> parent;

    public BinaryNodeInterface<AddressMate> getParent() {
        return parent;
    }

    public void setParent(BinaryNodeInterface node) {
        this.parent = node;
    }

    //region Constructors
    public BinaryNode() {
        this(null);
    }

    public BinaryNode(AddressMate dataPortion)
    {
        this(dataPortion, null, null);
    }

    public BinaryNode(AddressMate dataPortion, BinaryNode<AddressMate> leftChild,
                      BinaryNode<AddressMate> rightChild)
    {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    }
    //endregion

    //region Properties
    public AddressMate getData()
    {
        return data;
    }

    public void setData(AddressMate newData)
    {
        data = newData;
    }

    public BinaryNodeInterface<AddressMate> getLeftChild()
    {
        return left;
    }

    public BinaryNodeInterface<AddressMate> getRightChild() {
        return right;
    }

    public void setLeftChild(BinaryNodeInterface<AddressMate> leftChild)
    {
        left = (BinaryNode<AddressMate>)leftChild;
    }

    public void setRightChild(BinaryNodeInterface<AddressMate> rightChild) { right = (BinaryNode<AddressMate>)rightChild; }

    public boolean hasLeftChild()
    {
        return left != null;
    }

    public boolean hasRightChild()
    {
        return right != null;
    }

    public boolean isLeaf()
    {
        return (left == null) && (right == null);
    }
    //endregion

}