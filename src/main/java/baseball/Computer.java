package baseball;

import static baseball.Constants.NUMBER_LOWER_BOUND;
import static baseball.Constants.NUMBER_UPPER_BOUND;
import static baseball.Constants.SIZE_OF_DIGITS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final ScoreProcessor scoreProcessor;
    private Numbers numbers;
    
    public Computer(ScoreProcessor scoreProcessor) {
        this.scoreProcessor = scoreProcessor;
    }

    public void generateRandomNumbers() {
        List<Integer> randomGeneratedNumberList = new ArrayList<>();
        while (randomGeneratedNumberList.size() < SIZE_OF_DIGITS.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    NUMBER_LOWER_BOUND.getValue(),
                    NUMBER_UPPER_BOUND.getValue()
            );
            if (!randomGeneratedNumberList.contains(randomNumber)) {
                randomGeneratedNumberList.add(randomNumber);
            }
        }
        this.numbers = new Numbers(randomGeneratedNumberList);
    }

    public Score guess(Numbers playerNumbers) {
        return scoreProcessor.processScore(this.numbers, playerNumbers);
    }
}
