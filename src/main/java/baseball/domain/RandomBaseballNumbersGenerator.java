package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBaseballNumbersGenerator implements BaseballNumbersGenerator {

    private static final int ANSWER_SIZE = 3;
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;

    @Override
    public BaseballNumbers generate() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < ANSWER_SIZE) {
            addNonDuplicatedNumber(baseballNumbers);
        }
        return new BaseballNumbers(baseballNumbers);
    }

    private static void addNonDuplicatedNumber(List<BaseballNumber> baseballNumbers) {
        int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
        BaseballNumber randomBaseballNumber = new BaseballNumber(randomNumber);
        if (!baseballNumbers.contains(randomBaseballNumber)) {
            baseballNumbers.add(randomBaseballNumber);
        }
    }
}
