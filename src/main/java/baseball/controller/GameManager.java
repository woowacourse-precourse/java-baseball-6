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

    // 기능: 게임을 최초로 시작한다
    public void initialGameStart() {
        Output.printInitialGameStartMessage();
        while (true) {
            progressGame();
            if (isNoMoreGame()) {
                break;
            }
        }
    }

    // 기능: 게임 순서에 맞게 게임을 진행한다
    private void progressGame() {
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(new RandomNumberGenerator());
        while (true) {
            GameResult gameResult = startGameRound(computerBalls);
            if (gameResult.isGameEnd()) {
                Output.printGameEndMessage();
                break;
            }
        }
    }

    private GameResult startGameRound(BaseballCollection computerBalls) {
        Output.printNumberInputMessage();
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball(input.readLine());
        GameResult gameResult = judgment.calculateHint(computerBalls, playerBalls);
        Output.printHint(gameResult.getHint());
        return gameResult;
    }

    // 기능: 게임 종료 후, 게임 재시작 여부
    private boolean isNoMoreGame() {
        Output.printRestartGameMessage();
        String restartCommand = input.readLine();
        validator.validateRestartCommandInput(restartCommand);
        return restartCommand.equals("2");
    }
}
