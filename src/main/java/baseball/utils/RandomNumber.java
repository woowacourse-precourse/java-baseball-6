package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public static final int THREE_DIGITS = 3;

    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < THREE_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
