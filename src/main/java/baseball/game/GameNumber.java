package baseball.game;

import static baseball.game.GameConst.NUMBER_SIZE;

import baseball.user.UserNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameNumber {

    private final List<Integer> computerNumbers;

    public static GameNumber of() {
        return new GameNumber();
    }

    private GameNumber() {
        this.computerNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GameConst.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public GameResult compare(UserNumber userNumber) {
        List<Integer> userNumbers = userNumber.getNumbers();
        
        int strike = 0;
        int ball = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (Objects.equals(computerNumbers.get(index), userNumbers.get(index))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(index))) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }
}
