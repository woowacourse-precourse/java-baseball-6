package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public final class AnswerGenerator {
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int DIGITS = 3;

    public static int randomAnswer() {
        String randomNumberString = Randoms.pickUniqueNumbersInRange(MIN, MAX, 3)
                .stream()
                .limit(DIGITS)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(randomNumberString);
    }

    public static int generate(String wantAnswer) {
        return Integer.parseInt(wantAnswer);
    }
}
