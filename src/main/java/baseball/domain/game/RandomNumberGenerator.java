package baseball.domain.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constants.*;

public class RandomNumberGenerator {

    public static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < BALLS_SIZE) {
            int randomNumber = createRandomNumber();

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
    }
}
