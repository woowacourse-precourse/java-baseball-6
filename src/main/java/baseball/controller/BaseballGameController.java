package baseball.controller;

import baseball.common.config.BaseballSystemConst;
import baseball.common.utils.NumberConverter;
import baseball.common.utils.NumberGenerator;
import baseball.common.utils.NumberValidator;
import baseball.domain.Baseball;
import baseball.domain.BaseballResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
        doStartWhileUntilInputExit();
    }

    private void doStartWhileUntilInputExit() {
        do {
            List<Integer> computerRandomNumber = NumberGenerator.makeRandomNumber();
            Baseball computerBaseball = new Baseball(computerRandomNumber);
            doPlayWhileUntilThreeStrike(computerBaseball);
        } while (isGameRestart());
    }

    private void doPlayWhileUntilThreeStrike(Baseball computerBaseball) {
        BaseballResult gameResult;
        do {
            Baseball userBaseball = getUserBaseball();
            gameResult = computerBaseball.compareTo(userBaseball);
            outputView.printBallStrikeResultMessage(gameResult);
        } while (!gameResult.isGameDone());
    }

    private String askGameRestartOrExit() {
        outputView.printRestartOrExitMessage();
        return inputView.input();
    }

    private String askUserNumbers() {
        outputView.printInputNumberMessage();
        return inputView.input();
    }

    private boolean isGameRestart() {
        String restartOrExit = askGameRestartOrExit();
        return restartOrExit.equals(BaseballSystemConst.RESTART_INPUT);
    }

    private Baseball getUserBaseball() {
        String inputUserBaseballValue = askUserNumbers();
        List<Integer> inputUserBaseball = NumberConverter.stringToNumber(inputUserBaseballValue);
        NumberValidator.isValid(inputUserBaseball);
        return new Baseball(inputUserBaseball);
    }


}
