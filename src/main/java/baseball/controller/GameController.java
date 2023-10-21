package baseball.controller;

import baseball.model.Number;
import baseball.model.RandomNumberGenerator;
import baseball.view.GameView;
import java.util.List;

public class GameController {
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameView gameView;
    private Number number;

    public GameController() {
        randomNumberGenerator = new RandomNumberGenerator();
        gameView = new GameView();
    }

    public void start() {
        while (!isEnd()) {
            startGame();
            playGame();
            endGame();
        }
    }


    public void startGame() {
        gameView.printStartMessage();
        List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumber();
        number = new Number(randomNumbers);
    }

    public void playGame() {
        //do{
        gameView.printAskInputMessage();

        //}while();

    }

    public void endGame() {
        gameView.printSuccessAndEndMessage();

    }

    private boolean isEnd() {
        return true;
    }


}
