package baseball.service;

import static baseball.global.Validation.validateGameInput;
import static baseball.global.Validation.validateRestartInput;

import baseball.domain.Result;
import baseball.global.ComputerSingleton;
import java.util.List;

public class Service {

    ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
    List<Integer> computerNumbers = computerSingleton.getComputerNumbers();
    Result result = new Result();

    public Result calculateGameResult(String input) {

        validateGameInput(input);

        result.checkStrike(input, computerNumbers);
        result.checkBall(input, computerNumbers);
        result.setResultState();

        return result;
    }

    public boolean isRestart(String input) {

        validateRestartInput(input);

        boolean isRestart = input.equals("1");
        if (isRestart) {
            computerSingleton.resetComputerNumbers();
        }
        return isRestart;
    }
}
