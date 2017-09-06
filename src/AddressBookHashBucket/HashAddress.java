package AddressBookHashBucket;

public class HashAddress implements Comparable<HashAddress> {

    String first;
    String last;
    String phoneNum;
    String email;

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

    public HashAddress(String first, String last) {
        this(first, last, null, null);
    }

    public HashAddress(String first, String last, String phoneNum, String email) {
        this.first = first;
        this.last = last;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    private String getUpcaseProperties() {
        return String.format("%s %s %s %s", this.first, this.last, this.phoneNum, this.email).toUpperCase();
    }

    // SAF Hash compare - If the same returns 0 - Otherwise returns the difference
    public int compareTo(HashAddress other) {
        return this.getUpcaseProperties().compareTo(other.getUpcaseProperties());
    }
}
