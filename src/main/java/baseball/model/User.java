package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public void inputNumber(String numberString) {
        userNumbers = numberStringToList(numberString);
        validateNumberDigits(userNumbers);
        validateNumberUnique(userNumbers);
    }

    private List<Integer> numberStringToList(String number) {
        List<Integer> numbers = new ArrayList<>();
        for (String digit : number.split("")) {
            numbers.add(Integer.parseInt(digit));
        }
        return numbers;
    }

    private void validateNumberDigits(List<Integer> userNumbers) {
        if (userNumbers.size() != 3) {
            throw new IllegalArgumentException("number should be 3 digits");
        }
    }

    private void validateNumberUnique(List<Integer> userNumber) {
        if (userNumber.size() != userNumber.stream().distinct().count()) {
            throw new IllegalArgumentException("each digits cannot be same with others");
        }
    }

    public int getDigit(int index) {
        return userNumbers.get(index);
    }
}
