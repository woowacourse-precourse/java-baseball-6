package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int countStrike(String numbers) {
        return (int) IntStream.range(0, numbers.length())
                .filter(i -> numbers.charAt(i) == randomNumber.charAt(i))
                .count();
    }

    public int countBall(String numbers) {
        int result = 0;

        if (numbers.charAt(0) == randomNumber.charAt(1) ||
                numbers.charAt(0) == randomNumber.charAt(2) ||
                numbers.charAt(1) == randomNumber.charAt(0) ||
                numbers.charAt(1) == randomNumber.charAt(2) ||
                numbers.charAt(2) == randomNumber.charAt(0) ||
                numbers.charAt(2) == randomNumber.charAt(1)
        ) {
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
}
