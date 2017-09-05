package AddressBookHashBucket;

public class MeAddressBook implements AddressBookInterface {

    private final int HASHMULT = 31;
    private final int DEFAULT_SIZE = 20;
    private static MeNode[] allMeNodes;

    public MeAddressBook() {
        allMeNodes = new MeNode[DEFAULT_SIZE];
    }

    public MeAddressBook(int size) {
        allMeNodes = new MeNode[size];
    }

    public AddressMate insert(String first, String last, String phoneNum, String email) {
        int key = genKey(first, last);
        int index = getBucketIndex(key);
        MeNode foundNode = allMeNodes[index];
        AddressMate addressEntry = new AddressBookHashBucket.AddressMate(first, last, phoneNum, email);
        if (foundNode == null) {
            allMeNodes[index] = new MeNode<>(key, addressEntry);

        } else if(foundNode.getKey().equals(key)){
            foundNode.setValue(addressEntry);

        } else {
             while (foundNode.getNext() != null) {
                 foundNode = foundNode.getNext();
             }
             MeNode newNode = new MeNode<>(key, addressEntry);
             newNode.setPrevious(foundNode);
             foundNode.setNext(newNode);
        }
        return addressEntry;
    }

    public AddressMate delete(String first, String last) {
        MeNode foundNode = lookUpNode(first, last);
        if(foundNode == null) return null;

        int index = getBucketIndex(genKey(first, last));

        MeNode next = foundNode.getNext();
        MeNode prev = foundNode.getPrevious();

        if(next != null && prev !=null) {
            //SAF if next node and prev node - remove foundNode from chain
            next.setPrevious(prev);
            prev.setNext(next);

        } else if(next == null && prev != null) {
            //SAF if no next node but prev node - set prev node next to null
            prev.setNext(null);

        } else if(next != null){
            //SAF if next node but no prev node - set next node to index
            next.setPrevious(null);
            allMeNodes[index] = next;

        } else {
            //SAF if no next node and no prev node - set index to null
            allMeNodes[index] = null;
        }

        return (AddressMate)foundNode.getValue();
    }

    public AddressMate lookUp(String first, String last) {
        if(lookUpNode(first, last) == null) {
            return null;
        }
        return (AddressMate) lookUpNode(first, last).getValue();
    }

    private MeNode lookUpNode(String first, String last) {
        int index = getBucketIndex(genKey(first, last));
        MeNode foundNode = allMeNodes[index];
        if (foundNode == null) return null;

        boolean found = false;
        int key = genKey(first, last);
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
        int hashIndex = key % allMeNodes.length;
        if(hashIndex < 0) {
            hashIndex = hashIndex + allMeNodes.length;
        }
        return hashIndex;
    }

    private int genKey(String first, String last) {
        String fullName = String.format("%s %s", first, last).toUpperCase();
        int hash = 1;
        int n = fullName.length();
        for (int i = 0; i < n; i++)
            hash = hash * HASHMULT + fullName.charAt(i);
        return hash;
    }
}