package baseball.domain;

import baseball.constant.Status;
import baseball.constant.SystemMessage;
import baseball.controller.GameController;
import baseball.util.NumberGenerator;
import java.util.List;

public class Game {

    private List<Integer> computerNumber;

    public void startGame() {
        GameController.gameStatus = Status.GAME;
        SystemMessage.NEW.printMessage(Status.SET);
        generateNumber();
        startGameSet();
    }

    private void startGameSet() {
        GameSet gameSet = new GameSet(computerNumber);
        while (GameController.gameStatus == Status.SET) {
            gameSet.startSet();
        }
    }


    private void generateNumber() {
        NumberGenerator generator = new NumberGenerator();
        computerNumber = generator.generate();
    }

}
