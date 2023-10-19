package baseball.model;

import static baseball.Constants.MAX_NUM;
import static baseball.Constants.MIN_NUM;
import static baseball.Constants.NUMBER_COUNTS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Opponent {

    private final List<Integer> numbers;

    private Opponent(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Opponent createOpponent() {
        List<Integer> pickedNumbers = new ArrayList<>();
        while (pickedNumbers.size() < NUMBER_COUNTS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!pickedNumbers.contains(randomNumber)) {
                pickedNumbers.add(randomNumber);
            }
        }
        return new Opponent(pickedNumbers);
    }

    public GuessResult calculateResult(final UserNumbers userNumbers) {
        GuessResult result = new GuessResult();
        List<Integer> guessedNumbers = userNumbers.getNumbers();
        for (int i = 0; i < guessedNumbers.size(); i++) {
            int numberIndex = numbers.indexOf(guessedNumbers.get(i));
            if (numberIndex == -1) {
                continue;
            }

            if (numberIndex == i) {
                result.addStrikeCount();
                continue;
            }

            result.addBallCount();
        }

        return result;
    }
}
