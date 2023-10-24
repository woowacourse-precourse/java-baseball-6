package baseball.util;

import baseball.model.Result;
import baseball.model.Score;
import baseball.model.Value;

import java.util.List;

public class ScoreChecker {
    public static Score checkScore(Value value, Result result) {
        int strike = 0;
        int ball = 0;

        List<Integer> valueList = value.getNumbers();
        List<Integer> resultList = result.getNumbers();

        for (int i = 0; i < valueList.size(); i++) {
            if (valueList.get(i).equals(resultList.get(i))) {
                strike++;
            } else if (contains(resultList, valueList.get(i))) {
                ball++;
            }
        }

        return new Score(strike, ball);
    }

    private static boolean contains(List<Integer> list, int value) {
        return list.contains(value);
    }
}
