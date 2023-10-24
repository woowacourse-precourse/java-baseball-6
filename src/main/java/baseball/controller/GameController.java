package baseball.controller;

import baseball.domain.Baseballs;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.domain.GameStatus.EXIT;
import static baseball.domain.GameStatus.RESTART;

public class GameController {

    private final InputController inputController;
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;

    public GameController(InputController inputController,
                          OutputView outputView,
                          InputView inputView,
                          GameService gameService) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.inputView = inputView;
        this.gameService = gameService;
    }

    public void intro() {
        outputView.printStartGameMessage();
    }

    public void run() {
        setGame();
        playGame();
        String restartChoice = requestRestartChoice();
        handleRestartChoice(restartChoice);
    }

    private void setGame() {
        gameService.setup();
    }

    private void playGame() {
        while (!gameService.isGameOver()) {
            String playerGuess = requestPlayerGuess();
            Baseballs playerBalls = gameService.setPlayerBaseballs(playerGuess);
            gameService.calculateStrikeAndBall(playerBalls);
            outputView.printResultMessage(gameService.generateGameResult());
            gameService.updateGameState();
        }
        outputView.printEndGameMessage();
    }

    private String requestPlayerGuess() {
        inputView.printPlayerGuessMessage();
        return inputController.requestPlayerGuess();
    }

    private String requestRestartChoice() {
        inputView.printRestartChoiceMessage();
        return inputController.requestRestartChoice();
    }

    private void handleRestartChoice(String restartChoice) {
        int value = Integer.parseInt(restartChoice);

        if (value == RESTART.getValue()) {
            run();
        } else if (value == EXIT.getValue()) {
            // 종료 처리를 수행
        } else {
            throw new IllegalArgumentException("입력 값은 1 또는 2 입니다. (1: 재 시작, 2: 종료)");
        }
    }
}
