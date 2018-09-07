package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * This is an test class for a simple class that represents a string, defined
 * as a sequence of characters.
 *
 * You should implement your tests in this class.  Do not change the test names.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    //Test Purpose: This is the first instructor example test.
    @Test
    public void testCountDuplicates1() {
        mycustomstring.setString("People are sleeping... Zzz.");
        assertEquals(4, mycustomstring.countDuplicates());
    }
    //Test Purpose: This is the test to check whether the method testCountDuplicates returns 0 if the current string is null.
    @Test
    public void testCountDuplicates2() {
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countDuplicates());
    }
    //Test Purpose: This is the test to check whether the method testCountDuplicates returns 0 if the current string is empty.
    @Test
    public void testCountDuplicates3() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countDuplicates());
    }
    //Test Purpose: This is the test to check whether the method testCountDuplicates return correct number if the current string has escape character.
    //For my case, the method should return 6 since the input string has 7 "\n".
    @Test
    public void testCountDuplicates4() {
        mycustomstring.setString("abcs\n\n\n\n\n\n\n");
        assertEquals(6, mycustomstring.countDuplicates());
    }
    //Test Purpose: This is the test to check whether the method testCountDuplicates return correct duplicated number if the current string only have space.
    //For my case, the method should return 8 since the input string has 9 white spaces.
    @Test
    public void testCountDuplicates5() {
        mycustomstring.setString("         ");
        assertEquals(8, mycustomstring.countDuplicates());
    }
    //Test Purpose: This is the test to check whether the method return correct number if the string have upper and lower case of the same letter.
    //For my case, the method should return 2 since we got "aa" and "AA". The method does not take upper and lower case of the same letter as duplicated characters.
    @Test
    public void testCountDuplicates6() {
        mycustomstring.setString("AaaAAaAaBbBbBb");
        assertEquals(2, mycustomstring.countDuplicates());
    }


    //Test Purpose: This is the second instructor example test.
    @Test
    public void testAddDigits1() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("5678!!! H7y, l7t'9 put 94me d505ts in this 9tr5n0!55!5", mycustomstring.addDigits(4, true));
    }

    //Test Purpose: This the third instructor example test.
    @Test
    public void testAddDigits2() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("7890!!! H9y, l9t'1 put 16me d727ts in this 1tr7n2!77!7", mycustomstring.addDigits(4, false));
    }
    //Test Purpose: This is the test to check whether the method addDigits throws a NullPointerException if the current string is null.

    @Test(expected = NullPointerException.class)
    public void testAddDigits3() {
        mycustomstring.addDigits(5, true);
    }
    //Test Purpose: This is the test to check whether the method addDigits throws a IllegalArgumentException if the current string is not null and n >9
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits4() {
        mycustomstring.setString("not null");
        mycustomstring.addDigits(200, true);
    }
    //Test Purpose: This is the test to check whether the method addDigits throws a IllegalArgumentException if the current string is not null and n =0
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits5() {
        mycustomstring.setString("not null");
        mycustomstring.addDigits(0, true);
    }
    //Test Purpose: This is the test to check whether the method addDigits returns a identical string as original if there is no digit in the current string.
    @Test
    public void testAddDigits6() {
        mycustomstring.setString("ALL characters BUT no digits");
        assertEquals("ALL characters BUT no digits", mycustomstring.addDigits(4, false));
    }
    //Test Purpose: This is the test to check whether the method addDigits return an empty string if the current string is empty.
    @Test
    public void testAddDigits7() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.addDigits(4, false));
    }
    //Test Purpose: This is the test to check whether the method addDigits returns string with correct number for all digit from 0 to 9 incremented by n if the boolean is true.
    @Test
    public void testAddDigits8() {
        mycustomstring.setString("123456789");
        assertEquals("012345678", mycustomstring.addDigits(9, true));
    }
    //Test Purpose: This is the test to check whether the method addDigits returns string with correct number for all digit from 0 to 9 decremented by n if the boolean is false:
    @Test
    public void testAddDigits9() {
        mycustomstring.setString("123456789");
        assertEquals("234567890", mycustomstring.addDigits(9, false));
    }
    //Test Purpose: This is the test to check whether the method addDigits throws a NullPointerException when the current string is null and the input is invalid.
    //In this case, the method checks NullPointerException first as we expect and throws a NullPointerException instead of a IllegalArgumentException.
    @Test (expected = NullPointerException.class)
    public void testAddDigits10() {
        mycustomstring.addDigits(200000, true);
    }
    //Test Purpose: This is the test to check whether the method addDigits return string with correct numbers and symbols if the current string is an set of digits combined with symbol characters.
    @Test
    public void testAddDigits11() {
        mycustomstring.setString("234!@#%^&*()_+");
        assertEquals("890!@#%^&*()_+", mycustomstring.addDigits(4, false));
    }
    //Test Purpose: This is the test to check whether the method addDigits return string with correct numbers and escape characters if the current string is an set of digits combined with escape characters.
    @Test
    public void testAddDigits12() {
        mycustomstring.setString("123\n\t\r");
        assertEquals("678\n\t\r", mycustomstring.addDigits(5, false));
    }


    //Test Purpose: This is the fourth instructor example test.
    @Test
    public void testFlipLetttersInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(18, 30);
        assertEquals("H3y, l3t'5 put 50ni s161tD em this 5tr1n6!11!!", mycustomstring.getString());
    }

    //Test Purpose: This is an instructor example test to demonstrate testing for an exception.
    @Test(expected = NullPointerException.class)
    public void testFlipLetttersInSubstring2() {
        mycustomstring.flipLetttersInSubstring(200, 100);
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters throws a MyIndexOutOfBoundsException if the current string is not null but endPosition > the length of String
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring3() { 
        mycustomstring.setString("Not null");
        mycustomstring.flipLetttersInSubstring(18, 30);
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters throws a MyIndexOutOfBoundsException if the current string is not null but StartPosition <= 0.
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring4() {
        mycustomstring.setString("Not null");
        mycustomstring.flipLetttersInSubstring(-1, 30);
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters throws a IllegalArgumentException if startPosition > end Position
    // neither position is out of bound and string is not null
    @Test(expected = IllegalArgumentException.class)
    public void testFlipLetttersInSubstring5() {
        mycustomstring.setString("Not null");
        mycustomstring.flipLetttersInSubstring(16, 8);
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters return a identical string if the current string is with no letters but all spaces and inputs are valid.
    @Test
    public void testFlipLetttersInSubstring6() {
        mycustomstring.setString("                    ");
        mycustomstring.flipLetttersInSubstring(2, 9);
        assertEquals("                    ", mycustomstring.getString());
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters return original string if the current string only contains digits
    //This Test ensures method  testFlipLettters will not change positions of any digits ('0' to '9').
    @Test
    public void testFlipLetttersInSubstring7() {
        mycustomstring.setString("0123456789");
        mycustomstring.flipLetttersInSubstring(1, 10);
        assertEquals("0123456789", mycustomstring.getString());
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters throws a MyIndexOutOfBoundsException if the current string is empty (not null) and the inputs positions are out of bound.
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring8() {
        mycustomstring.setString("");
        mycustomstring.flipLetttersInSubstring(1, 5);
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters return correct string if the string combined with letters and escape characters.
    @Test
    public void testFlipLetttersInSubstring9() {
        mycustomstring.setString("1toq2\n\trodgers");
        mycustomstring.flipLetttersInSubstring(1, 14);
        assertEquals("1sre2\n\tgdorqot", mycustomstring.getString());
    }
    //Test Purpose: This is the test to check whether the method testFlipLettters return correct string if the string combined with all letters and escape characters.
    //This test ensures the method  testFlipLettters can recognize all the letters ('a' to 'z' and 'A' to 'Z") and change the position of them
    @Test
    public void testFlipLetttersInSubstring10() {
        mycustomstring.setString("31778813231ABCDEFGHIJ !! KLMNOPQ  !!RSTUVXYZabcdefghijk  lmn  opqrstuvwxyz794!!719!!04794790");
        mycustomstring.flipLetttersInSubstring(5, 80);
        assertEquals("31778813231zyxwvutsrq !! ponmlkj  !!ihgfedcbaZYXVUTSRQP  ONM  LKJIHGFEDCBA794!!719!!04794790", mycustomstring.getString());
    }

}
