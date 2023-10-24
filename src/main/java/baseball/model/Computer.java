package baseball.model;

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

    public String getGameResultMessage(List<Integer> player) {
        Result result = calculateGameResult(player);
        int strike = result.getStrike();
        int ball = result.getBall();

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

    public Result calculateGameResult(List<Integer> player) {
        int strike = 0;
        int ball = 0;

        int computerNumber, playerNumber;
        for (int i = 0; i < this.numbers.size(); i++) {
            computerNumber = this.numbers.get(i);
            playerNumber = player.get(i);

            if (computerNumber == playerNumber) {
                strike++;
            }

            if (this.numbers.contains(playerNumber) && computerNumber != playerNumber) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }
}
