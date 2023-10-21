package baseball.controller;

import static baseball.model.GameNumbers.GAME_NUMBERS_SIZE;

import baseball.model.GameNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator {
    public GameNumbers generateAnswer() {
        Set<Integer> set = new HashSet<>(3);
        while (set.size() < GAME_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }
        return new GameNumbers(new ArrayList<>(set));
    }
}
