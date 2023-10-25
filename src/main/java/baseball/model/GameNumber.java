package baseball.model;

import static baseball.utils.Message.*;

import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    public static final String GAME_RESTART = "1";
    public static final int NUM_LENGTH = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    public static List<Integer> generateNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < NUM_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }

    public static boolean getRestartInput(String input) {
        return input.equals(GAME_RESTART);
    }
}
