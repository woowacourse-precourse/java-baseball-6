package baseball.domain;

import java.util.List;
import java.util.Objects;

import static baseball.domain.Baseball.createAnswer;
import static baseball.validator.InputValidator.validateGuess;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private Baseball answer;

    public Game() {
        answer = createAnswer();
    }

    public void start() {
        System.out.println("숫자를 입력해주세요 : ");
        Integer userInput = validateGuess(readLine());
        Baseball userGuess = new Baseball(userInput);
    }

    public Result compareWithAnswer(Baseball guess) {
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
