package baseball.model;

import baseball.controller.NumberValidator;

import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private final List<Integer> number;

    public UserNumber(String number) {
        NumberValidator.validateString(number);
        this.number = StringToList(number);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private List<Integer> StringToList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
