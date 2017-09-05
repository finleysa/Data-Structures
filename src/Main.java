import AddressBookHashBucket.AddressMate;
import AddressBookHashBucket.MeAddressBook;
import AddressBookTree.BinaryTree;
import AddressBookTree.TreeAddressMate;

public class Main {
    static int testCase = 0;

    public static void main(String[] args) {

        MeAddressBook hashAddressBook = new MeAddressBook(13);
        TestHashInsert(hashAddressBook, true, "Bob", "Smith"," 555-235-1111", "bsmith@somewhere.com");
        TestHashInsert(hashAddressBook, true,"Jane", "Williams"," 555-235-1112", "jw@something.com");
        TestHashInsert(hashAddressBook, true,"Mohammed", "al-Salam","555-235-1113", "mas@someplace.com");
        TestHashInsert(hashAddressBook, true,"Pat", "Jones","555-235-1114", "pjones@homesweethome.com");
        TestHashInsert(hashAddressBook, true,"Billy", "Kidd","555-235-1115", "billy_the_kid@nowhere.com");
        TestHashInsert(hashAddressBook, true,"H.", "Houdini","555-235-1116", "houdini@noplace.com");
        TestHashInsert(hashAddressBook, true,"Jack", "Jones","555-235-1117", "jjones@hill.com");
        TestHashInsert(hashAddressBook, true,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestHashInsert(hashAddressBook, true,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestHashInsert(hashAddressBook, true,"Jane", "Doe","555-235-1120", "jdoe@somedomain.com");
        TestHashlookUp(hashAddressBook, true,"Pat", "Jones","555-235-1114", "pjones@homesweethome.com");
        TestHashlookUp(hashAddressBook, true,"Billy", "Kidd","555-235-1115", "billy_the_kid@nowhere.com");
        TestHashDelete(hashAddressBook, true,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestHashInsert(hashAddressBook, true,"Test", "Case","555-235-1121", "Test_Case@testcase.com");
        TestHashInsert(hashAddressBook, true,"Nadezhda", "Kanachekhovskaya","555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        TestHashInsert(hashAddressBook, true,"Jo", "Wu","555-235-1123", "wu@h.com");
        TestHashInsert(hashAddressBook, true,"Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        TestHashInsert(hashAddressBook, true,"Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        TestHashInsert(hashAddressBook, true,"Upside", "Down","555-235-1126", "upsidedown@rightsideup.com");
        TestHashlookUp(hashAddressBook, true,"Jack", "Jones","555-235-1117", "jjones@hill.com");
        TestHashlookUp(hashAddressBook, true,"Nadezhda", "Kanachekhovskaya","555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        TestHashDelete(hashAddressBook, true,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestHashDelete(hashAddressBook, false,"John", "Doe","555-235-1119", "jdoe@somedomain.com");
        TestHashlookUp(hashAddressBook, false,"Jill", "Jones","555-235-1118", "jillj@hill.com");
        TestHashlookUp(hashAddressBook, true,"Jane", "Doe","555-235-1120", "jdoe@somedomain.com");

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
    }

    private static void TestTreeInsert(BinaryTree tree, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d TREE insert Success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d TREE insert failure of - %s %s", ++testCase, first, last));

        TreeAddressMate result = tree.insert(first, last, phoneNum, email);
        TreeAddressMate expected = new TreeAddressMate(first, last, phoneNum, email);

        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        if (same == expectedResult) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }
    }

    private static void TestTreelookUp(BinaryTree addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d TREE lookup success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d TREE lookup failure of - %s %s", ++testCase, first, last));

        TreeAddressMate result = addressBook.lookup(first, last);
        TreeAddressMate expected = new TreeAddressMate(first, last, phoneNum, email);

        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        if (same == expectedResult) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }

    }

    private static void TestTreeDelete(BinaryTree addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d TREE Delete success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d TREE Delete failure of - %s %s", ++testCase, first, last));

        TreeAddressMate result = addressBook.delete(first, last);
        TreeAddressMate expected = new TreeAddressMate(first, last, phoneNum, email);
        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        if (same == expectedResult) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }

    }

    private static void TestHashInsert(MeAddressBook addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d HASH insert success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d HASH insert failure of - %s %s", ++testCase, first, last));

        AddressMate result = addressBook.insert(first, last, phoneNum, email);
        AddressMate expected = new AddressMate(first, last, phoneNum, email);

        boolean same = result.compareTo(expected) == 0;

        if (same == expectedResult) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }
    }

    private static void TestHashlookUp(MeAddressBook addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d HASH lookup success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d HASH lookup failure of - %s %s", ++testCase, first, last));

        AddressMate result = addressBook.lookUp(first, last);
        AddressMate expected = new AddressMate(first, last, phoneNum, email);

        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        if (same == expectedResult) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }

    }

    private static void TestHashDelete(MeAddressBook addressBook, boolean expectedResult, String first, String last, String phoneNum, String email) {
        if(expectedResult)
            System.out.print(String.format("Test Case %d HASH Delete success of - %s %s", ++testCase, first, last));
        else
            System.out.print(String.format("Test Case %d HASH Delete failure of - %s %s", ++testCase, first, last));

        AddressMate result = addressBook.delete(first, last);
        AddressMate expected = new AddressMate(first, last, phoneNum, email);
        boolean same = false;
        if(result != null) {
            same = result.compareTo(expected) == 0;
        }

        if (same == expectedResult) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }

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