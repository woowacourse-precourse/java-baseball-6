package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
    public static int generateRandomNumber() {
        Set<Integer> usedDigits = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (usedDigits.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);

            if (!usedDigits.contains(randomDigit)) {
                sb.append(randomDigit);
                usedDigits.add(randomDigit);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
