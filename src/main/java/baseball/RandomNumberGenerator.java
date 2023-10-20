package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> getNonDuplicateNumbers(GameRule rule) {
        List<Integer> uniqueNumbers = new ArrayList<>(rule.getGoalNumberLength());
        while (uniqueNumbers.size() < rule.getGoalNumberLength()) {
            int randomNumber = Randoms.pickNumberInRange(rule.getMinInclude(), rule.getMaxInclude());
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }

        return uniqueNumbers;
    }
}
