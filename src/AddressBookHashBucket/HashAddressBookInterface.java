package AddressBookHashBucket;

interface HashAddressBookInterface {

    /** SAF
     * Inserts new address in to address book
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param email
     * @return inserted address
     */
    HashAddress insert(String firstName, String lastName, String phoneNumber, String email);

    /** SAF
     * Deletes address from address book
     * @param firstName
     * @param lastName
     * @return deleted address
     */
    HashAddress delete(String firstName, String lastName);

    /** SAF
     * Gets address from address book
     * @param firstName
     * @param lastName
     * @return found address or null
     */
    HashAddress lookUp(String firstName, String lastName);
}
