package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int NUMBER_SIZE = 3;

    public List<Integer> createRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();

        while(checkNumbersSize(randomNumbers)){
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE,MAX_VALUE);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    private boolean checkNumbersSize(List<Integer> numbers) {
        return numbers.size() < NUMBER_SIZE;
    }

}
