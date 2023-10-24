package baseball.controller;

import baseball.domain.dto.GameResult;
import baseball.domain.game.Computer;
import baseball.domain.game.ComputerNumberGenerator;
import baseball.domain.game.GameStatus;
import baseball.domain.game.Player;
import baseball.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputController inputController;
    private final ComputerNumberGenerator randomComputerNumberGenerator;

    public GameController(OutputView outputView, InputController inputController,
                          ComputerNumberGenerator randomComputerNumberGenerator) {
        this.outputView = outputView;
        this.inputController = inputController;
        this.randomComputerNumberGenerator = randomComputerNumberGenerator;
    }

    public void start() {
        do {
            Computer computer = generateRandomComputerNumbers();
            playGame(computer);
        } while (inputController.convertToGameStatus() == GameStatus.RESTART);
    }

    private Computer generateRandomComputerNumbers() {
        outputView.printGameStartMessage();
        return randomComputerNumberGenerator.create();
    }

    private void playGame(Computer computer) {
        while (true) {
            Player player = inputController.convertToPlayer();
            GameResult gameResult = computer.evaluateWith(player);
            outputView.printGameResult(gameResult);

            if (gameResult.isThreeStrikes()) {
                break;
            }
        }
    }

}