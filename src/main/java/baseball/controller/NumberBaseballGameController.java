package baseball.controller;

import baseball.model.Game;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class NumberBaseballGameController implements GameController {
    private static final String quitGame = "2";
    private static final String continueGame = "1";
    private final GameView gameView;
    private boolean playGame = true;
    private final Supplier<Game> gameSupplier;
    private Game game;

    public NumberBaseballGameController(Supplier<Game> gameSupplier, GameView view) {
        this.gameSupplier = gameSupplier;
        this.gameView = view;
    }

    public void play() {
        while (playGame) {
            game = gameSupplier.get();
            loopMatchingNumber();
            checkResume();
        }
    }

    public void loopMatchingNumber() {
        do {
            gameView.showInputRequiredMessage();
            game.play(Console.readLine());
            gameView.showResultOf(game);
        } while (game.continues());
    }


    public void checkResume() {
        gameView.showToBeContinueMessage();
        String input = Console.readLine();

        if (input.equals(quitGame)) {
            quitGame();
        } else if (!input.equals(continueGame)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void quitGame() {
        gameView.showQuitGameMessage();
        playGame = false;
    }
}
