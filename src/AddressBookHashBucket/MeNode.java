package AddressBookHashBucket;

public class MeNode<K, V>  implements MeNodeInterface<K, V>{

    private K key;
    private V value;
    private MeNode next;
    private MeNode previous;

    MeNode(K key, V value) {
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

    public MeNode getNext() {
        return next;
    }

    public void setNext(MeNode next) {
        if(next != this && next != previous) this.next = next;
    }

    public MeNode getPrevious() { return previous; }

    public void setPrevious(MeNode previous) {
        if(previous != this && previous != next) this.previous = previous;
    }

}

