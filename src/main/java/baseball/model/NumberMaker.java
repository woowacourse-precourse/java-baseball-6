package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class NumberMaker {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBERS_SIZE = 3;

    public List<Integer> makeAutoNumbers() {
        return Stream.generate(this::pickRandomNumber)
                .distinct()
                .limit(NUMBERS_SIZE)
                .toList();
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
