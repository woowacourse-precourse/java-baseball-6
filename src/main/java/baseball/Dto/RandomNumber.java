package baseball.Dto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumber {
    private List<Integer> computer;
    public void createRandomNumber() {
        this.computer = IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> requestComputer() {
        return Collections.unmodifiableList(computer);
    }
}
