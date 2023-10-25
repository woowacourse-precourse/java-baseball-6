package baseball;

import baseball.controller.GameController;
import baseball.io.Output;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        GameController gc = new GameController();

        boolean runGame;

        Output.printGameBegin();

        do {
            List<Integer> opponent = gc.createOpponent();
            gc.guessTilSuccess(opponent);
            Output.printWinGame();
            runGame = gc.replay();
        } while (runGame);

        Output.printGameEnd();
    }
}

