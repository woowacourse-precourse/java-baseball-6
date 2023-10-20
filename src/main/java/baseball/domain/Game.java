package baseball.domain;

import static baseball.domain.Baseball.createAnswer;
import static baseball.validator.InputValidator.validateGuess;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private Baseball answer;

    public Game() {
        answer = createAnswer();
    }

    public Baseball input() {
        System.out.print("숫자를 입력해주세요 : ");
        Integer userInput = validateGuess(readLine());
        Baseball userGuess = new Baseball(userInput);
        return userGuess;
    }

    public Baseball getAnswer() {
        return answer;
    }
}
