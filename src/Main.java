import AddressBookHashBucket.HashHashAddressBook;
import AddressBookTree.BinaryTree;
import AddressBookTree.BinaryTreeAddress;

public class Main {

    static int testCase = 0;
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {

        HashHashAddressBook hashHashAddressBook = new HashHashAddressBook(13);
        TestHashInsert(hashHashAddressBook, true, "Bob", "Smith"," 555-235-1111", "bsmith@somewhere.com");
        TestHashInsert(hashHashAddressBook, true,"Jane", "Williams"," 555-235-1112", "jw@something.com");
        TestHashInsert(hashHashAddressBook, true,"Mohammed", "al-Salam","555-235-1113", "mas@someplace.com");
        TestHashInsert(hashHashAddressBook, true,"Pat", "Jones","555-235-1114", "pjones@homesweethome.com");
        TestHashInsert(hashHashAddressBook, true,"Billy", "Kidd","555-235-1115", "billy_the_kid@nowhere.com");
        TestHashInsert(hashHashAddressBook, true,"H.", "Houdini","555-235-1116", "houdini@noplace.com");
        TestHashInsert(hashHashAddressBook, true,"Jack", "Jones","555-235-1117", "jjones@hill.com");
        TestHashInsert(hashHashAddressBook, true,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestHashInsert(hashHashAddressBook, true,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestHashInsert(hashHashAddressBook, true,"Jane", "Doe","555-235-1120", "jdoe@somedomain.com");
        TestHashlookUp(hashHashAddressBook, true,"Pat", "Jones","555-235-1114", "pjones@homesweethome.com");
        TestHashlookUp(hashHashAddressBook, true,"Billy", "Kidd","555-235-1115", "billy_the_kid@nowhere.com");
        TestHashDelete(hashHashAddressBook, true,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestHashInsert(hashHashAddressBook, true,"Test", "Case","555-235-1121", "Test_Case@testcase.com");
        TestHashInsert(hashHashAddressBook, true,"Nadezhda", "Kanachekhovskaya","555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        TestHashInsert(hashHashAddressBook, true,"Jo", "Wu","555-235-1123", "wu@h.com");
        TestHashInsert(hashHashAddressBook, true,"Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        TestHashInsert(hashHashAddressBook, true,"Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        TestHashInsert(hashHashAddressBook, true,"Upside", "Down","555-235-1126", "upsidedown@rightsideup.com");
        TestHashlookUp(hashHashAddressBook, true,"Jack", "Jones","555-235-1117", "jjones@hill.com");
        TestHashlookUp(hashHashAddressBook, true,"Nadezhda", "Kanachekhovskaya","555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        TestHashDelete(hashHashAddressBook, true,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestHashDelete(hashHashAddressBook, false,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestHashlookUp(hashHashAddressBook, false,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestHashlookUp(hashHashAddressBook, true,"Jane", "Doe","555-235-1120", "jdoe@somedomain.com");

        BinaryTree tree = new BinaryTree();
        TestTreeInsert(tree, true, "Bob", "Smith"," 555-235-1111", "bsmith@somewhere.com");
        TestTreeInsert(tree, true,"Jane", "Williams"," 555-235-1112", "jw@something.com");
        TestTreeInsert(tree, true,"Mohammed", "al-Salam","555-235-1113", "mas@someplace.com");
        TestTreeInsert(tree, true,"Pat", "Jones","555-235-1114", "pjones@homesweethome.com");
        TestTreeInsert(tree, true,"Billy", "Kidd","555-235-1115", "billy_the_kid@nowhere.com");
        TestTreeInsert(tree, true,"H.", "Houdini","555-235-1116", "houdini@noplace.com");
        TestTreeInsert(tree, true,"Jack", "Jones","555-235-1117", "jjones@hill.com");
        TestTreeInsert(tree, true,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestTreeInsert(tree, true,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestTreeInsert(tree, true,"Jane", "Doe","555-235-1120", "jdoe@somedomain.com");
        TestTreelookUp(tree, true,"Pat", "Jones","555-235-1114", "pjones@homesweethome.com");
        TestTreelookUp(tree, true,"Billy", "Kidd","555-235-1115", "billy_the_kid@nowhere.com");
        TestTreeDelete(tree, true,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestTreeInsert(tree, true,"Test", "Case","555-235-1121", "Test_Case@testcase.com");
        TestTreeInsert(tree, true,"Nadezhda", "Kanachekhovskaya","555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        TestTreeInsert(tree, true,"Jo", "Wu","555-235-1123", "wu@h.com");
        TestTreeInsert(tree, true,"Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        TestTreeInsert(tree, true,"Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        TestTreeInsert(tree, true,"Upside", "Down","555-235-1126", "upsidedown@rightsideup.com");
        TestTreelookUp(tree, true,"Jack", "Jones","555-235-1117", "jjones@hill.com");
        TestTreelookUp(tree, true,"Nadezhda", "Kanachekhovskaya","555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        TestTreeDelete(tree, true,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestTreeDelete(tree, false,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestTreelookUp(tree, false,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestTreelookUp(tree, true,"Jane", "Doe","555-235-1120", "jdoe@somedomain.com");

        printTotals();
    }

    private static void TestTreeInsert(BinaryTree tree, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d TREE Insert Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d TREE Insert Failure of - %s %s", ++testCase, first, last));

        BinaryTreeAddress result = tree.insert(first, last, phoneNum, email);
        BinaryTreeAddress expected = new BinaryTreeAddress(first, last, phoneNum, email);

        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        passFail(same, expectedResult);
    }

    private static void TestTreelookUp(BinaryTree addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d TREE Lookup Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d TREE Lookup Failure of - %s %s", ++testCase, first, last));

        BinaryTreeAddress result = addressBook.lookup(first, last);
        BinaryTreeAddress expected = new BinaryTreeAddress(first, last, phoneNum, email);

        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        passFail(same, expectedResult);
    }

    private static void TestTreeDelete(BinaryTree addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d TREE Delete Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d TREE Delete Failure of - %s %s", ++testCase, first, last));

        BinaryTreeAddress result = addressBook.delete(first, last);
        BinaryTreeAddress expected = new BinaryTreeAddress(first, last, phoneNum, email);
        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        passFail(same, expectedResult);
    }

    private static void TestHashInsert(HashHashAddressBook hashAddressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d HASH Insert Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d HASH Insert Failure of - %s %s", ++testCase, first, last));

        AddressBookHashBucket.HashAddress result = hashAddressBook.insert(first, last, phoneNum, email);
        AddressBookHashBucket.HashAddress expected = new AddressBookHashBucket.HashAddress(first, last, phoneNum, email);

        boolean same = result.compareTo(expected) == 0;

        passFail(same, expectedResult);
    }

    private static void TestHashlookUp(HashHashAddressBook hashAddressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d HASH Lookup Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d HASH Lookup Failure of - %s %s", ++testCase, first, last));

        AddressBookHashBucket.HashAddress result = hashAddressBook.lookUp(first, last);
        AddressBookHashBucket.HashAddress expected = new AddressBookHashBucket.HashAddress(first, last, phoneNum, email);

        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        passFail(same, expectedResult);
    }

    private static void TestHashDelete(HashHashAddressBook hashAddressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d HASH Delete Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d HASH Delete Failure of - %s %s", ++testCase, first, last));

        AddressBookHashBucket.HashAddress result = hashAddressBook.delete(first, last);
        AddressBookHashBucket.HashAddress expected = new AddressBookHashBucket.HashAddress(first, last, phoneNum, email);
        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        passFail(same, expectedResult);
    }

    private static void passFail(boolean result, boolean expected) {
        if (result == expected) {
            System.out.println(" - PASS");
            ++passed;
        } else {
            System.out.println(" - FAIL");
            ++failed;
        }
    }

    private static void printTotals() {
        System.out.println(String.format("PASSED:\t %d\\%d --- %d%%", passed, testCase, passed/testCase * 100));
        System.out.println(String.format("FAILED:\t %d\\%d --- %d%%", failed, testCase, failed/testCase * 100));
    }

}

/********************* TEST CASES *********************
Test Case1: Insert Bob Smith 555-235-1111 bsmith@somewhere.com
Test Case2: Insert Jane Williams 555-235-1112 jw@something.com
Test Case3: Insert Mohammed al-Salam 555-235-1113 mas@someplace.com
Test Case4: Insert Pat Jones 555-235-1114 pjones@homesweethome.com
Test Case5: Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com
Test Case6: Insert H. Houdini 555-235-1116 houdini@noplace.com
Test Case7: Insert Jack Jones 555-235-1117 jjones@hill.com
Test Case8: Insert Jill Jones 555-235-1118 jillj@hill.com
Test Case9: Insert John Doe 555-235-1119 jdoe@somedomain.com
Test Case10: Insert Jane Doe 555-235-1120 jdoe@somedomain.com
Test Case11: Lookup Pat Jones
Test Case12: Lookup Billy Kidd
Test Case13: Delete John Doe
Test Case14: Insert Test Case 555-235-1121 Test_Case@testcase.com
Test Case15: Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
Test Case16: Insert Jo Wu 555-235-1123 wu@h.com
Test Case17: Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us
Test Case18: Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com
Test Case19: Insert Upside Down 555-235-1126 upsidedown@rightsideup.com
Test Case20: Lookup Jack Jones
Test Case21: Lookup Nadezhda Kanachekhovskaya
Test Case22: Delete Jill Jones
Test Case23: Delete John Doe
Test Case24: Lookup Jill Jones (What should happen if the “lookup” message doesn’t find theentry?)
Test Case25: Lookup John Doe
 *******************************************************/