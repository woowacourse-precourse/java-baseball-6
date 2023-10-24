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

    private Set<Integer> answerSet = new LinkedHashSet<>();
    private List<Integer> answerList;

    public Computer() {
        while (answerSet.size() < NUMBER_DIGIT) {
            answerSet.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        answerList = setToIntegerList(answerSet);
    }

    // TODO: Computer에서 GameResult 생성 로직을 관리하는 것이 맞는지 고민하기
    public GameResult calculateGameResult(GameNumber gameNumber) {
        Integer ballCount = 0;
        Integer strikeCount = 0;

        for (int i = 0; i < NUMBER_DIGIT; i++) {
            int num = gameNumber.getNumberAt(i);

            if (isStrike(i, num)) {
                strikeCount++;
            } else if (isBall(num)) {
                ballCount++;
            }
        }
        return new GameResult(ballCount, strikeCount);
    }

    private Boolean isStrike(Integer index, Integer num) {
        return num.equals(answerList.get(index));
    }

    private Boolean isBall(Integer num) {
        return answerSet.contains(num);
    }

    private List<Integer> setToIntegerList(Set<Integer> set) {
        return Arrays.asList(set.toArray(new Integer[0]));
    }
}
