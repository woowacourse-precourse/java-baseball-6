package baseball;

import java.util.List;

public class CheckValidNum {

    // 예외 처리
    public static void IsValidNum(String InputString) {
        if (!checkValidLength(InputString) || !checkValidRange(InputString) || !checkDifferentNumber(InputString))
            throw new IllegalArgumentException();
    }

    // 길이가 3인지 확인 메서드
    private static boolean checkValidLength(String InputString) {
        return InputString.length() == 3;
    }

    // 자연수 1~9 사이인지 확인 메서드
    private static boolean checkValidRange(String InputString) {
        boolean IsValidRange = true;
        for (char number : InputString.toCharArray()) {
            if (number < '1' || number > '9') {
                IsValidRange = false;
                break;
            }
        }
        return IsValidRange;
    }

    // 서로 다른 숫자들인지 확인 메서드
    private static boolean checkDifferentNumber(String InputString) {
        boolean IsDifferentNum = true;
        for (int i = 0; i < InputString.length(); i++) {
            if (InputString.charAt(i) == InputString.charAt((i + 1) % 3)) {
                IsDifferentNum= false;
                break;
            }
        }
        return IsDifferentNum;
    }


    // 1 or 2 외의 다른 숫자인지 확인 메서드
    public static void checkNewOrQuit(String Inputstring)
    {
        List<String> possibleNumber = List.of("1", "2");
        if (!possibleNumber.contains(Inputstring)) throw new IllegalArgumentException();
    }
}
