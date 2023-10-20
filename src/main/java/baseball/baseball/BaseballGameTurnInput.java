package baseball.baseball;

import baseball.game.turn.TurnBasedGameService;
import baseball.game.turn.TurnInput;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameTurnInput implements TurnInput {

    private final BaseballNumber baseballNumber;

    public BaseballGameTurnInput(String input) {
        valid(input);
        baseballNumber = createBaseballNumber(input);
    }

    private BaseballNumber createBaseballNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(ch - '0');
        }
        return new BaseballNumber(numbers);
    }

    private void valid(String input) {
        validLength(input);

        int[] countNumbers = new int[10];
        for (char ch : input.toCharArray()) {
            validIsNumber(ch);
            validDuplicate(countNumbers, ch);
        }
    }

    private void validDuplicate(int[] countNumbers, char ch) {
        if (countNumbers[ch - '0']++ == 2) {
            throw new IllegalArgumentException("입력은 서로 다른 숫자여야 합니다.");
        }
    }

    private void validIsNumber(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
    }

    private void validLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
    }

    private BaseballGameTurnResult calculateResult(BaseballNumber answer) {
        int numBall = answer.countBall(baseballNumber);
        int numStrike = answer.countStrike(baseballNumber);

        return new BaseballGameTurnResult(numBall, numStrike);
    }

    @Override
    public BaseballGameTurnResult calculateResult(TurnBasedGameService gameService) {
        BaseballNumber answer = ((BaseballGameService) gameService).getAnswer();
        return calculateResult(answer);
    }
}
