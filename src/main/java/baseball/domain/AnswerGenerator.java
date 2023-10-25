package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

final class AnswerGenerator {
    private static final int MIN = 1;
    private static final int MAX = 9;

    static int randomAnswer() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < BaseBall.DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            randomNumbers.add(randomNumber);
        }
        String randomNumberString = randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(randomNumberString);
    }
}