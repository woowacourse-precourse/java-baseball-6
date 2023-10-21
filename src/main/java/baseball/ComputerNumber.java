package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ComputerNumber {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;
    private final int MAX_LENGTH = 3;

    private List<Integer> computerNumbers;

    private ComputerNumber() {
        this.computerNumbers = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        LinkedHashSet<Integer> tempNumbers = new LinkedHashSet<>();

        while (tempNumbers.size() < MAX_LENGTH) {
            tempNumbers.add(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
        }

        return new ArrayList<>(tempNumbers);
    }
}
