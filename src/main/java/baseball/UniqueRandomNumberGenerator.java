package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class UniqueRandomNumberGenerator {

    List<Integer> randomNumber;

    private UniqueRandomNumberGenerator(int startInclusive, int endInclusive, int count) {
        this.randomNumber = generateUniqueNumbers(startInclusive, endInclusive, count);
    }

    public static List<Integer> randomNumberList(int startInclusive, int endInclusive, int count) {
        return new UniqueRandomNumberGenerator(startInclusive, endInclusive, count).getRandomNumber();
    }

    private List<Integer> generateUniqueNumbers(int startInclusive, int endInclusive, int count) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
        return uniqueNumbers;
    }

    private List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
