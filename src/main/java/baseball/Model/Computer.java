package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber;
    private final int BASEBALL_NUM_SIZE = 3;

    private Computer() {
        this.computerNumber = createRandomNumbers();
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_NUM_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return new ArrayList<>(numbers);
    }

}
