package baseball.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }

    @Override
    public String generateRandomNumbers() {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            numbers.append(generate());
        }
        return numbers.toString();
    }
}
