package AddressBookHashBucket;

interface MeNodeInterface<K, V>{
    K getKey();
    V getValue();
    void setValue(V value);
    MeNode getNext();
    void setNext(MeNode next);
    MeNode getPrevious();
    void setPrevious(MeNode previous);
}
