package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }
}
