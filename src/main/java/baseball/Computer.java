package baseball;

import java.util.List;

public class Computer {

    private static final int COUNT_TO_GENERATE = 3;

    private Numbers baseballNumber;

    public void generateNumber() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(COUNT_TO_GENERATE);
        baseballNumber = Numbers.from(randomNumbers);
    }


}
