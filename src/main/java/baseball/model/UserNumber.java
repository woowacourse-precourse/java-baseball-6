package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private final List<Integer> number;

    public UserNumber(String number) {
        this.number = StringToIntList(number);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private List<Integer> StringToIntList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
