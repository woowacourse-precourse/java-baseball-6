package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final Rule rule;

    public NumberGenerator(Rule rule) {
        this.rule = rule;
    }

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < rule.getNumberOfDigits()) {
            int randomNumber = Randoms.pickNumberInRange(rule.getMinNumber(), rule.getMaxNumber());
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
