package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    private final List<Integer> computerNumbers;

    ComputerNumbers() {
        computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
