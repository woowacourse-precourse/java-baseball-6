package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import static baseball.BaseballConstants.*;

public class NumberGenerator {

    private final Set<Integer> numbers = new HashSet<>();

    public Set<Integer> generateRandomNum() {
        addRandomNumbers();
        return getNumbers();
    }


    public void reset() {
        numbers.clear();
    }

    private void addRandomNumbers() {
        while (canGenerate()){
            int number = createRandomNum();
            numbers.add(number);
        }
    }
    private boolean canGenerate() {
        return !cannotGenerate();
    }

    private boolean cannotGenerate() {
        return numbers.size() >= NUM_MAX_SIZE;
    }

    public Set<Integer> getNumbers() {
        return new HashSet<>(numbers);
    }
    private int createRandomNum() {
        return Randoms.pickNumberInRange(PICK_MIN_NUM, PICK_MAX_NUM);
    }

}
