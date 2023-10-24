package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> numbers;

    public ComputerNumbers() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
        return nums;
    }

    public int[] compare(List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int number = userNumbers.get(i);
            if (!numbers.contains(number)) {
                continue;
            }
            if (numbers.get(i) == number) {
                strikes++;
                continue;
            }
            balls++;
        }
        return new int[]{strikes, balls};
    }
}
