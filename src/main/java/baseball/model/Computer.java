package baseball.model;

import baseball.counter.CountResult;
import baseball.counter.Counter;
import baseball.message.MessageGenerator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

    public String getGameResultMessage(Player player) {
        CountResult countStrikeAndBall = Counter.countStrikeAndBall(this.numbers, player.getNumbers());
        return MessageGenerator.generateGameResultMessage(countStrikeAndBall);
    }
}
