package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Computer {
    private static final int MAX_SIZE = 3;
    private static final int LOWER_INCLUSIVE = 1;
    private static final int UPPER_INCLUSIVE = 9;
    private List<Integer> numbers;
    private int ballCount;
    private int strikeCount;

    public Computer() {
    }

    public void resetCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void generateRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOWER_INCLUSIVE, UPPER_INCLUSIVE);
            randomNumbers.add(randomNumber);
        }
        numbers = new ArrayList<>(randomNumbers);
    }

    public void calculateResult(List<Integer> playerNumbers) {
        resetCount();

        for (int index = 0; index < MAX_SIZE; index++) {
            Integer playerNumber = playerNumbers.get(index);

            if (isStrike(index, playerNumber)) {
                strikeCount++;
            } else if (isBall(playerNumber)) {
                ballCount++;
            }
        }
    }

    private boolean isBall(Integer playerNumber) {
        return numbers.contains(playerNumber);
    }

    private boolean isStrike(Integer index, Integer playerNumber) {
        return Objects.equals(numbers.get(index), playerNumber);
    }
}
