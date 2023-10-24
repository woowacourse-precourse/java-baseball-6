package baseball;

import java.util.ArrayList;
import java.util.List;

public class SameValue {
    private static List<Integer> sameNumberList;
    private static String userNumberString;

    public static int sameNumberCount(int userNumber, List<Integer> computerNumber) {
        userNumberString = String.valueOf(userNumber);

        int sameNumber = 0;

        sameNumberList = new ArrayList<>();

        for (char digit : userNumberString.toCharArray()) {
            for (int i : computerNumber) {
                char charI = (char) ('0' + i);
                if (digit == charI) {
                    sameNumber += 1;
                    sameNumberList.add(i);
                }
            }
        }

        return sameNumber;
    }

    public static int sameIndexCount(int userNumber, List<Integer> computerNumber) {
        int sameNumber = sameNumberCount(userNumber, computerNumber);
        int sameCount = 0;

        for (int i = 0; i < sameNumber; i++) {
            int computerIndex = computerNumber.indexOf(sameNumberList.get(i));
            int userNumberIndex = userNumberString.indexOf(String.valueOf(sameNumberList.get(i)));
            if (computerIndex == userNumberIndex) {
                sameCount += 1;
            }
        }
        return sameCount;
    }
}
