package baseball.model;

import baseball.utils.Constant;
import baseball.validation.NumberValidation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerNumber {
    private final List<Integer> number;

    public ComputerNumber() {
        this.number = createRandomNumber();
    }

    public List<Integer> createRandomNumber() {
        List<Integer> randomNumber = pickRandomNumber();
        if (!NumberValidation.isDuplicated(randomNumber)) {
            return randomNumber;
        }
        return createRandomNumber();
    }

    public List<Integer> pickRandomNumber() {
        return Arrays.stream(new List[Constant.LENGTH])
            .map(n -> Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER))
            .collect(Collectors.toList());
    }

    public List<Integer> getComputerNumber() {
        return this.number;
    }
}
