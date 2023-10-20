package baseball.controller;

import static baseball.utils.Constants.NUMBER_OF_BALLS;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.Hint;
import baseball.domain.RandomBallsGenerator;
import baseball.service.Service;
import baseball.view.Command;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Service service = new Service(new Game(new RandomBallsGenerator()));

    public void execute() {
        start();
        play();
    }

    private void start() {
        outputView.printGameStart();
        service.startGame();
    }

    private void play() {
        while (true) {
            Balls balls = insertNumberAndMakeBalls();
            String hint = service.hint(balls);
            outputView.printHint(hint);

            if (isAllStrike(hint)) {
                endProcess();
                break;
            }
        }
    }

    private void endProcess() {
        service.endGame();
        outputView.printInsertCommand();
        Command command = inputView.insertCommand();
        actByCommand(command);
    }

    private void actByCommand(Command command) {
        if (command == Command.RESTART) {
            service.restartGame();
            play();
            return;
        }

        outputView.printGameOver();
    }

    private Balls insertNumberAndMakeBalls() {
        outputView.printInsertNumbers();
        List<Integer> input = inputView.insertNumbers();
        return Balls.from(input);
    }

    private static boolean isAllStrike(String hint) {
        return String.format("%d%s", NUMBER_OF_BALLS, Hint.STRIKE.value()).equals(hint);
    }
}
