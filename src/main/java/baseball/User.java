package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballConstants.*;

public class User {
    private final String input;

    public User(String input) {
        validateInputLength(input);
        validateIsString(input);
        this.input = input;
    }

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


    private void validateNumberRange(char c) {
        if ((int)c < 49 || (int)c > 57){ // 입력된 문자가 1~9의 범위가 아닌경우
            throw new IllegalArgumentException();
        }
    }

    private void validateInputLength(String input) {
        if (input.length() > NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsString(String input){
        if (!input.matches("\\d+")) { // 정규 표현식을 사용하여 모든 문자가 숫자인지 확인
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers, int n) {
        if (numbers.contains(n)){
            throw new IllegalArgumentException();
        }
    }
}