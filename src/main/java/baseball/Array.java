package baseball;

import java.util.List;

public class Array {
    // 3자리 수 초과 입력
    public static void checkArrayLength(String userNumber) {
        if (userNumber.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

    // 0이 포함된 경우
    public static void checkZeroInArray(String userNumber) {
        if (userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    // 같은 수 포함
    public static void checkForDuplicateNumbers(List<Integer> userNum, String userNumber) {
        String[] userNumArr = userNumber.split(""); // 입력 받은 수 한글자씩 나눔
        for (String str : userNumArr) {
            Integer userNumInt = Integer.parseInt(str);
            if (!userNum.contains(userNumInt)) { // 없으면 추가
                userNum.add(userNumInt);
            } else { // 같은 수 포함
                throw new IllegalArgumentException();
            }
        }
    }

    // 숫자가 아닌 경우
    public static void checkArrayNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (IllegalArgumentException ignored) {

        }
    }


}
