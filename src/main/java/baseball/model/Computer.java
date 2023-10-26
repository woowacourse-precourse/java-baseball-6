package baseball.model;

import baseball.constants.Message;
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

    public void resetHint() {
        ballCount = NONE;
        strikeCount = NONE;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void increaseBallCount() {
        ballCount++;
    }

    private void increaseStrikeCount() {
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
        for (int index = 0; index < MAX_SIZE; index++) {
            Integer playerNumber = playerNumbers.get(index);

            if (isStrike(index, playerNumber)) {
                increaseStrikeCount();
                continue;
            }
            if (isBall(playerNumber)) {
                increaseBallCount();
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
        if (isNothing()) {
            return String.format("%s", Message.NOTHING);
        }
        if (isGameExited()) {
            return String.format("3%s%n%s", Message.STRIKE, Message.GAME_EXIT);
        }
        return String.format("%s%s%s", makeBallMessage(), makeSeparator(), makeStrikeMessage());
    }

    public boolean isGameExited() {
        return strikeCount == STRIKE_THRESHOLD;
    }

    private String makeBallMessage() {
        if (ballCount > NONE) {
            return ballCount + Message.BALL.toString();
        }
        return "";
    }

    private String makeStrikeMessage() {
        if (strikeCount > NONE) {
            return strikeCount + Message.STRIKE.toString();
        }
        return "";
    }

    private String makeSeparator() {
        if (ballCount > NONE && strikeCount > NONE) {
            return Message.BLANK.toString();
        }
        return "";
    }
}
