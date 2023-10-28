package baseball.domain;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ComputerNumber {

    private List<Integer> createRandomNumber() {
        List<Integer> randomNumbers = pickRandomNumber();
        if (validateRandomNumberDuplicate(randomNumbers) && validateRandomNumberRange(randomNumbers)) {
            return randomNumbers;
        }
        return createRandomNumber();
    }

    private static List<Integer> pickRandomNumber() {
        return IntStream.range(Constant.ZERO_NUMBER, Constant.LENGTH_LIMIT)
                .mapToObj(num -> Randoms.pickNumberInRange(Constant.START_NUMBER, Constant.END_NUMBER))
                .toList();
    }

    private boolean validateRandomNumberDuplicate(List<Integer> randomNumbs) {
        return randomNumbs.stream().distinct().count() == Constant.LENGTH_LIMIT;
    }

    private boolean validateRandomNumberRange(List<Integer> randomNumbs) {
        return randomNumbs.stream()
                .anyMatch(num -> Constant.START_NUMBER <= num && num <= Constant.END_NUMBER);
    }

    public List<Integer> getComputerNumber() {
        return Collections.unmodifiableList(createRandomNumber());
    }
}
