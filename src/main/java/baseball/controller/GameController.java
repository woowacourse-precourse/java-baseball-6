package baseball.controller;

import baseball.Util.MessageUtil;
import baseball.dto.Result;
import baseball.service.GameService;
import baseball.service.UserService;

import java.util.List;

public class GameController {
    private final UserService userService;
    private final GameService gameService;
    private final MessageUtil messageUtil;

    public GameController(UserService userService, GameService gameService, MessageUtil messageUtil) {
        this.userService = userService;
        this.gameService = gameService;
        this.messageUtil = messageUtil;

        gameService.init();
    }


    public void play() {
        messageUtil.printStart();
        List<Integer> answer = gameService.createAnswer();

        while (!gameService.isRoundEnd()) {
            messageUtil.printInput();

            Result result = gameService.playRound(answer, userService.getInput());
            messageUtil.printResult(result);
            checkRoundEnd(result);
        }
        messageUtil.printAskCommand();
        restartByCommand();
    }

    private void checkRoundEnd(Result result) {
        if (gameService.isWin(result)) {
            messageUtil.printWin();
            gameService.setRoundEnd();
        }
    }

    private void restartByCommand() {
        if (userService.askCommand()) {
            gameService.init();
            play();
        }
    }
}
