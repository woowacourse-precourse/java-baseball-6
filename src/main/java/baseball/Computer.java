package baseball;

import static baseball.Constants.NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final List<Integer> number;

    private Computer() {
        this.number = createRandomNumbers();
    }

    public static Computer getInstanceByRandomNumbers() {
        return new Computer();
    }

    private List<Integer> createRandomNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBER_LENGTH) {
            numbers.add(createRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
