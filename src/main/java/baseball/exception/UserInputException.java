package baseball.exception;


import java.util.List;

public class UserInputException {
    private static final int LIST_LENGTH = 3;
    private static final int START_POINT = 1;
    private static final int END_POINT = 9;

    public static void isDigit(List<Integer> userNumber) throws IllegalArgumentException {
        if(userNumber.size() != LIST_LENGTH) {
            throw new IllegalArgumentException("3자리 수의 숫자를 입력하세요");
        }
    }
    public static void isDuplicate(List<Integer> userNumber) throws IllegalArgumentException {
        if (!(userNumber.size() == userNumber.stream().distinct().count())) {
            throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다. 숫자를 다시 확인하세요");
        }
    }
    public static void isRange(List<Integer> userNumber) throws IllegalArgumentException {
        if (!(userNumber.stream().allMatch(num -> num >= START_POINT && num <= END_POINT))) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요");
        }
    }
}
