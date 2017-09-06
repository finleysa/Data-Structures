package AddressBookTree;

interface BinaryNodeInterface<T>
{
    /** SAF
     * Gets data of this
     * @return stored node data
     */
    T getData();

    /** SAF
     * Store data
     * @param newData set node data
     */
    void setData(T newData);

    /** SAF
     * Gets node parent
     * @return node parent
     */
    BinaryNodeInterface<T> getParent();

    /** SAF
     * Node set parent of this
     * @param node set parent of node
     */
    void setParent(BinaryNodeInterface<T> node);

    /** SAF
     * Gets left child node of this
     * @return left child node
     */
    BinaryNodeInterface<T> getLeftChild();

    /** SAF
     * Gets right child node of this
     * @return right child node
     */
    BinaryNodeInterface<T> getRightChild();

    /** SAF
     * Sets left child node of this
     * @param leftChild sets left child node
     */
    void setLeftChild(BinaryNodeInterface<T> leftChild);

    /** SAF
     * Sets right child of this
     * @param rightChild sets right child node
     */
    void setRightChild(BinaryNodeInterface<T> rightChild);

    /** SAF
     *  Has left child bool
     * @return if node has left child
     */
    boolean hasLeftChild();

    /** SAF
     * Has right child bool
     * @return if node has right child
     */
    boolean hasRightChild();

    /** SAF
     * This has no left or right child
     * @return tree does not have children
     */
    boolean isLeaf();

}
