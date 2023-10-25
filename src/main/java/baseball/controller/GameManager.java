package baseball.controller;

import baseball.service.GameResult;
import baseball.service.Referee;
import baseball.service.domain.BaseballCollection;
import baseball.service.domain.RandomNumberGenerator;
import baseball.utils.ConsoleMessage;
import baseball.utils.RestartCommandValidator;
import baseball.view.Input;
import baseball.view.Output;

public class GameManager {
    private final RestartCommandValidator validator;
    private final Referee judgment;
    private final Input input;

    public GameManager(RestartCommandValidator validator, Referee judgment, Input input) {
        this.validator = validator;
        this.judgment = judgment;
        this.input = input;
    }

    public void initialGameStart() {
        ConsoleMessage.INITIAL_GAME_START.printMessage();
        boolean gameTotallyEnd = false;
        while (!gameTotallyEnd) {
            progressGame();
            gameTotallyEnd = isNoMoreGame();
        }
    }

    private void progressGame() {
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(new RandomNumberGenerator());
        boolean gameEnd = false;
        while (!gameEnd) {
            GameResult gameResult = startGameRound(computerBalls);
            gameEnd = gameResult.isGameEnd();
        }
        ConsoleMessage.GAME_END.printMessage();
    }

    private GameResult startGameRound(BaseballCollection computerBalls) {
        ConsoleMessage.NUMBER_INPUT.printMessage();
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball(input.readLine());
        GameResult gameResult = judgment.calculateHint(computerBalls, playerBalls);
        Output.printHint(gameResult.getHint());
        return gameResult;
    }

    private boolean isNoMoreGame() {
        ConsoleMessage.RESTART_GAME.printMessage();
        String restartCommand = input.readLine();
        validator.validateRestartCommandInput(restartCommand);
        return restartCommand.equals("2");  // TODO: 여기서 "2"로 직접 확인하는게 거슬림. 1은 재시작, 2는 종료를 관리하는 객체가 있으면 좋지않을까..
    }
}
