package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public void inputNumber(String numberString) {
        validateNumberDigits(numberString);
        userNumbers = numberStringToList(numberString);
        validateNumberUnique(userNumbers);
    }

    private List<Integer> numberStringToList(String number) {
        List<Integer> numbers = new ArrayList<>();
        for (String digit : number.split("")) {
            numbers.add(Integer.parseInt(digit));
        }
        return numbers;
    }

    private void validateNumberDigits(String numberString) {
        if (numberString.length() != 3) {
            throw new IllegalArgumentException("the number must be 3 digits");
        }
    }

    private void validateNumberUnique(List<Integer> userNumbers) {
        long uniqueNumbers = userNumbers.stream().distinct().count();
        if (userNumbers.size() != uniqueNumbers) {
            throw new IllegalArgumentException("number of each digit cannot be the same as the others");
        }
    }

    public int getDigit(int index) {
        return userNumbers.get(index);
    }
}
