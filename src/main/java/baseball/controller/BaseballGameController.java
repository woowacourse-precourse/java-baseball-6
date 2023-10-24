package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Baseballs;
import baseball.domain.GameStatus;
import baseball.domain.GameCommand;
import baseball.utils.Converter;
import baseball.utils.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        GameStatus gameStatus = GameStatus.RUN;
        outputView.printGameStart();

        while (gameStatus.isNotEnd()) {
            Baseballs computer = createComputer();

            while (gameStatus.isNotClear()) {
                Baseballs player = createPlayer();
                gameStatus = play(computer, player);
            }
            outputView.printGameEnd();

            gameStatus = restartOrEnd();
        }
    }

    private Baseballs createComputer() {
        List<Integer> generatedNumbers =
                NumberGenerator.generateUniqueNumbers(Ball.LOWER_LIMIT, Ball.UPPER_LIMIT, Ball.MAX_POSITION);
        return new Baseballs(generatedNumbers);
    }

    private Baseballs createPlayer() {
        int playerNumber = inputView.readPlayerNumber();
        List<Integer> numbers = Converter.convertIntToList(playerNumber);
        return new Baseballs(numbers);
    }

    private GameStatus play(Baseballs computer, Baseballs player) {
        int ballCount = computer.getBallCount(player);
        int strikeCount = computer.getStrikeCount(player);
        outputView.printBallAndStrike(ballCount, strikeCount);
        return GameStatus.from(strikeCount);
    }

    private GameStatus restartOrEnd() {
        int command = inputView.readGameCommand();
        GameCommand gameCommand = GameCommand.from(command);
        return GameStatus.from(gameCommand);
    }
}
