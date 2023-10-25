package baseball.model.numberstrategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberSelectionStrategy implements NumberSelectionStrategy {
    private static final int DIGIT_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public List<Integer> createNumbers() {
        List<Integer> randomUniqueNumbers = new ArrayList<>();
        while (randomUniqueNumbers.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addUniqueNumber(randomUniqueNumbers, randomNumber);
        }
        return Collections.unmodifiableList(randomUniqueNumbers);
    }

    private static void addUniqueNumber(List<Integer> randomUniqueNumbers, int randomNumber) {
        if (!randomUniqueNumbers.contains(randomNumber)) {
            randomUniqueNumbers.add(randomNumber);
        }
    }
}