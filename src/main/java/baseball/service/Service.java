package baseball.service;

import static baseball.exception.Exception.*;

import baseball.domain.Score;
import baseball.global.ComputerSingleton;
import java.util.List;

public class Service {

    ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
    List<Integer> computerNumbers = computerSingleton.getComputerNumbers();
    Score score = new Score();

    public Score getScore(String input) {

        validateNumericInput(input);
        validateInputLength(input);
        validateUniqueNumbers(input);

        score.checkStrike(input, computerNumbers);
        score.checkBall(input, computerNumbers);
        score.setResultState();

        return score;
    }

    public boolean isRestart(String input) {

        validateRestartInput(input);

        if (input.equals("1")) {
            computerSingleton.resetComputerNumbers();
            return true;
        } else {
            return false;
        }
    }
}
