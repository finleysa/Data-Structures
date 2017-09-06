package AddressBookTree;

public class BinaryTreeAddress implements Comparable<BinaryTreeAddress> {

    private String first;
    private String last;
    private String phoneNum;
    private String email;

    //region Properties
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion

    public BinaryTreeAddress(String first, String last) {
         this(first, last, null, null);
     }

    public BinaryTreeAddress(String first, String last, String phoneNum, String email) {
        this.first = first;
        this.last = last;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getUpcaseFullName() {
         return String.format("%s %s ", this.first, this.last).toUpperCase();
    }

    // SAF
    // Hash compare
    // If the same returns 0
    // Otherwise returns the difference
    public int compareTo(BinaryTreeAddress other) {
        return this.getUpcaseFullName().compareTo(other.getUpcaseFullName());
    }
}
