package baseball.model;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    private static final int INPUT_SIZE = 3;
    private final List<Integer> numberList;

    public UserInput() {
        this.numberList = new ArrayList<>();
    }

    public void processInput() {
        String userInput = InputView.getUserInput();
        validate(userInput);
        transNumberList(userInput);
    }

    // 검증 메서드
    private void validate(String userInput) {
        checkIsNumber(userInput);
        checkSize(userInput);
        checkNumbersUnique(userInput);
    }

    // 숫자가 맞는지 검증하는 메서드
    public static void checkIsNumber(String userInput) {
        if (!userInput.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    // 사이즈가 3이 맞는지 검증하는 메서드
    private void checkSize(String userInput) {
        if (userInput.length() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 값이 다 다른 값인지 검증하는 메서드
    private void checkNumbersUnique(String userInput) {
        long uniqueCount = userInput.chars().distinct().count();
        if (uniqueCount != userInput.length()) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 값을 숫자 리스트로 바꿔서 추가하는 메서드
    private void transNumberList(String userInput) {
        for (char c : userInput.toCharArray()) {
            numberList.add(Character.getNumericValue(c));
        }
    }

    public List<Integer> getNumberList() {
        return new ArrayList<>(numberList);
    }
}
