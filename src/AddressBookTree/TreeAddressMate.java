package AddressBookTree;

public class TreeAddressMate implements Comparable<TreeAddressMate> {

    String first;
    String last;
    String phoneNum;
    String email;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

     public TreeAddressMate(String first, String last) {
         this(first, last, null, null);
     }

     public TreeAddressMate(String first, String last, String phoneNum, String email) {
        this.first = first;
        this.last = last;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getUpcaseFullName() {
         return String.format("%s %s ", this.first, this.last).toUpperCase();
    }

    public int compareTo(TreeAddressMate other) {
        int compare = this.getUpcaseFullName().compareTo(other.getUpcaseFullName());
        return compare == 0 ? this.getUpcaseFullName().compareTo(other.getUpcaseFullName()) : compare;
    }
}
