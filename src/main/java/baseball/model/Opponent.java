package baseball.model;

import static baseball.Constants.MAX_NUM;
import static baseball.Constants.MIN_NUM;
import static baseball.Constants.NUMBER_COUNTS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Opponent {

    private static final int FIRST_INDEX = 0;
    private static final int NUMBER_NOT_FOUND = -1;


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
        for (int index = FIRST_INDEX; index < guessedNumbers.size(); index++) {
            int numberIndex = numbers.indexOf(guessedNumbers.get(index));
            if (numberIndex == NUMBER_NOT_FOUND) {
                continue;
            }

            if (numberIndex == index) {
                result.addStrikeCount();
                continue;
            }

            result.addBallCount();
        }
        return result;
    }
}
