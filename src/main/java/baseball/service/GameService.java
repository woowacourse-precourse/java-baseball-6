package baseball.service;
import baseball.config.Config;
import baseball.domain.BaseballNumbers;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    List<Integer> numbers = new ArrayList<>();

    public BaseballNumbers generateNumbers(){
        numbers.clear();
        while(numbers.size() < Config.getMaxNumbers()){
            int randomNumber = Randoms.pickNumberInRange(Config.getStartInclusive(), Config.getEndInclusive());
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
        for (int index = 0; index < Config.getMaxNumbers(); index++){
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
