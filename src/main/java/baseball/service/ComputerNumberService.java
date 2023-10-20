package baseball.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.domain.ComputerNumber;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumberService {
    private static final int NUMBER_SIZE = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    public ComputerNumber generateComputerNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_SIZE) {
            int number = pickNumberInRange(MIN_RANGE, MAX_RANGE);
            numbers.add(number);
        }
        return new ComputerNumber(convertSetToString(numbers));
    }

    public String convertSetToString(Set<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }
}
