package baseball.domain;

import baseball.constant.Constant;
import baseball.constant.errorMessage.UserNumberError;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerNumber {

    private List<Integer> createRandomNumber() {
        List<Integer> randomNumbers = pickRandomNumber();
        if (validateRandomNumberDuplicate(randomNumbers)) {
            return randomNumbers;
        }
        return createRandomNumber();
    }

    private static List<Integer> pickRandomNumber() {
        return Arrays.stream(new List[Constant.NUMBER_LENGTH_LIMIT])
                .map(num -> Randoms.pickNumberInRange(Constant.START_NUMBER, Constant.END_NUMBER))
                .collect(Collectors.toList());
    }

    private boolean validateRandomNumberDuplicate(List<Integer> randomNumbs) {
        return randomNumbs.stream().distinct().count() == Constant.NUMBER_LENGTH_LIMIT;
    }

    public List<Integer> getComputerNumber() {
        return Collections.unmodifiableList(createRandomNumber());
    }
}
