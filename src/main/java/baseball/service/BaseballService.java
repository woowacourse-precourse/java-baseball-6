package baseball.service;

import static baseball.common.Constants.DIGIT_COUNT;
import static baseball.validator.InputValidator.validateGuess;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.Objects;
import baseball.domain.Baseball;
import baseball.domain.Result;

public class BaseballService {
    public Baseball inputAnswer() {
        int userInput = validateGuess(readLine());
        Baseball guess = new Baseball(userInput);
        return guess;
    }

    public Result compare(Baseball guess, Baseball answer) {
        int ballCount = 0;
        int strikeCount = 0;
        List<Integer> guessDigits = guess.getDigits();
        List<Integer> answerDigits = answer.getDigits();

        for (int index = 0; index < DIGIT_COUNT; index++) {
            if (isStrike(guessDigits, answerDigits, index)) {
                strikeCount++;
            }
            if (isBall(guessDigits, answerDigits, index)) {
                ballCount++;
            }
        }
        return new Result(ballCount, strikeCount);
    }

    private boolean isStrike(List<Integer> guessDigits, List<Integer> answerDigits, int index) {
        return Objects.equals(guessDigits.get(index), answerDigits.get(index));
    }

    private boolean isBall(List<Integer> guessDigits, List<Integer> answerDigits, int index) {
        return answerDigits.contains(guessDigits.get(index)) && !isStrike(guessDigits, answerDigits, index);
    }
}
