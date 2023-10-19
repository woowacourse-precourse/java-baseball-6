package entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {

    private final String numbers;
    private final String randomNumber = generateRandomNumber();

    private String generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public NumberBaseball(String numbers) {
        this.numbers = numbers;
    }

    public void isValid() {
        if (isNumberLengthThree() && isNumberDuplicate() && isNumber()) {
            return;
        }
        throw new IllegalStateException();
    }

    private boolean isNumber() {
        return numbers.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isNumberLengthThree() {
        return numbers.length() == 3;
    }

    private boolean isNumberDuplicate() {
        char firstNumber = numbers.charAt(0);
        char secondNumber = numbers.charAt(1);
        char thirdNumber = numbers.charAt(2);

        return firstNumber != secondNumber && secondNumber != thirdNumber && firstNumber != thirdNumber;
    }
}
