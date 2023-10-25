package baseball.model;

import baseball.counter.CountResult;
import baseball.counter.Counter;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.rules.GameConstants.MAX_NUMBER;
import static baseball.rules.GameConstants.MIN_NUMBER;
import static baseball.rules.GameConstants.NUMBER_OF_DIGITS;

public class Computer {
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

    public CountResult getGameResult(Player player) {
        return Counter.countStrikeAndBall(this.numbers, player.getNumbers());
    }
}
