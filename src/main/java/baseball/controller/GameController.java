package baseball.controller;

import baseball.domain.NumberBaseballGame;
import baseball.domain.dto.Result;
import baseball.global.constant.GameCode;
import baseball.global.constant.RuleValue;
import baseball.global.message.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberBaseballGame numberBaseballGame;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberBaseballGame = new NumberBaseballGame();
    }

    public void run(){
        System.out.println(GameMessage.GAME_START_MESSAGE.getMessage());
        playUntilInputQuitCode();
    }

    private void playUntilInputQuitCode() {
        int gameCodeInput;
        do {
            numberBaseballGame.initGameSetting();
            playUntilBaseballNumberMatch();
            gameCodeInput = inputView.requestGameCodeInput();
        } while (gameCodeInput == GameCode.RESTART_CODE);
    }

    private void playUntilBaseballNumberMatch() {
        Result result;
        do {
            int playerInput = inputView.requestBaseballNumberInput();
            result = numberBaseballGame.makeResult(playerInput);
            outputView.responseResult(result);
        } while (result.getStrike() != RuleValue.BASEBALL_NUMBER_SIZE);
    }
}
