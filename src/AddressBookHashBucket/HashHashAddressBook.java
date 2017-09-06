package AddressBookHashBucket;

public class HashHashAddressBook implements HashAddressBookInterface {

    private final int HASHMULT = 31;
    private final int DEFAULT_SIZE = 20;
    private static HashNode[] hashNodeArray;

    public HashHashAddressBook() {
        hashNodeArray = new HashNode[DEFAULT_SIZE];
    }

    public HashHashAddressBook(int size) {
        hashNodeArray = new HashNode[size];
    }

    public HashAddress insert(String first, String last, String phoneNum, String email) {
        // SAF get key and bucket index of array
        int key = genKey(first, last);
        int index = getBucketIndex(key);

        // SAF get bucket
        HashNode foundNode = hashNodeArray[index];
        HashAddress hashAddressEntry = new HashAddress(first, last, phoneNum, email);

        if (foundNode == null) {
            // SAF if bucket empty set hashAddressEntry to the first
            hashNodeArray[index] = new HashNode<>(key, hashAddressEntry);

        } else if(foundNode.getKey().equals(key)){
            // SAF update operation
            // SAF if first bucket entry is the same change value to new value
            foundNode.setValue(hashAddressEntry);

        } else {
            // get last node in bucket
             while (foundNode.getNext() != null) {
                 foundNode = foundNode.getNext();
             }

             // SAF set last node in bucket to hashAddressEntry and link nodes
             HashNode newNode = new HashNode<>(key, hashAddressEntry);
             newNode.setPrevious(foundNode);
             foundNode.setNext(newNode);
        }
        return hashAddressEntry;
    }

    public HashAddress delete(String first, String last) {
        // SAF check for empty bucket
        HashNode foundNode = lookUpNode(first, last);
        if(foundNode == null) return null;

        HashNode next = foundNode.getNext();
        HashNode prev = foundNode.getPrevious();

        int index = getBucketIndex(genKey(first, last));
        if(next != null && prev !=null) {
            // SAF if next node and prev node - remove foundNode from chain
            next.setPrevious(prev);
            prev.setNext(next);

        } else if(next == null && prev != null) {
            // SAF if no next node but prev node - set prev node next to null
            prev.setNext(null);

        } else if(next != null){
            // SAF if next node but no prev node - set next node to index
            next.setPrevious(null);
            hashNodeArray[index] = next;

        } else {
            // SAF if no next node and no prev node - set index to null
            hashNodeArray[index] = null;
        }

        return (HashAddress)foundNode.getValue();
    }

    public HashAddress lookUp(String first, String last) {
        // SAF find node or return null
        HashNode tempNode = lookUpNode(first, last);
        if(tempNode == null) return null;

        return (HashAddress) tempNode.getValue();
    }

    private HashNode lookUpNode(String first, String last) {
        // SAF get bucket
        int key = genKey(first, last);
        int index = getBucketIndex(key);
        HashNode foundNode = hashNodeArray[index];
        if (foundNode == null) return null; // no bucket

        // SAF search bucket til found or found = null
        boolean found = false;
        while (!found && foundNode != null) {
            if (foundNode.getKey().equals(key))
                found = true;
            else {
                foundNode = foundNode.getNext();
            }
        }

        return foundNode;
    }

    // SAF returns bucket index
    private int getBucketIndex(int key) {
        int hashIndex = key % hashNodeArray.length;
        if(hashIndex < 0) {
            hashIndex = hashIndex + hashNodeArray.length;
        }
        return hashIndex;
    }

    // SAF generates unique key base on first and last name
    private int genKey(String first, String last) {

        String fullName = String.format("%s %s", first, last).toUpperCase();
        int hash = 1;
        int n = fullName.length();
        for (int i = 0; i < n; i++)
            hash = hash * HASHMULT + fullName.charAt(i);
        return hash;
    }
}