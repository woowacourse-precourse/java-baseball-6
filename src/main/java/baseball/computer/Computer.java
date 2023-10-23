package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int MIN_GAME_NUMBER_RANGE = 1;
    private static final int MAX_GAME_NUMBER_RANGE = 9;

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() != GAME_NUMBER_SIZE) {
            int randomNumber = pickRandomNumber();

            if (answer.contains(randomNumber)) {
                continue;
            }

            answer.add(randomNumber);
        }
        return answer;
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_GAME_NUMBER_RANGE, MAX_GAME_NUMBER_RANGE);
    }
}
