package baseball.Utils;

import java.util.List;

public class CheckValidNumber {
    /**
     * 유효 숫자 확인
     */
    public static void IsValidNumber(String InputString) {
        if (!checkValidLength(InputString) || !checkValidRange(InputString) || !checkDifferentNumber(InputString))
            throw new IllegalArgumentException();
    }

    private static boolean checkValidLength(String InputString) {
        return InputString.length() == 3;
    }

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

    private static boolean checkDifferentNumber(String InputString) {
        boolean IsDifferentNumber = true;
        for (int i = 0; i < InputString.length(); i++) {
            if (InputString.charAt(i) == InputString.charAt((i + 1) % 3)) {
                IsDifferentNumber = false;
                break;
            }
        }
        return IsDifferentNumber;
    }

    public static void checkNewOrQuit(String Inputstring)
    {
        List<String> possibleNumber = List.of("1", "2");
        if (!possibleNumber.contains(Inputstring)) throw new IllegalArgumentException();
    }
}
