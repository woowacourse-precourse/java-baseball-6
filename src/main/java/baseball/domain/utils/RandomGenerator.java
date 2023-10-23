package baseball.domain.utils;

import baseball.domain.game.Input;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public static List<Integer> getRandomNumbers() {
        List<Integer> randomGeneratedNumber = new ArrayList<>();
        while (randomGeneratedNumber.size() < Input.NUMLENGTH.getLength()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomGeneratedNumber.contains(randomNumber)) {
                randomGeneratedNumber.add(randomNumber);
            }
        }
        return randomGeneratedNumber;
    }
}
