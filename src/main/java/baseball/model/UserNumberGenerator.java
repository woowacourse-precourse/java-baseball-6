package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumberGenerator {
    public static List<Integer> makeUserNumberToList(String userNumbersToString) {
        List<Integer> userNumbers = new ArrayList<>();
        String[] splitStr = userNumbersToString.split("");
        for (String splitUserNumber : splitStr) {
            int singleNum = Integer.parseInt(splitUserNumber);
            userNumbers.add(singleNum);
        }
        return userNumbers;
    }
}
