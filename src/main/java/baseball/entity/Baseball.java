package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Baseball {

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

    public void isValid(String numbers) {
        if (isNumberLengthThree(numbers) && isNumberDuplicate(numbers) && isNumber(numbers)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isNumber(String numbers) {
        return numbers.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isNumberLengthThree(String numbers) {
        return numbers.length() == 3;
    }

    private boolean isNumberDuplicate(String numbers) {
        char firstNumber = numbers.charAt(0);
        char secondNumber = numbers.charAt(1);
        char thirdNumber = numbers.charAt(2);

        return firstNumber != secondNumber && secondNumber != thirdNumber && firstNumber != thirdNumber;
    }

    public int countStrike(String numbers) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (numbers.charAt(i) == randomNumber.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public int countBall(String numbers) {
        int result = 0;
        if (numbers.charAt(0) == randomNumber.charAt(1) || numbers.charAt(0) == randomNumber.charAt(2)) {
            result++;
        }

        if (numbers.charAt(1) == randomNumber.charAt(0) || numbers.charAt(1) == randomNumber.charAt(2)) {
            result++;
        }

        if (numbers.charAt(2) == randomNumber.charAt(0) || numbers.charAt(2) == randomNumber.charAt(1)) {
            result++;
        }

        return result;
    }

    public boolean isNothing(String numbers) {
        return countStrike(numbers) + countBall(numbers) == 0;
    }

    public boolean isPerfect(String numbers) {
        return countStrike(numbers) == 3;
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}
