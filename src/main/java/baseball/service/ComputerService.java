package baseball.service;

import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputerService {
    public List<Integer> generateBaseballNumber() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }

    public BaseballNumber createComputerWithRandomNumber() {
        List<Integer> randomNumbers = generateBaseballNumber();
        return new BaseballNumber(randomNumbers);
    }
}
