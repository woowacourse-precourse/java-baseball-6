package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Integer> myInt;

    public Balls(String str) {
        validString(str);
        myInt = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            myInt.add(Integer.parseInt(String.valueOf(str.charAt(i))));
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
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
