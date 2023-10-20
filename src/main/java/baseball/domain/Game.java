package baseball.domain;

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
        Integer ballCount = countBall(guess, answer);
        Integer strikeCount = countStrike(guess, answer);
        return new Result(ballCount, strikeCount);
    }

    private Integer countBall(Baseball guess, Baseball answer) {
        Integer count = 0;
        Integer guessHundreds = guess.getHundreds();
        Integer answerHundreds = answer.getHundreds();
        Integer guessTens = guess.getTens();
        Integer answerTens = answer.getTens();
        Integer guessOnes = guess.getOnes();
        Integer answerOnes = answer.getOnes();
        if (guessHundreds.equals(answerTens) || guessHundreds.equals(answerOnes)) {
            count++;
        }
        if (guessTens.equals(answerHundreds) || guessTens.equals(answerOnes)) {
            count++;
        }
        if (guessOnes.equals(answerHundreds) || guessOnes.equals(answerTens)) {
            count++;
        }
        return count;
    }

    private Integer countStrike(Baseball guess, Baseball answer) {
        Integer count = 0;
        Integer guessHundreds = guess.getHundreds();
        Integer answerHundreds = answer.getHundreds();
        Integer guessTens = guess.getTens();
        Integer answerTens = answer.getTens();
        Integer guessOnes = guess.getOnes();
        Integer answerOnes = answer.getOnes();
        if (guessHundreds.equals(answerHundreds)) {
            count++;
        }
        if (guessTens.equals(answerTens)) {
            count++;
        }
        if (guessOnes.equals(answerOnes)) {
            count++;
        }
        return count;
    }
}
