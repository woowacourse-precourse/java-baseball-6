package baseball.util;

import baseball.constant.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Number.SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Number.MIN, Number.MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
