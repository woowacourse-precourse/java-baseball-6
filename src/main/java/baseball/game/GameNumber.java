package baseball.game;

import static baseball.game.GameConst.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameNumber {

    private static List<Integer> computerNumber;

    private GameNumber() {
    }

    public static void generateNumbers() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < GameConst.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static GameResult compare(List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (Objects.equals(computerNumber.get(index), userNumbers.get(index))) {
                strike++;
            } else if (computerNumber.contains(userNumbers.get(index))) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }
}
