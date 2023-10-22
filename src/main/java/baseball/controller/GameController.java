package baseball.controller;

import static baseball.util.GameHelper.numberToIntegerList;

import baseball.model.Game;
import baseball.model.GameNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final Game game = new Game();

    public void run() {
        do {
            OutputView.printInputGuideMessage();
            String inputNumber = InputView.inputPositiveNumber();
            playGame(inputNumber);
            OutputView.printResult(game.getResult());
        } while (game.isRunning());
    }

    public void playGame(String number) {
        List<Integer> userNumbers = numberToIntegerList(number);
        game.updateUserNumbers(new GameNumbers(userNumbers));
        game.resetResult();
        game.play();
    }
}
