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

    public int countStrike() {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (numbers.charAt(i) == randomNumber.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public int countBall() {
        int result = 0;
        if (numbers.charAt(0) == randomNumber.charAt(1) || numbers.charAt(0) == randomNumber.charAt(2)) {
            result++;
        }

        if (numbers.charAt(1) == randomNumber.charAt(0) || numbers.charAt(0) == randomNumber.charAt(2)) {
            result++;
        }

        if (numbers.charAt(2) == randomNumber.charAt(0) || numbers.charAt(2) == randomNumber.charAt(1)) {
            result++;
        }

        return result;
    }

    public boolean isNothing() {
        return countStrike() + countBall() == 0;
    }

    public boolean isPerfect() {
        return countStrike() == 3;
    }

}
