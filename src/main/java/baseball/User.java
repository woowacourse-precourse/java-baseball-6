package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final List<Integer> numbers;

    public User() {
        String numbers = Input.readUserNumbers();
        validateInput(numbers);

        this.numbers = toList(numbers);
    }

    private void validateInput(String numbers) {
        isNumber(numbers);
        isThreeDigitNumber(numbers);
        hasZero(numbers);
        hasDuplicateNumber(numbers);
    }

    private List<Integer> toList(String numbersStr) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersStr.length(); i++) {
            int number = numbersStr.charAt(i) - '0';
            numbers.add(number);
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void isNumber(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 이외의 문자가 포함된 값을 입력했습니다.");
        }
    }

    private void isThreeDigitNumber(String numbers) throws IllegalArgumentException {
        if (numbers.length() != Constants.NUMBER_COUNT) {
            throw new IllegalArgumentException("3자리의 수가 아닌 값을 입력했습니다.");
        }
    }

    private void hasZero(String numbers) throws IllegalArgumentException {
        if (toList(numbers).contains(0)) {
            throw new IllegalArgumentException("0이 포함된 값을 입력했습니다.");
        }
    }

    private void hasDuplicateNumber(String numbers) {
        Set<Integer> numbersSet = new HashSet<>(toList(numbers));

        if (numbersSet.size() != Constants.NUMBER_COUNT) {
            throw new IllegalArgumentException("중복된 값을 입력했습니다.");
        }
    }
}
