package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBallGenerator {
    static final int MIN_NUMBER_RANGE = 1;
    static final int MAX_NUMBER_RANGE = 9;
    static final int MAX_BALL_SIZE = 3;

    public List<Integer> generateRandomNumber() {
        List<Integer> pickedNumbers = new ArrayList<>();
        while (pickedNumbers.size() < MAX_BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            if (!pickedNumbers.contains(randomNumber)) {
                pickedNumbers.add(randomNumber);
            }
        }
        return pickedNumbers;
    }

}
