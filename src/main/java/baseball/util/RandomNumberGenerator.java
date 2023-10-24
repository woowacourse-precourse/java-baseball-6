package baseball.util;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int NUMBER_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public List<Number> generate() {
        Set<Number> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < NUMBER_COUNT) {
            int randomNumber = getRandomNumber();
            uniqueNumbers.add(new Number(randomNumber));
        }

        return new ArrayList<>(uniqueNumbers);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
