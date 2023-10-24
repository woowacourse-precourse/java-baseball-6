package baseball.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public RandomNumberGenerator(int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    public List<Integer> generateUniqueNumbers() {
        List<Integer> uniqueNumbers = new ArrayList<>();
        while (uniqueNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
        return uniqueNumbers;
    }
}
