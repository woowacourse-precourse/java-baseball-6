package baseball.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGeneration {

    private static final int GAME_RULE_NUMBER_LENGTH = 3;
    private static final int GAME_RULE_RANDOM_RANGE_START = 1;
    private static final int GAME_RULE_RANDOM_RANGE_END = 9;

    public List<Integer> GenerateRandomNumber() {
        List<Integer> RandomNumbers = new ArrayList<>();
        while (RandomNumbers.size() < GAME_RULE_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GAME_RULE_RANDOM_RANGE_START, GAME_RULE_RANDOM_RANGE_END);
            if (!RandomNumbers.contains(randomNumber)) {
                RandomNumbers.add(randomNumber);
            }
        }
        return RandomNumbers;
    }
}
