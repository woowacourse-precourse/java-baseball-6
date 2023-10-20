package baseball.controller;

import java.util.List;
import java.util.Objects;
import baseball.domain.Baseball;
import baseball.domain.Game;
import baseball.domain.Result;

public class BaseballController {
    public void start() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Game game = new Game();
        Baseball gameAnswer = game.getAnswer();
        Baseball userGuess = game.input();
        Result result = compare(userGuess, gameAnswer);
    }

    private Result compare(Baseball guess, Baseball answer) {
        Integer ballCount = 0;
        Integer strikeCount = 0;
        List<Integer> guessDigits = guess.getDigits();
        List<Integer> answerDigits = answer.getDigits();

        for (int index = 0; index < 3; index++) {
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
