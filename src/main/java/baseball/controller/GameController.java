package baseball.controller;

import static baseball.util.GameHelper.numberToIntegerList;

import baseball.model.Game;
import baseball.model.GameNumbers;
import baseball.model.Result;
import baseball.view.InputView;
import java.util.List;

public class GameController {

    private final Game game = new Game();

    public void run() {
        String inputNumber = InputView.inputPositiveNumber();
        playGame(inputNumber);
    }

    public void playGame(String number) {
        List<Integer> userNumbers = numberToIntegerList(number);
        game.updateUserNumbers(new GameNumbers(userNumbers));
        game.resetResult();
        game.play();
    }

    public Result getResult() {
        return game.getResult();
    }
}
