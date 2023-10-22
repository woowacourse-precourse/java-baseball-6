package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;
import static baseball.utils.BaseballConstantUtils.MAX_BASEBALL_NUMBER;
import static baseball.utils.BaseballConstantUtils.MIN_BASEBALL_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbersGenerator {

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
