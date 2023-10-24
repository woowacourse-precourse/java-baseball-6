package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static List<Integer> getRandomNumbers(int gameSize, int startDigit, int endDigit) {
        List<Integer> result = new ArrayList<>();
        while (result.size() < gameSize) {
            int randomNumber = Randoms.pickNumberInRange(startDigit, endDigit);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }
}
