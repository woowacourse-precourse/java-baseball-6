package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static final int NUMBER_COUNT = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static List<Integer> generateNumber() {
        List<Integer> gameNumber = new ArrayList<>();
        while(gameNumber.size() != NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!gameNumber.contains(randomNumber)) {
                gameNumber.add(randomNumber);
            }
        }
        return gameNumber;
    }
}
