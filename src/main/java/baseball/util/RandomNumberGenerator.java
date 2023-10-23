package baseball.util;

import baseball.Setting;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> createRandomNumbers() {
        List<Integer> answers = new ArrayList<>();

        while (answers.size() < Setting.BALL_SIZE.get()) {
            int randomNo = Randoms.pickNumberInRange(Setting.FIRST_NO.get(), Setting.END_NO.get());
            if (!answers.contains(randomNo)) answers.add(randomNo);
        }

        return answers;
    }
}
