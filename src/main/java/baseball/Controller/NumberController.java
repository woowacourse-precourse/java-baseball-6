package baseball.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class NumberController {
    private static final int NUMBERS_LENGTH = 3;
    private static final int RANDOM_RANGE_START = 1;
    private static final int RANDOM_RANGE_END = 9;

    NumberValidator numberValidator = new NumberValidator();

    public Set<Integer> getRandomNumbers() {
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < NUMBERS_LENGTH) {
            randomNumbers.add(Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END));
        }
        return randomNumbers;
    }


    public Set<Integer> setingPlayerNumbers(String inputnumber) {
        inputnumber = cutString(inputnumber);
        numberValidator.playerInputCheck(inputnumber);
        numberValidator.numberTypeCheck(inputnumber);
        numberValidator.numberRangeCheck(inputnumber);
        Set<Integer> playerNumbers = new LinkedHashSet<>();
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            playerNumbers.add(Integer.parseInt(String.valueOf(inputnumber.charAt(i))));
        }
        numberValidator.duplicateCheck(playerNumbers);
        return playerNumbers;
    }

    public String cutString(String str) {
        str = str.replaceAll(" ", "");
        return str;
    }


}
