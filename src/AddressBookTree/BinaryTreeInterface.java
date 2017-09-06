package AddressBookTree;

public interface BinaryTreeInterface<TreeAddress> {

    /** SAF
     * Inserts BinaryTreeAddress into BinaryTree
     * @param first first name
     * @param last last name
     * @param phoneNum phone number string
     * @param email email address
     * @return Inserted address
     * */
     TreeAddress insert(String first, String last, String phoneNum, String email);

     /** SAF
      * Finds BinaryTreeAddress in BinaryTree
      * @param first first name
      * @param last last name
      * @return found address or null
     ***/
     TreeAddress lookup(String first, String last);

    /** SAF
     * Deletes BinaryTreeAddress from BinaryTree
     * @param first first name
     * @param last last name
     ***/
     TreeAddress delete(String first, String last);

}
