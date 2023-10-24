package baseball.domain;

import static baseball.domain.BaseballNumber.NUMBER_MAX_VALUE;
import static baseball.domain.BaseballNumber.NUMBER_MIN_VALUE;

import baseball.console.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameFactory {

    public static BaseballNumbers createComputerNumbers() {
        List<BaseballNumber> computerNumbers = new ArrayList<>();
        Set<Integer> isDuplicateSet = new HashSet<>();

        while (computerNumbers.size() < BaseballNumbers.NUMBERS_MAX_SIXE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);

            isDuplicateSet.add(randomNumber);
            if (computerNumbers.size() + 1 != isDuplicateSet.size()) {
                continue;
            }

            computerNumbers.add(new BaseballNumber(randomNumber));
        }
        return new BaseballNumbers(computerNumbers);
    }

    public static BaseballNumbers createUserNumbers(String numbers) {
        List<BaseballNumber> userNumbers = new ArrayList<>();

        while (userNumbers.size() < numbers.length()) {
            userNumbers.add(new BaseballNumber(numbers.charAt(userNumbers.size()) - Constant.CHAR_ZERO));
        }
        return new BaseballNumbers(userNumbers);
    }
}
