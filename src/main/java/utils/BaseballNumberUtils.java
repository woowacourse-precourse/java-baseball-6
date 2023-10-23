package utils;

import static utils.GameConstant.BASEBALL_GAME_NUMBER_LENGTH;
import static utils.GameErrorMessage.INVALID_LENGTH_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberUtils {
    private BaseballNumberUtils() {
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < BASEBALL_GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

}
