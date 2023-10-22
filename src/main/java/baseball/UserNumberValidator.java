package baseball;

public class UserNumberValidator {
    private static final int NUM_DIGIT = 3;

    public static void isRightDigit(String useNumber){
        if (useNumber.length() != NUM_DIGIT){
            throw new IllegalArgumentException("유효하지 않은 값을 입력되어 프로그램을 종료합니다.")
        }
    }

    public static void is
}
