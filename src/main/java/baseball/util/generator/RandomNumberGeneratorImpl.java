package baseball.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    @Override
    public List<Integer> pickUniqueRandomNumber(int numberDigits, int startInclusive, int endInclusive) {
        List<Integer> randomNumberList = new ArrayList<>();
        while ( randomNumberList.size() < numberDigits ) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}
