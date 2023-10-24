package baseball.model;

import baseball.counter.CountResult;
import baseball.counter.Counter;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.message.Messages.BALL;
import static baseball.message.Messages.RESULT_3_STRIKE;
import static baseball.message.Messages.RESULT_NOTHING;
import static baseball.message.Messages.STRIKE;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_OF_DIGITS = 3;

    private final List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>(NUMBER_OF_DIGITS);
        generateNumbers();
    }

    public void generateNumbers() {
        this.numbers.clear();
        while (this.numbers.size() < NUMBER_OF_DIGITS) {
            int randomNumber = generateRandomNumber();

            if (!isDuplicated(randomNumber)) {
                this.numbers.add(randomNumber);
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private boolean isDuplicated(int randomNumber) {
        return this.numbers.contains(randomNumber);
    }

    public String generateGameResultMessage(Player player) {
        CountResult countStrikeAndBall = Counter.countStrikeAndBall(this.numbers, player.getNumbers());
        int strike = countStrikeAndBall.strike();
        int ball = countStrikeAndBall.ball();

        if (strike == 0 && ball == 0) {
            return RESULT_NOTHING;
        }

        if (strike == 3) {
            return RESULT_3_STRIKE;
        }

        StringBuilder message = new StringBuilder();

        if (ball > 0) {
            message.append(ball).append(BALL);
        }

        if (strike > 0) {
            if (ball > 0) {
                message.append(" ");
            }
            message.append(strike).append(STRIKE);
        }

        return message.toString();
    }
}
