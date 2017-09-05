package AddressBookHashBucket;

interface AddressBookInterface {
    AddressMate insert(String firstName, String lastName, String phoneNumber, String email);
    AddressMate delete(String firstName, String lastName);
    AddressMate lookUp(String firstName, String lastName);
}
