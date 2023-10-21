package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumberGenerator implements RandomNumberGenerator {
    private final int MIN_BALL_NUMBER = 1;
    private final int MAX_BALL_NUMBER = 9;

    @Override
    public int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    @Override
    public List<Integer> createUniqueNumbers(int size) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < size) {
            int randomNumber = generateRandomNumber(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
        return uniqueNumbers;
    }
}
