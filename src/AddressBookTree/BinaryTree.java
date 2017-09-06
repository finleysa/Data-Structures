package AddressBookTree;

public class BinaryTree implements BinaryTreeInterface<BinaryTreeAddress>
{
    private BinaryNode<BinaryTreeAddress> topRoot;

    public BinaryTree() {
        topRoot = null;
    }

    public BinaryTreeAddress insert(String first, String last, String phoneNum, String email) {
        BinaryTreeAddress address = new BinaryTreeAddress(first, last, phoneNum, email);
        // SAF  insert address and return inserted address
        return insert(topRoot, address);
    }

    public BinaryTreeAddress lookup(String first, String last) {
        // SAF  return null if no topRoot
        if (isEmpty()) return null;
        BinaryTreeAddress newAddress = new BinaryTreeAddress(first, last);
        BinaryTreeAddress rootAddress = topRoot.getData();

        // SAF  if lookup address is equal to topROot return
        if (rootAddress.compareTo(newAddress) == 0) {
            return rootAddress;
        }
        // SAF  find address in tree and return if not null
        BinaryNode<BinaryTreeAddress> found = lookup(topRoot, newAddress);
        if (found == null) return null;
        return found.getData();
    }

    public BinaryTreeAddress delete(String first, String last) {
        // SAF  return if no topRoot
        if (isEmpty()) return null;

        // SAF  find address in tree
        BinaryNode<BinaryTreeAddress> foundNode = lookup(topRoot, new BinaryTreeAddress(first, last));
        if(foundNode == null) return null;

        // SAF  remove address from tree and return deleted address
        removeAndReplaceNode(foundNode);
        return foundNode.getData();

    }

    //region Helper functions
    private BinaryTreeAddress insert(BinaryNode<BinaryTreeAddress> node, BinaryTreeAddress newAddress) {
        // SAF  if no topRoot the newAddress becomes topRoot and returns
        if(isEmpty()) {
            topRoot = new BinaryNode<>(newAddress);
            return newAddress;
        }

        // SAF  get topRoot data
        BinaryTreeAddress rootAddress = node.getData();

        // SAF  compare topRoot to address
        int comparison = rootAddress.compareTo(newAddress);

        BinaryNode<BinaryTreeAddress> newEntry = new BinaryNode<>(newAddress);

        if(comparison < 0) {
            // SAF  if newAddress is less than topRoot set leftChild to newAddress
            if(!node.hasLeftChild()) {
                newEntry.setParent(node);
                node.setLeftChild(newEntry);
                node.getLeftChild().setParent(node);
            }
            else {
                node = (BinaryNode<BinaryTreeAddress>) node.getLeftChild();
                return insert(node, newAddress);
            }
        } else if (comparison > 0) {
            // SAF  if newAddress is less than topRoot set rightChild to newAddress
            if(!node.hasRightChild()){
                newEntry.setParent(node);
                node.setRightChild(newEntry);
                node.getRightChild().setParent(node);
            }
            else {
                node = (BinaryNode<BinaryTreeAddress>) node.getRightChild();
                return insert(node, newAddress);
            }
        } else {
            // SAF  if node rootAddress == newEntry set data to newEntry
            node.setData(newAddress);
        }
        return newEntry.getData();
    }

    private BinaryNode<BinaryTreeAddress> lookup(BinaryNode<BinaryTreeAddress> node, BinaryTreeAddress newAddress) {
        BinaryTreeAddress rootAddress = node.getData();
        int comparison = rootAddress.compareTo(newAddress);

        // SAF  recursive lookup of node until found or no children
        if(comparison == 0) {
            return node;
        }
        if(comparison < 0) {
            if(!node.hasLeftChild()) {
                return null;
            }
            else {
                node = (BinaryNode<BinaryTreeAddress>) node.getLeftChild();
                return lookup(node, newAddress);
            }
        } else {
            if (!node.hasRightChild()) {
                return null;
            } else {
                node = (BinaryNode<BinaryTreeAddress>) node.getRightChild();
                return lookup(node, newAddress);
            }
        }
    }

    private BinaryNodeInterface<BinaryTreeAddress> getRightMostChildParent(BinaryNodeInterface<BinaryTreeAddress> node) {
        // SAF  return the rightmost child of node
        BinaryNodeInterface<BinaryTreeAddress> parent = node;
        while(node.hasRightChild()) {
            parent = node;
            node = node.getRightChild();
        }
        return parent;
    }

    private void removeAndReplaceNode(BinaryNode<BinaryTreeAddress> found) {
        if (found.isLeaf()) {
            // SAF  remove node from chain if leaf
            if(found.getParent().getRightChild() == found) {
                found.getParent().setRightChild(null);
            } else {
                found.getParent().setLeftChild(null);
            }
        } else if (found.hasLeftChild()) {
            // SAF remove node from chain and replace with leftChild
            if(found.getParent().getRightChild() == found) {
                found.getParent().setRightChild(found.getLeftChild());
            } else {
                found.getParent().setLeftChild(found.getLeftChild());
            }
        } else if (found.hasRightChild()) {
            // SAF remove node from chain and replace with rightChild
            if(found.getParent().getRightChild() == found) {
                found.getParent().setRightChild(found.getRightChild());
            } else {
                found.getParent().setLeftChild(found.getRightChild());
            }
        } else {
            // SAF  if node not a leaf
            // SAF  change left child node to left child node's right most node
            // SAF  gets the child closest to the removed nodes value
            BinaryNodeInterface<BinaryTreeAddress> parent = getRightMostChildParent(found.getLeftChild());
            BinaryNodeInterface<BinaryTreeAddress> rightMostNode = parent.getRightChild();

            // SAF  replace node with rightMostNode
            found.setData(rightMostNode.getData());
            // SAF  remove rightMostNode from old position
            parent.setRightChild(null);
        }
    }

    boolean isEmpty() {
        // SAF  returns null if tree is empty
        return topRoot == null;
    }
    // SAF endregion
}
