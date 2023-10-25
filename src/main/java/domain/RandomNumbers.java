package domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private final int RANDOM_COUNT = 3;

    private static List<Integer> randomNumbers;

    public RandomNumbers() {
        this.randomNumbers = drawRandomNumbers();
    }

    // drawRandomNumbers: 랜덤 넘버를 세 개 지정
    private List<Integer> drawRandomNumbers() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != RANDOM_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
