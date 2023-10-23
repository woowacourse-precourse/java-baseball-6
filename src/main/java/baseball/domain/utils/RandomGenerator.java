package baseball.domain.utils;

import baseball.domain.game.Input;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private List<Integer> randomGeneratedNumber = new ArrayList<>();

    public List<Integer> getRandomNumbers() {
        while (randomGeneratedNumber.size() < Input.NUMLENGTH.getLength()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomGeneratedNumber.contains(randomNumber)) {
                randomGeneratedNumber.add(randomNumber);
            }
        }
        return randomGeneratedNumber;
    }
}
