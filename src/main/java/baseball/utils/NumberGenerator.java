package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> createComputerNumbers() {
        LinkedHashSet<Integer> computerNumbers = new LinkedHashSet<>();
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        while (computerNumbers.size() < 3) {
            computerNumbers.add(randomNumber);
        }

        return new ArrayList<>(computerNumbers);
    }
}
