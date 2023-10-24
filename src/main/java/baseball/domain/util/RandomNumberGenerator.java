package baseball.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public String  generateNumbers() {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            numbers.append(generate());
        }
        return numbers.toString();
    }
}
