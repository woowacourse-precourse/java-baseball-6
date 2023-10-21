package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers implements Numbers {

    private final List<Integer> numbers;

    ComputerNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 9, SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
