package baseball.domain;

import static baseball.util.Constants.MAX_INPUT_LENGTH;
import static baseball.util.Constants.MAX_INPUT_RANGE;
import static baseball.util.Constants.MIN_INPUT_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> computerNums;

    public ComputerNumbers() {
        this.computerNums = generateNumber();
    }

    public List<Integer> getComputerNums() {
        return new ArrayList<>(computerNums);
    }

    public List<Integer> generateNumber() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < MAX_INPUT_LENGTH) {
            int randomNum = pickRandomNumber();
            if (!computerNums.contains(randomNum)) {
                computerNums.add(randomNum);
            }
        }
        return computerNums;
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_INPUT_RANGE, MAX_INPUT_RANGE);
    }
}
