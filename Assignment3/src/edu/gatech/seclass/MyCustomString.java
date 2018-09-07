package edu.gatech.seclass;

public class MyCustomString implements MyCustomStringInterface {

    String str = null;

    public String getString() {
        if (str == null || str.isEmpty()) {
            return null;
        } else {
            return str;
        }
    }

    public void setString(String string) {
        str = string;
    }


    public int countDuplicates() {
        if (str != null && !str.isEmpty()) {
            int n = 0;
            char[] strarray = str.toCharArray();
            for (int i = 0; i < str.length() - 1; i++) {
                if (strarray[i] == strarray[i + 1]) {
                    n = n + 1;
                }
            }
            return n;
        } else {
            return 0;
        }
    }

    public String addDigits(int n, boolean positive) {

        String stradd = " ";
        if (str == null) {
            throw new NullPointerException("current string is null");
        } else if (n <= 0 || n > 9) {
            throw new IllegalArgumentException("n <= 0 or n > 9");
        } else {
            int i = 0;
            int num = 0;
            char[] strarray = str.toCharArray();
            for (int a = 0; a < str.length(); a++) {
                if (Character.isDigit(strarray[a])) {
                    if (positive) {
                        num = n + Character.getNumericValue(strarray[a]);
                    } else {
                        num = 10 + Character.getNumericValue(strarray[a]) - n;
                    }
                    num = Math.abs(num) % 10;
                    strarray[a] = (char) (num + '0');
                }
            }
            stradd = String.valueOf(strarray);
        }

        return stradd;
    }

    public void flipLetttersInSubstring(int startPosition, int endPosition) {
        if (str == null) {
            throw new NullPointerException("current string is null");
        } else if (startPosition <= 0 || endPosition > str.length()) {
            throw new MyIndexOutOfBoundsException("index is out of bound");
        } else if (startPosition > endPosition) {
            throw new IllegalArgumentException("argument is illegal");
        } else {

            int num = 0;
            char[] traarray = str.toCharArray();


            for (int a = startPosition - 1; a < endPosition; a++) {
                if (((traarray[a] <= 'Z') && (traarray[a] >= 'A')) || ((traarray[a] <= 'z') && (traarray[a] >= 'a'))) {
                    num = num + 1;
                }
            }
            int[] intarray = new int[num];
            int arraynum = 0;
            for (int a = startPosition - 1; a < endPosition; a++) {
                if (((traarray[a] <= 'Z') && (traarray[a] >= 'A')) || ((traarray[a] <= 'z') && (traarray[a] >= 'a'))) {
                    intarray[arraynum] = a;
                    arraynum = arraynum + 1;
                }
            }
            for (int a = 0; a < intarray.length / 2; a++) {
                char temp = traarray[intarray[a]];
                traarray[intarray[a]] = traarray[intarray[intarray.length - a - 1]];
                traarray[intarray[intarray.length - a - 1]] = temp;
            }
            str = String.valueOf(traarray);
        }


    }
}







