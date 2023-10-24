package baseball.others;

import static baseball.others.Constant.MAX_RANGE;
import static baseball.others.Constant.MIN_RANGE;
import static baseball.others.Constant.NUMBER_OF_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> computerGenerateNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_OF_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}