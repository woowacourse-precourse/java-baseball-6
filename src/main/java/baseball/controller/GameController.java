package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.ComputerNumberGenerator;
import baseball.domain.GameStatus;
import baseball.domain.Player;
import baseball.domain.dto.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final ComputerNumberGenerator randomComputerNumberGenerator;

    public GameController(OutputView outputView, InputView inputView,
                          ComputerNumberGenerator randomComputerNumberGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomComputerNumberGenerator = randomComputerNumberGenerator;
    }

    public void start() {
        do {
            Computer computer = generateRandomComputerNumbers();
            playGame(computer);
        } while (playAgain() == GameStatus.RESTART);
    }

    private Computer generateRandomComputerNumbers() {
        outputView.printGameStartMessage();
        return randomComputerNumberGenerator.create();
    }

    private void playGame(Computer computer) {
        while (true) {
            Player player = createPlayerWithInput();
            GameResult gameResult = computer.calculateAndReturnGameResult(player);
            outputView.printGameResult(gameResult);

            if (gameResult.isThreeStrikes()) {
                break;
            }
        }
    }

    private Player createPlayerWithInput() {
        List<Integer> playerInput = inputView.inputOtherThreeNumbers();
        return Player.of(playerInput);
    }

    private GameStatus playAgain() {
        return inputView.inputGameStatus();
    }
}