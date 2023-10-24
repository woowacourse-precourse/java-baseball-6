package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    public static final Integer NUMBER_DIGIT = 3;
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;

    private Set<Integer> answer = new LinkedHashSet<>();

    // TODO: 메소드 분리하기
    public GameResult calculateGameResult(GameNumber gameNumber) {
        Integer ballCount = 0;
        Integer strikeCount = 0;
        List<Integer> nums = Arrays.asList(answer.toArray(new Integer[0]));
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            int num = gameNumber.getNumberAt(i);
            if (num == nums.get(i)) {
                strikeCount += 1;
                continue;
            }
            if (answer.contains(num)) {
                ballCount += 1;
            }
        }
        return new GameResult(ballCount, strikeCount);
    }

    public Computer() {
        while (answer.size() < NUMBER_DIGIT) {
            answer.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
    }
}
