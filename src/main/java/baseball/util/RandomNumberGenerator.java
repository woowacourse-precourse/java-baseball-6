package baseball.util;

import baseball.game.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;

    public static List<Integer> generate() {
        final List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < GameConstants.SIZE_RANDOM_NUMBER) {
            addRandomNumberWhenNotContainsList(randomNumberList);
        }
        return randomNumberList;
    }

    private static void addRandomNumberWhenNotContainsList(final List<Integer> randomNumberList) {
        final int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
        if (!randomNumberList.contains(randomNumber)) {
            randomNumberList.add(randomNumber);
        }
    }
}
