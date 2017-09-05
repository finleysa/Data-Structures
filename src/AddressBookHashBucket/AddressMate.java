package AddressBookHashBucket;

import org.jetbrains.annotations.NotNull;

public class AddressMate implements Comparable<AddressMate> {

    String first;
    String last;
    String phoneNum;
    String email;

    public AddressMate(String first, String last) {
        this(first, last, null, null);
    }
    public AddressMate(String first, String last, String phoneNum, String email) {
        this.first = first;
        this.last = last;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public AddressMate copy(){
        return new AddressMate(first, last, phoneNum, email);
    }
    public String getUpcaseFullName() {
        return String.format("%s %s %s %s", this.first, this.last, this.phoneNum, this.email).toUpperCase();
    }

    public int compareTo(AddressMate other) {
        int compare = this.getUpcaseFullName().compareTo(other.getUpcaseFullName());
        return compare == 0 ? this.getUpcaseFullName().compareTo(other.getUpcaseFullName()) : compare;
    }
}
