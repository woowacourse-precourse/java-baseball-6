package baseball.domain;

import baseball.resource.GameValue;
import baseball.validator.InputValidation;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(String number) {
        this.numbers = changeStringToNumberList(number);
    }

    private List<Integer> changeStringToNumberList(String inputNumber) {
        numbers = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            numbers.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        return numbers;
    }
}
