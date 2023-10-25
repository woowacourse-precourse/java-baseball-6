package baseball.vo;

import baseball.model.NumbersValidator;
import baseball.model.Validator;
import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<String> numbers;

    public Numbers(String numbers) {
        Validator validator = new NumbersValidator();
        validator.validate(numbers);

        this.numbers = toList(split(numbers));
    }

    private String[] split(String numbers) {
        return numbers.split("");
    }

    private List<String> toList(String[] numbers) {
        return Arrays.asList(numbers);
    }

    public String calculateByIndex(Numbers other, int index) {
        String othersNumber = other.numberAt(index);

        if (isSamePlace(othersNumber, index)) {
            return "스트라이크";
        }
        if (isExist(othersNumber)) {
            return "볼";
        }
        return "";
    }

    private String numberAt(int index) {
        return numbers.get(index);
    }

    private boolean isSamePlace(String number, int index) {
        return numberAt(index).equals(number);
    }

    private boolean isExist(String number) {
        return numbers.contains(number);
    }
}
