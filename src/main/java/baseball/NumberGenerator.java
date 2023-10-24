package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {
    private final int NUM_MAX_SIZE = 3;
    private final int PICK_MIN_NUM = 1;
    private final int PICK_MAX_NUM = 9;
    private final Set<Integer> numbers = new HashSet<>();

    public void generateRandomNum() {
        while (canGenerate()){
            int number = createRandomNum();
            numbers.add(number);
        }
    }
    private boolean canGenerate() {
        return !cannotGenerate();
    }

    private boolean cannotGenerate() {
        return numbers.size() == NUM_MAX_SIZE;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
    private int createRandomNum() {
        return Randoms.pickNumberInRange(PICK_MIN_NUM, PICK_MAX_NUM);
    }

}
