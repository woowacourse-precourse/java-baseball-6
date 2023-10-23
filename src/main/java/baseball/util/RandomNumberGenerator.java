package baseball.util;

import baseball.domain.GameNumberSet;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generate() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < GameNumberSet.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
