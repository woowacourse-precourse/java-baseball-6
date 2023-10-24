package baseball;

import baseball.constant.Status;
import baseball.constant.SystemMessage;
import baseball.util.NumberGenerator;

import java.util.List;

public class Game {

    private List<Integer> computerNumber;

    public void startGame() {
        GameController.gameStatus = Status.GAME;
        SystemMessage.NEW.printMessage(GameController.gameStatus);
        generateNumber();
        startGameSet();
    }

    private void startGameSet() {
        GameSet gameSet = new GameSet(computerNumber);
        while (GameController.gameStatus != Status.EXIT) {
            gameSet.startSet();
        }
    }


    private void generateNumber() {
        NumberGenerator generator = new NumberGenerator();
        computerNumber = generator.generate();
        System.out.println("Game.generateNumber : " + computerNumber);
    }

}
