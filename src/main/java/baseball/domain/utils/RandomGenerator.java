package baseball.domain.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private static List<Integer> randomGeneratedNumber = new ArrayList<>();

    public static List<Integer> getRandomNumbers(){
        while (randomGeneratedNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomGeneratedNumber.contains(randomNumber)) {
                randomGeneratedNumber.add(randomNumber);
            }
        }
        return randomGeneratedNumber;
    }
}
