package baseball.user;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.BaseballConstants.*;

public class User {
    private final String input;

    public User(String input) {
        validateInputLength(input);
        this.input = input;
    }

    /**
     * 사용자가 입력한 수를 예외처리와 동시에 List형태로 변환
     * @return 1~9까지의 숫자 3개가 담긴 리스트
     */
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


    /**
     * 문자의 범위가 48 <= c <= 57을 벗어나면 Exception
     * @param c 범위를 확인할 문자
     * @throws IllegalArgumentException char is out of range in 48 <= c <= 57
     */
    private void validateNumberRange(char c) {
        if ((int)c < 49 || (int)c > 57){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력값의 길이가 3이 아닐 떄 Exception
     * @param input 사용자가 입력한 값
     * @throws IllegalArgumentException input length is not 3
     */
    private void validateInputLength(String input) {
        if (input.length() > NUMBER_LENGTH || input.length() < NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력된 문자열에 중복된 숫자가 있을 때 Exception
     * @param numbers 입력된 값들
     * @param n 중복되었는지 비교할 값
     * @throws IllegalArgumentException n is in numbers
     */
    private void validateDuplicate(List<Integer> numbers, int n) {
        if (numbers.contains(n)){
            throw new IllegalArgumentException();
        }
    }
}