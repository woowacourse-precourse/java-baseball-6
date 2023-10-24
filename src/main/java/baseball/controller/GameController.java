package baseball.controller;

import baseball.Util.MessageUtil;
import baseball.dto.Result;
import baseball.service.GameService;

public class GameController {
    private final GameService gameService;
    private final MessageUtil messageUtil;

    public GameController(GameService gameService, MessageUtil messageUtil) {
        this.gameService = gameService;
        this.messageUtil = messageUtil;
    }


    public void play() {
        messageUtil.printStart();

        while (!gameService.isRoundEnd()) {
            messageUtil.printInput();

            Result result = gameService.playRound();
            messageUtil.printResult(result);

            if (gameService.isWin(result)) {
                messageUtil.printWin();
                gameService.setRoundEnd();
            }
        }
        messageUtil.printAskCommand();
        restartByCommand();
    }

    private void restartByCommand() {
        if (gameService.askCommand()) {
            gameService.init();
            play();
        }
    }
}
