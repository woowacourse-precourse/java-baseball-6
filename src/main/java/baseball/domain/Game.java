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


}
