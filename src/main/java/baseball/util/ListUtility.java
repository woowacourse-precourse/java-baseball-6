package baseball.util;

import java.util.ArrayList;
import java.util.List;

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

    public static int parseRandomNumbersToInt(List<Integer> list) {
        return list.stream()
                .reduce((acc, cur) -> acc * 10 + cur)
                .get(); // TODO : make non-optional return
    }


}
