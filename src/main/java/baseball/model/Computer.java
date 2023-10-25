package baseball.model;

import baseball.dto.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    public static final Integer NUMBER_DIGIT = 3;
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;

    private final List<Integer> answer;

    public Computer() {
        Set<Integer> answerSet = new LinkedHashSet<>();
        while (answerSet.size() < NUMBER_DIGIT) {
            answerSet.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        answer = setToIntegerList(answerSet);
    }

    public GameResult calculateGameResult(GameNumber gameNumber) {
        Integer ballCount = 0;
        Integer strikeCount = 0;
        List<Integer> numbers = gameNumber.getNumbers();
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            int num = numbers.get(i);

            if (isStrike(i, num)) {
                strikeCount++;
            } else if (isBall(num)) {
                ballCount++;
            }
        }
        return new GameResult(ballCount, strikeCount);
    }

    private Boolean isStrike(Integer index, Integer num) {
        return num.equals(answer.get(index));
    }

    private Boolean isBall(Integer num) {
        return answer.contains(num);
    }

    private List<Integer> setToIntegerList(Set<Integer> set) {
        return Arrays.asList(set.toArray(new Integer[0]));
    }
}
