package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.Balls.BALL_SIZE;
import static baseball.model.BallNo.FIRST_NO;
import static baseball.model.BallNo.END_NO;

public class RandomNumberGenerator {

    public static List<Integer> createRandomNumbers() {
        List<Integer> answers = new ArrayList<>();

        while (answers.size() < BALL_SIZE) {
            int randomNo = Randoms.pickNumberInRange(FIRST_NO, END_NO);
            if (!answers.contains(randomNo)) answers.add(randomNo);
        }

        return answers;
    }
}
