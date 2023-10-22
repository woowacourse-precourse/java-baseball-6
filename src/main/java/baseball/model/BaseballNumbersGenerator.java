package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbersGenerator {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;

    public static BaseballNumbers getComputerBaseballNumbers() {
        List<BaseballNumber> computerBaseballNumberList = new ArrayList<>();
        while (computerBaseballNumberList.size() != BASEBALL_NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
            BaseballNumber randomBaseballNumber = new BaseballNumber(randomNumber);
            if (!computerBaseballNumberList.contains(randomBaseballNumber)) {
                computerBaseballNumberList.add(randomBaseballNumber);
            }
        }
        return new BaseballNumbers(computerBaseballNumberList);
    }

    public static BaseballNumbers getUserBaseballNumbers(StringNumbers baseballStringNumbers) {
        return new BaseballNumbers(baseballStringNumbers.translateToIntegerList()
                .stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));
    }
}
