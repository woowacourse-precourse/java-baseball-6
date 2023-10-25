package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.view.OutputView.MessageConst.*;

public class Validator {

    //입력값 검증
    public List<Integer> validateInputNum(String input) {
        lengthValidation(input);
        List<Integer> inputNumbers = strToList(input);
        numberValidation(inputNumbers);
        sameInputValidation(inputNumbers);

        return inputNumbers;
    }

    private List<Integer> strToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    //입력값 3자리수 검증
    public void lengthValidation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ASK_LENGTH_MSG);
        }
    }

    //입력값 중복 검증
    public void sameInputValidation(List<Integer> inputNumbers) {
        if (inputNumbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException(ASK_SAME_MSG);
        }
    }

    //입력값 자연수 검증
    public void numberValidation(List<Integer> inputNumbers) {
        boolean checkRange = inputNumbers.stream()
                .allMatch(num -> 1 <= num && num <= 9);

        if (!checkRange) {
            throw new IllegalArgumentException(ASK_NATURAL_MSG);
        }
    }

    public void restartValidation(int input) {
        if (input < 1 || input > 2) {
            throw new IllegalArgumentException(ASK_ONE_TWO_MSG);
        }
    }
}
