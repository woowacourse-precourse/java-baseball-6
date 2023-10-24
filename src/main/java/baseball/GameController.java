package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameController {

    //private List<Integer> computer;
    private String input;
    private boolean isStarted;
    private final GameView gameView;
    private final GameModel gameModel;
    public GameController() {

        this.gameView= new GameView();
        this.gameModel = new GameModel();
        gameView.printMessage(GameModel.START_MESSAGE);
    }
    public void run() {
        isStarted = true;

        do {
            gameModel.generateComputerNumber();
            play();
        } while (isStarted);

        gameView.printMessage(GameModel.END_MESSAGE);
    }

    public void play() {
        gameView.printMessage(GameModel.ASK_NUMBERS);
        input = Console.readLine();
        checkResult(input);
    }

    public void isStarted(String input) {
        if (input.equals("1")) {
            isStarted = true;
            return;
        } else if (input.equals("2")) {
            isStarted = false;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void checkResult(String input) {
        List<Integer> result = gameModel.checkAnswer(input);

        int strike = result.get(0);
        int ball = result.get(1);
        gameView.displayResult(strike, ball);
        checkRestart(strike);

    }

    private void checkRestart(int strike) {

        if (strike == 3) {
            endGame();
        } else {
            continueGame();
        }
    }

    private void endGame() {
        isStarted = false;
        gameView.printMessage(GameModel.ASK_RESTART);
        input = Console.readLine();
        isStarted(input);
    }

    private void continueGame() {
        gameView.printMessage(GameModel.ASK_NUMBERS);
        input = Console.readLine();
        checkResult(input);
    }
}

