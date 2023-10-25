package baseball.controller;

import baseball.service.GameResult;
import baseball.service.Judgement;
import baseball.service.domain.BaseballCollection;
import baseball.service.domain.RandomNumberGenerator;
import baseball.view.Input;
import baseball.view.Output;

public class GameManager {
    private final RestartCommandValidator validator;
    private final Judgement judgment;
    private final Input input;

    public GameManager(RestartCommandValidator validator, Judgement judgment, Input input) {
        this.validator = validator;
        this.judgment = judgment;
        this.input = input;
    }

    public void initialGameStart() {
        Output.printInitialGameStartMessage();
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
        Output.printGameEndMessage();
    }

    private GameResult startGameRound(BaseballCollection computerBalls) {
        Output.printNumberInputMessage();
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball(input.readLine());
        GameResult gameResult = judgment.calculateHint(computerBalls, playerBalls);
        Output.printHint(gameResult.getHint());
        return gameResult;
    }

    private boolean isNoMoreGame() {
        Output.printRestartGameMessage();
        String restartCommand = input.readLine();
        validator.validateRestartCommandInput(restartCommand);
        return restartCommand.equals("2");  // TODO: 여기서 "2"로 직접 확인하는게 거슬림. 1은 재시작, 2는 종료를 관리하는 객체가 있으면 좋지않을까..
    }
}
