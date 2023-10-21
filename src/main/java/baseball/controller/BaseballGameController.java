package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
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
            Balls computer = createComputer();

            while (gameStatus.isNotClear()) {
                gameStatus = play(computer);
            }

            outputView.printGameEnd();
            GameCommand gameCommand = getGameCommand();
            gameStatus = GameStatus.from(gameCommand);
        }
    }

    private Balls createComputer() {
        List<Integer> generatedNumbers =
                NumberGenerator.generateUniqueNumbers(Ball.LOWER_LIMIT, Ball.UPPER_LIMIT, Balls.BALLS_SIZE);
        return new Balls(generatedNumbers);
    }

    private GameStatus play(Balls computer) {
        Balls player = createPlayer();
        int ballCount = computer.getBallCount(player);
        int strikeCount = computer.getStrikeCount(player);
        outputView.printBallAndStrike(ballCount, strikeCount);
        return GameStatus.from(strikeCount);
    }

    private Balls createPlayer() {
        int playerNumber = inputView.readPlayerNumber();
        List<Integer> numbers = Converter.convertIntToList(playerNumber);
        return new Balls(numbers);
    }

    private GameCommand getGameCommand() {
        int command = inputView.readGameCommand();
        return GameCommand.from(command);
    }
}
