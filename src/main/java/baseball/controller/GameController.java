package baseball.controller;

import static baseball.util.GameHelper.changeNumberToIntegerList;

import baseball.model.Game;
import baseball.model.Status;
import baseball.view.GameView;
import java.util.List;

public class GameController {

    private Game game;

    public void run() {
        game = new Game();
        do {
            String inputNumber = GameView.inputPositiveNumber();
            playGame(inputNumber);
            GameView.printResult(game.getResult());
        } while (game.isRunning());
    }

    public void playGame(String number) {
        List<Integer> userNumbers = changeNumberToIntegerList(number);
        game.setUserNumbers(userNumbers);
        game.setResult();
        game.play();
    }

    public Status replayOrStop() {
        GameView.printReplayMessage();
        String inputStatus = GameView.inputPositiveNumber();
        return Status.from(inputStatus);
    }
}
