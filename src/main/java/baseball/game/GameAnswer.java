package baseball.game;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class GameAnswer {
    private static GameAnswer instance;

    private GameAnswer() {
    }

    public static GameAnswer getInstance() {
        if (instance == null) {
            instance = new GameAnswer();
        }
        return instance;
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();

        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }

        return digits;
    }
}
