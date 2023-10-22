package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    List<Integer> numbers = new ArrayList<>();
    static final int MAX_NUMBERS = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    public BaseballNumbers generateNumbers(){
        numbers.clear();
        while(numbers.size() < MAX_NUMBERS){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if(isNotDuplicated(randomNumber)) numbers.add(randomNumber);
        }
        return new BaseballNumbers(numbers);
    }

    private boolean isNotDuplicated(int randomNumber) {
        return !numbers.contains(randomNumber);
    }

    public Result compare(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        int ball = 0;
        int strike = 0;
        for (int index = 0; index < MAX_NUMBERS; index++){
            if(isStrike(computerNumbers, userNumbers, index)) strike++;
            if(isBall(computerNumbers, userNumbers, index)) ball++;
        }
        return new Result(ball, strike);
    }

    private boolean isBall(BaseballNumbers computerNumbers, BaseballNumbers userNumbers, int index) {
        int number = userNumbers.get(index);
        return computerNumbers.contains(number) && !isStrike(computerNumbers, userNumbers, index);
    }

    private boolean isStrike(BaseballNumbers computerNumbers, BaseballNumbers userNumbers, int index) {
        return computerNumbers.get(index) ==  userNumbers.get(index);
    }

}
