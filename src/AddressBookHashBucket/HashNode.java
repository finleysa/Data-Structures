package AddressBookHashBucket;

public class HashNode<K, V>  implements HashNodeInterface<K, V> {

    private K key;
    private V value;
    private HashNode next;
    private HashNode previous;

    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        if(next != this && next != previous) this.next = next;
    }

    public HashNode getPrevious() { return previous; }

    public void setPrevious(HashNode previous) {
        if(previous != this && previous != next) this.previous = previous;
    }

}

