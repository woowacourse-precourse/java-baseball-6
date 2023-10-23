package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator{

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final int NUMBER_SIZE = 3;

    @Override
    public List<Integer> generateNumberInRange() {
        List<Integer> randomNumbers = new ArrayList<>();
        // size 검사
        while(randomNumbers.size() < NUMBER_SIZE) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            // 중복 검사
            if(!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }

        return randomNumbers;
    }
    
}
