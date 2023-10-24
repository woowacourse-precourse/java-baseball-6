package baseball.util;

import baseball.console.Constant;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameFactory {

    private static final int NUMBERS_MAX_SIXE = 3;
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 9;

    public static BaseballNumbers createComputerNumbers() {
        List<BaseballNumber> computerNumbers = new ArrayList<>();
        Set<Integer> isDuplicateSet = new HashSet<>();

        while (computerNumbers.size() < NUMBERS_MAX_SIXE) {
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
