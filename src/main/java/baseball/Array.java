package baseball;

import java.util.ArrayList;
import java.util.List;

public class Array {
    // 3자리 수 초과 입력
    public static void checkArrayLength(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    // 1~9 범위 허용
    public static void checkRange(String userNumber) {
        String[] userNumArr = userNumber.split(""); // 입력 받은 수 한글자씩 나눔
        for (String str : userNumArr) {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("1과 9 사이의 숫자가 아닙니다.");
            }
        }
    }

    // 같은 수 포함
    public static List<Integer> checkForDuplicateNumbers(String userNumber) {
        List<Integer> userNum = new ArrayList<>();

        String[] userNumArr = userNumber.split(""); // 입력 받은 수 한글자씩 나눔
        for (String str : userNumArr) {
            Integer userNumInt = Integer.parseInt(str);
            if (!userNum.contains(userNumInt)) { // 없으면 추가
                userNum.add(userNumInt);
            } else { // 같은 수 포함
                throw new IllegalArgumentException("같은 수가 포함되어 있습니다.");
            }
        }

        return userNum;
    }

    // 숫자가 아닌 경우
    public static void checkArrayNumber(String userNumber) {
        if (!userNumber.matches("\\d+")) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static void checkOneOrTwo(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("1과 2가 아닙니다.");
        }
    }
}
