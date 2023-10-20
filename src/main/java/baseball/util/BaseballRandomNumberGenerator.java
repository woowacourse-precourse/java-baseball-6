package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballRandomNumberGenerator implements BaseballNumberGenerator{
    private final static int RANDOM_NUMBER_LENGTH = 3;
    private final static int RANDOM_NUMBER_MIN_RANGE = 1;
    private final static int RANDOM_NUMBER_MAX_RANGE = 9;

    @Override
    public List<Integer> generate() {
        List<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size() < RANDOM_NUMBER_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
            if(!isDuplicatedNumber(computerNumberList, randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    private static boolean isDuplicatedNumber(List<Integer> computerNumberList, int checkNumber){
        return computerNumberList.contains(checkNumber);
    }
}
