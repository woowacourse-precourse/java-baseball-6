package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.BaseballResult;
import baseball.domain.BaseballSystemConst;
import baseball.utils.NumberConverter;
import baseball.utils.NumberGenerator;
import baseball.utils.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
        do {
            List<Integer> computerRandomNumber = NumberGenerator.makeRandomNumber();
            Baseball computerBaseball = new Baseball(computerRandomNumber);
            System.out.println(computerBaseball);
            doWhileUntilThreeStrike(computerBaseball);
        } while (isGameRestart());
        return;
    }

    private void doWhileUntilThreeStrike(Baseball computerBaseball) {
        String inputUserBaseballValue;
        BaseballResult gameResult;
        do {
            Baseball userBaseball = getUserBaseball();
            gameResult = computerBaseball.compareTo(userBaseball);
            outputView.printBallStrikeResultMessage(gameResult);
        } while (!gameResult.isGameDone());
    }

    private boolean isGameRestart() {
        outputView.printRestartOrExitMessage();
        String restartOrExit = inputView.input();
        return restartOrExit.equals(BaseballSystemConst.RESTART_INPUT);
    }

    private Baseball getUserBaseball() {
        outputView.printInputNumberMessage();
        String inputUserBaseballValue = inputView.input();
        List<Integer> inputUserBaseball = NumberConverter.stringToNumber(inputUserBaseballValue);
        NumberValidator.isValid(inputUserBaseball);
        return new Baseball(inputUserBaseball);
    }

}
