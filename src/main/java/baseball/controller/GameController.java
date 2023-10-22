package baseball.controller;

import static baseball.model.Status.REPLAY;
import static baseball.model.Status.STOP;
import static baseball.util.GameHelper.numberToIntegerList;

import baseball.model.Game;
import baseball.model.GameNumbers;
import baseball.model.Status;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private Game game;

    public void run() {
        game = new Game();
        do {
            OutputView.printInputGuideMessage();
            String inputNumber = InputView.inputPositiveNumber();
            playGame(inputNumber);
            OutputView.printResult(game.getResult());
        } while (game.isRunning());
        OutputView.printDoneMessage();
    }

    public void playGame(String number) {
        List<Integer> userNumbers = numberToIntegerList(number);
        game.updateUserNumbers(new GameNumbers(userNumbers));
        game.resetResult();
        game.play();
    }

    public Status replayOrStop() {
        String status = InputView.inputPositiveNumber();
        int statusIntValue = Integer.parseInt(status);
        if (Status.from(statusIntValue) == STOP) {
            return STOP;
        }
        return REPLAY;
    }
}
