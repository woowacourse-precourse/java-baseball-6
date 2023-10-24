package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    private static final int INPUT_SIZE = 3;
    private final List<Integer> numberList;

    private UserNumber(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public static UserNumber userNumberFactory(String userInput) {
        validate(userInput);
        List<Integer> integers = transNumberList(userInput);
        return new UserNumber(integers);
    }

    // 검증 메서드
    private static void validate(String userInput) {
        InputUtil.checkIsNumber(userInput);
        checkSize(userInput);
        checkNumbersUnique(userInput);
    }

    // 사이즈가 3이 맞는지 검증하는 메서드
    private static void checkSize(String userInput) {
        if (userInput.length() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 값이 다 다른 값인지 검증하는 메서드
    private static void checkNumbersUnique(String userInput) {
        long uniqueCount = userInput.chars().distinct().count();
        if (uniqueCount != userInput.length()) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 값을 숫자 리스트로 생성하는 메서드
    private static List<Integer> transNumberList(String userInput) {
        List<Integer> list = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    public List<Integer> getNumberList() {
        return this.numberList;
    }
}
