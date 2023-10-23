package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseball {

    private final static int MAX_RANDOM_CHARACTERS = 3;
    private final static int MIN_RANDOM_NUMBER = 1;
    private final static int MAX_RANDOM_NUMBER = 9;


    private final String randomNumber = generateRandomNumber();

    private String generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_RANDOM_CHARACTERS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
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
        return (int) IntStream.range(0, numbers.length())
                .filter(i -> isBall(numbers, i))
                .count();
    }

    private boolean isBall(String numbers, int position) {
        int[] checkPositions = {(position + 1) % 3, (position + 2) % 3};
        return Arrays.stream(checkPositions)
                .anyMatch(pos -> numbers.charAt(position) == randomNumber.charAt(pos));
    }

    public boolean isNothing(String numbers) {
        return countStrike(numbers) + countBall(numbers) == 0;
    }

    public boolean isPerfect(String numbers) {
        return countStrike(numbers) == 3;
    }
}
