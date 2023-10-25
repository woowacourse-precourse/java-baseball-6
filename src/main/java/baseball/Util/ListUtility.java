package baseball.Util;

import java.util.ArrayList;

public class ListUtility {
    public ListUtility() {
    }

    public static ArrayList<Integer> splitDigitsIntoList(int number) {
        ArrayList<Integer> splittedDigits = new ArrayList<>();
        String stringNumber = Integer.toString(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            char charDigit = stringNumber.charAt(i);
            splittedDigits.add(Character.getNumericValue(charDigit));
        }
        return splittedDigits;
    }
}
