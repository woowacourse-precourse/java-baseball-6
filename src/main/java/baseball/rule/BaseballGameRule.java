package baseball.rule;

import baseball.computer.Computer;
import baseball.domain.number.GameNumber;
import baseball.domain.result.Result;
import java.util.List;
import java.util.Objects;

public class BaseballGameRule implements Rule {

    @Override
    public Result check(GameNumber userNumbers, Computer computer) {
        List<Integer> computerNumbers = computer.getGameNumbers();
        Integer ball = 0;
        Integer strike = 0;
        for (int digitIndex = 0; digitIndex < computerNumbers.size(); digitIndex++) {
            int searchedIndex = userNumbers.findDigitIndex(computerNumbers.get(digitIndex));
            if (isStrike(searchedIndex, digitIndex)) {
                strike++;
            } else if (searchedIndex >= 0) {
                ball++;
            }
        }
        return new Result(ball, strike);
    }

    private boolean isStrike(Integer searchedIndex, Integer digitIndex) {
        return Objects.equals(searchedIndex, digitIndex);
    }
}
