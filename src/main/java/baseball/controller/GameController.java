package baseball.controller;

import static baseball.util.GameHelper.changeNumberToIntegerList;

import baseball.model.Game;
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
        List<Integer> userNumbers = changeNumberToIntegerList(number);
        game.setUserNumbers(userNumbers);
        game.setResult();
        game.play();
    }

    public Status replayOrStop() {
        String inputStatus = InputView.inputPositiveNumber();
        return Status.from(inputStatus);
    }
}
