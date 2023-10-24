package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> nums;

    public Computer() {
        this.nums = createRandomNumbers();
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(pickNumber)) {
                randomNumbers.add(pickNumber);
            }
        }
        return randomNumbers;
    }

    public void shuffleNums() {
        this.nums = createRandomNumbers();
    }

    public List<Integer> getNums() {
        return nums;
    }
}
