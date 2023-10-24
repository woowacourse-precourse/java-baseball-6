package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameNumber {

    private static final int NUMBER_SIZE = 3;

    public static List<Integer> generateNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static GameResult compare(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (Objects.equals(computerNumber.get(index), userNumber.get(index))) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(index))) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }
}
