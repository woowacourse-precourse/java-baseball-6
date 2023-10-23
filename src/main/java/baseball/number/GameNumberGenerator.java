package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGenerator {
    private static final Integer NUMBER_SIZE = 3;
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 9;

    public static String generateGameNumber() {
        List<Integer> gameNumbers = new ArrayList<>();
        while (gameNumbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!gameNumbers.contains(randomNumber)) {
                gameNumbers.add(randomNumber);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : gameNumbers) {
            stringBuilder.append(number);
        }

        return stringBuilder.toString();
    }
}
