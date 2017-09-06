package AddressBookHashBucket;

interface HashNodeInterface<K, V>{
    /** SAF
     * Get key of node
     * @return key
     */
    K getKey();

    /** SAF
     * Get value of node
     * @return value
     */
    V getValue();

    /** SAF
     * Set value of node
     * @param value
     */
    void setValue(V value);

    /** SAF
     * Get next node in chain
     * @return next node in chain
     */
    HashNode getNext();

    /** SAF
     * Sets next node in chain
     * @param next
     */
    void setNext(HashNode next);

    /** SAF
     * Get previous linked node in chain
     * @return
     */
    HashNode getPrevious();

    /** SAF
     * Sets previous linked node in chain
     * @param previous
     */
    void setPrevious(HashNode previous);
}
