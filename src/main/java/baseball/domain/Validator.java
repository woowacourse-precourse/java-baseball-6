package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void checkArrayLength(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

    public static void checkRange(String userNumber) {
        String[] userNumArr = userNumber.split("");
        for (String str : userNumArr) {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("1과 9 사이의 숫자가 아닙니다.");
            }
        }
    }

    public static List<Integer> checkForDuplicateNumbers(String userNumber) {
        List<Integer> userNum = new ArrayList<>();

        String[] userNumArr = userNumber.split("");
        for (String str : userNumArr) {
            Integer userNumInt = Integer.parseInt(str);
            if (!userNum.contains(userNumInt)) {
                userNum.add(userNumInt);
            } else { // 같은 수 포함
                throw new IllegalArgumentException("같은 수가 포함되어 있습니다.");
            }
        }

        return userNum;
    }

    public static void checkArrayNumber(String userNumber) {
        if (userNumber == null || !userNumber.matches("\\d+")) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static void checkOneOrTwo(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("1과 2가 아닙니다.");
        }
    }
}
