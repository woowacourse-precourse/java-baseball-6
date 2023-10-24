package baseball.util;

import baseball.constant.GameRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class MakeRandomAnswer {

    public static int[] getRandomNumber() {
        int[] randomAnswer = new int[3];

        for (int i = 0; i < GameRule.DIGIT; i++) {
            int randomNumber = Randoms.pickNumberInRange(GameRule.RANGE_FROM, GameRule.RANGE_TO);

            while (!isUnique(randomAnswer, randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(GameRule.RANGE_FROM, GameRule.RANGE_TO);
            }
            randomAnswer[i] = randomNumber;
        }

        return randomAnswer;
    }

    public static Boolean isUnique(int[] randomAnswer, int randomNumber) {
        return !Arrays.stream(randomAnswer).anyMatch(number -> number == randomNumber);
    }

}
