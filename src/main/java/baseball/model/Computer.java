package baseball.model;

import baseball.constants.OutputMessage;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Computer {
    private static final int NONE = 0;
    private static final int MAX_SIZE = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int STRIKE_THRESHOLD = 3;
    private List<Integer> numbers;
    private int ballCount;
    private int strikeCount;

    public Computer() {
    }

    public void resetCount() {
        ballCount = NONE;
        strikeCount = NONE;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    private void addBallCount() {
        ballCount++;
    }

    private void addStrikeCount() {
        strikeCount++;
    }

    public void generateRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            randomNumbers.add(randomNumber);
        }
        numbers = new ArrayList<>(randomNumbers);
    }

    public void calculateHint(List<Integer> playerNumbers) {
        resetCount();

        for (int index = 0; index < MAX_SIZE; index++) {
            Integer playerNumber = playerNumbers.get(index);

            if (isStrike(index, playerNumber)) {
                addStrikeCount();
            } else if (isBall(playerNumber)) {
                addBallCount();
            }
        }
    }

    private boolean isBall(Integer playerNumber) {
        return numbers.contains(playerNumber);
    }

    private boolean isStrike(Integer index, Integer playerNumber) {
        return Objects.equals(numbers.get(index), playerNumber);
    }

    private boolean isNothing() {
        return strikeCount == NONE && ballCount == NONE;
    }

    public String makeResult() {
        StringBuilder message = new StringBuilder();

        if (isNothing()) {
            message.append(OutputMessage.NOTHING);
        } else if (strikeCount == STRIKE_THRESHOLD) {
            message.append(String.format("3%s%n%s", OutputMessage.STRIKE, OutputMessage.GAME_EXIT));
        } else {
            message.append(String.format("%s%s%s", makeBallMessage(), makeSeparator(), makeStrikeMessage()));
        }
        return message.toString();
    }

    private String makeBallMessage() {
        if (ballCount > NONE) {
            return ballCount + OutputMessage.BALL.toString();
        }
        return "";
    }

    private String makeStrikeMessage() {
        if (strikeCount > NONE) {
            return strikeCount + OutputMessage.STRIKE.toString();
        }
        return "";
    }

    private String makeSeparator() {
        if (ballCount > NONE && strikeCount > NONE) {
            return OutputMessage.BLANK.toString();
        }
        return "";
    }
}
