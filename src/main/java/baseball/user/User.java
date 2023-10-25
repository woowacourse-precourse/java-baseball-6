package baseball.user;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.BaseballConstants.*;

public class User {

    private List<Integer> numbers;

    private List<Integer> convertInputToList(String input) {
        validateInputLength(input);

        List<Integer> convertedNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char c = input.charAt(i);
            validateNumberRange(c);
            validateDuplicate(convertedNumbers, Character.getNumericValue(c));
            convertedNumbers.add(Character.getNumericValue(c));
        }
        return convertedNumbers;
    }


    /**
     * 문자의 범위가 48 <= c <= 57을 벗어나면 Exception
     * @param c 범위를 확인할 문자
     * @throws IllegalArgumentException char is out of range in 48 <= c <= 57
     */
    private void validateNumberRange(char c) {
        if ((int)c < 49 || (int)c > 57){
            throw new IllegalArgumentException("입력한 값에 문자 혹은 0이 포함되어있습니다.");
        }
    }

    /**
     * 입력값의 길이가 3이 아닐 떄 Exception
     * @param input 사용자가 입력한 값
     * @throws IllegalArgumentException input length is not 3
     */
    private void validateInputLength(String input) {
        if (input.length() > NUMBER_LENGTH || input.length() < NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력한 값이 3자리수가 아닙니다.");
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
            throw new IllegalArgumentException("입력한 값에 중복된 값이 포함되어있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String input) {
        List<Integer> convertedNumbers = convertInputToList(input);
        validateInputLength(input);
        this.numbers = convertedNumbers;
    }
}