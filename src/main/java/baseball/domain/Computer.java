package baseball.domain;

import static baseball.utils.GameSetting.MAX_NUMBER;
import static baseball.utils.GameSetting.MIN_NUMBER;
import static baseball.utils.GameSetting.NUMBER_SIZE;

import baseball.utils.RandomNumberGenerator;
import java.util.List;

public class Computer {
    private final RandomNumberGenerator randomNumberGenerator;
    private List<Integer> numbers;

    public Computer() {
        randomNumberGenerator = RandomNumberGenerator.getInstance();
        refreshNumbers();
    }

    public void refreshNumbers() {
        numbers = randomNumberGenerator.makeUniQueRandomNumbers(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
