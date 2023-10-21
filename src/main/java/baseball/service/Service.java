package baseball.service;

import baseball.domain.Score;
import baseball.exception.Exception;
import baseball.global.ComputerSingleton;
import java.util.List;

public class Service {

    ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
    List<Integer> computer = computerSingleton.getComputer();
    Score score = new Score();

    public Score getScore(String input) {

        Exception.validateInputLength(input);
        Exception.validateNumericInput(input);

        score.checkStrike(input, computer);
        score.checkBall(input, computer);
        score.setResultState(score.getBall(), score.getStrike());

        return score;
    }

    public boolean isRestart(String input) {

        Exception.validateRestartInput(input);
        
        if (input.equals("1")) {
            computerSingleton.resetComputer();
            return true;
        } else {
            return false;
        }
    }
}
