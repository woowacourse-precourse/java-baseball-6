package baseball.service;

import baseball.config.Config;
import baseball.domain.BaseballNumbers;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    List<Integer> numbers = new ArrayList<>();

    public BaseballNumbers generateNumbers() {
        numbers.clear();
        while (Config.isNotMaxNumbers(numbers.size())) {
            int randomNumber = Randoms.pickNumberInRange(Config.getStartInclusive(), Config.getEndInclusive());
            addIfNotDuplicated(randomNumber);
        }
        return new BaseballNumbers(numbers);
    }

    private void addIfNotDuplicated(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    public Result compare(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        int ball = 0;
        int strike = 0;
        int index = 0;

        while (Config.isNotMaxNumbers(index)) {
            if (isStrike(computerNumbers, userNumbers, index)) {
                strike++;
            }
            if (isBall(computerNumbers, userNumbers, index)) {
                ball++;
            }
            index++;
        }
        return new Result(ball, strike);
    }

    private boolean isBall(BaseballNumbers computerNumbers, BaseballNumbers userNumbers, int index) {
        return computerNumbers.contains(userNumbers.get(index)) && !isStrike(computerNumbers, userNumbers, index);
    }

    private boolean isStrike(BaseballNumbers computerNumbers, BaseballNumbers userNumbers, int index) {
        return computerNumbers.get(index) == userNumbers.get(index);
    }

}
