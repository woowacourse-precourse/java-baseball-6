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

        while (!gameService.isGameEnd()) {
            messageUtil.printInput();

            Result result = gameService.play();
            messageUtil.printResult(result);

            if (gameService.isWin(result)) {
                messageUtil.printWin();
                gameService.setGameEnd();
            }
        }

        messageUtil.printAskRestart();
        Integer command = gameService.getCommand();

        if (command.equals(1)) {
            gameService.init(); // isGameEnd의 값을 false로 재설정
            play();
        }
    }
}
