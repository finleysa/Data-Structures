package AddressBookTree;

import sun.reflect.generics.tree.Tree;

class BinaryNode<TreeAddress> implements BinaryNodeInterface<TreeAddress>
{
    private TreeAddress data;
    private BinaryNodeInterface<TreeAddress> left;
    private BinaryNodeInterface<TreeAddress> right;
    private BinaryNodeInterface<TreeAddress> parent;

    //region Constructors
    public BinaryNode() {
        this(null);
    }

    public BinaryNode(TreeAddress dataPortion)
    {
        this(dataPortion, null, null);
    }

    public BinaryNode(TreeAddress dataPortion, BinaryNode<TreeAddress> leftChild,
                      BinaryNode<TreeAddress> rightChild)
    {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    }
    //endregion

    //region Properties
    public TreeAddress getData()
    {
        return (TreeAddress) data;
    }

    public void setData(TreeAddress newData)
    {
        data = newData;
    }

    public BinaryNodeInterface<TreeAddress> getLeftChild()
    {
        return left;
    }

    public BinaryNodeInterface<TreeAddress> getRightChild() {
        return right;
    }

    public BinaryNodeInterface<TreeAddress> getParent() {
        return parent;
    }

    public void setParent(BinaryNodeInterface<TreeAddress> node) {
        this.parent = node;
    }

    public void setLeftChild(BinaryNodeInterface<TreeAddress> leftChild)
    {
        this.left = leftChild;
    }

    public void setRightChild(BinaryNodeInterface<TreeAddress> rightChild) { this.right = rightChild; }

    public boolean hasLeftChild()
    {
        return this.left != null;
    }

    public boolean hasRightChild()
    {
        return this.right != null;
    }

    public boolean isLeaf()
    {
        return (this.left == null) && (this.right == null);
    }

    //endregion

}