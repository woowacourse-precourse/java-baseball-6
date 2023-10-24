package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballConstants.*;

public class User {
    private final String input;

    public User(String input) {
        validateInputLength(input);
        this.input = input;
    }

    // Input을 List형태로 변환
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char c = input.charAt(i);
            validateNumberRange(c);
            validateDuplicate(numbers, Character.getNumericValue(c));
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }


    // 입력된 문자가 1~9의 범위가 아닌경우 Exception
    private void validateNumberRange(char c) {
        if ((int)c < 49 || (int)c > 57){
            throw new IllegalArgumentException();
        }
    }

    // 입력된 문자열의 길이가 3보다 크거나 작을 때 Exception
    private void validateInputLength(String input) {
        if (input.length() > NUMBER_LENGTH || input.length() < NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    // 입력된 문자열에 중복된 숫자가 있을 때 Exception
    private void validateDuplicate(List<Integer> numbers, int n) {
        if (numbers.contains(n)){
            throw new IllegalArgumentException();
        }
    }
}