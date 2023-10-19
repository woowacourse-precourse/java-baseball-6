package baseball;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Balls {
    private List<Integer> myInt = new ArrayList<>();

    public Balls(String str) {
        validString(str);
        for (int i = 0; i < 3; i++) {
            int strInt = parseInt(String.valueOf(str.charAt(i)));
            myInt.add(strInt);
        }
    }

    public List<Integer> getMyInt() {
        return myInt;
    }

    private void validString(String str) {
        if (!isThreeInt(str) || str.length() != 3) {
            throw new IllegalArgumentException();
        }
        char[] strArray = str.toCharArray();
        int[] check = new int[3];
        strArrayCheck(str, strArray, check);
    }

    private static void strArrayCheck(String str, char[] strArray, int[] check) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (str.charAt(i) == strArray[j]) {
                    check[i]++;
                }
            }
            if (check[i] != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isThreeInt(String str) {
        try {
            parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
