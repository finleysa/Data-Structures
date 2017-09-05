package AddressBookTree;

import AddressBookHashBucket.AddressMate;

import javax.swing.tree.TreeNode;

public class BinaryTree
{
    private BinaryNode topRoot;

    public BinaryTree() {
        topRoot = null;
    }

    boolean isEmpty() {
        return topRoot == null;
    }

    //region Insert
    public TreeAddressMate insert(String first, String last, String phoneNum, String email) {
        TreeAddressMate address = new TreeAddressMate(first, last, phoneNum, email);
        return insert(topRoot, address);
    }

    private TreeAddressMate insert(BinaryNode node, TreeAddressMate newAddress) {
        if(isEmpty()) {
            topRoot = new BinaryNode(newAddress);
            return newAddress;
        }
        TreeAddressMate rootAddress = (TreeAddressMate)node.getData();
        if(rootAddress == null) return null;

        int comparison = rootAddress.compareTo(newAddress);

        @SuppressWarnings("unchecked")
        BinaryNode newEntry = new BinaryNode(newAddress);
        if(comparison < 0) {
            if(!node.hasLeftChild()) {
                newEntry.setParent(node);
                node.setLeftChild(newEntry);
                node.getLeftChild().setParent(node);
            }
            else {
                node = (BinaryNode) node.getLeftChild();
                return insert(node, newAddress);
            }
        } else if (comparison > 0) {
            if(!node.hasRightChild()){
                newEntry.setParent(node);
                node.setRightChild(newEntry);
                node.getRightChild().setParent(node);
            }
            else {
                node = (BinaryNode) node.getRightChild();
                return insert(node, newAddress);
            }
        } else {
            node.setData(newAddress);
        }
        return (TreeAddressMate)newEntry.getData();
    }

    public TreeAddressMate lookup(String first, String last) {
        if (isEmpty()) return null;
        TreeAddressMate newAddress = new TreeAddressMate(first, last);
        TreeAddressMate rootAddress = (TreeAddressMate) topRoot.getData();

        if (rootAddress.compareTo(newAddress) == 0) {
            return rootAddress;
        }

        BinaryNode found = lookup(topRoot, newAddress);
        if (found == null){
            return null;
        }
        return (TreeAddressMate)lookup(topRoot, newAddress).getData();
    }

    //endregion
    
    private BinaryNode lookup(BinaryNode node, TreeAddressMate newAddress) {
        TreeAddressMate rootAddress = (TreeAddressMate)node.getData();
        int comparison = rootAddress.compareTo(newAddress);

        @SuppressWarnings("unchecked")
        BinaryNode newEntry = new BinaryNode(newAddress);

        if(comparison == 0) {
            return node;
        }
        if(comparison < 0) {
            if(!node.hasLeftChild()) {
                return null;
            }
            else {
                node = (BinaryNode) node.getLeftChild();
                return lookup(node, newAddress);
            }
        } else {
            if (!node.hasRightChild()) {
                return null;
            } else {
                node = (BinaryNode) node.getRightChild();
                return lookup(node, newAddress);
            }
        }
    }

    public TreeAddressMate delete(String first, String last) {
        if (isEmpty()) return null;
        BinaryNode foundNode = lookup(topRoot, new TreeAddressMate(first, last));
        if(foundNode == null) return null;

        removeAndReplaceNode(foundNode);
        return (TreeAddressMate) foundNode.getData();

    }
    
    private BinaryNodeInterface getRightMostChildParent(BinaryNodeInterface node) {
        BinaryNodeInterface parent = node;
        while(node.hasRightChild()) {
            parent = node;
            node = node.getRightChild();
        }
        return parent;
    }

    private BinaryNode removeAndReplaceNode(BinaryNode found) {
        if (found.isLeaf()) {
            if(found.getParent().getRightChild() == found) {
                found.getParent().setRightChild(null);
            } else {
                found.getParent().setLeftChild(null);
            }
            found = null;

        } else if (found.hasLeftChild()) {
            if(found.getParent().getRightChild() == found) {
                found.getParent().setRightChild(found.getLeftChild());
            } else {
                found.getParent().setLeftChild(found.getLeftChild());
            }
            found = null;
        } else if (found.hasRightChild()) {
            if(found.getParent().getRightChild() == found) {
                found.getParent().setRightChild(found.getRightChild());
            } else {
                found.getParent().setLeftChild(found.getRightChild());
            }
            found = null;

        } else {
            BinaryNodeInterface parent = getRightMostChildParent(found.getLeftChild());
            BinaryNodeInterface rightMostNode = parent.getRightChild();
            found.setData(rightMostNode.getData());
            found.setLeftChild(rightMostNode.getLeftChild());
            found.setRightChild(rightMostNode.getRightChild());
            parent.setRightChild(null);
        }
        return found;
    }
}
