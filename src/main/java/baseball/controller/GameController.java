package baseball.controller;

import baseball.io.Input;
import baseball.io.Output;
import baseball.model.Game;

import java.util.List;

public class GameController {
    private final Game game;
    private final Input input;
    private final Output output;

    public GameController(Game game, Input input, Output output) {
        this.game = game;
        this.input = input;
        this.output = output;
        output.printStartingMsg();
    }

    public void runGame() {
        while (game.isOngoing()) {
            String userInput = input.readLine();
            List<Integer> result = game.playRound(userInput);
            output.printResult(result);
            if (game.isWin(result)) {
                break;
            }
        }
        handleGameEnd();
    }

    private void handleGameEnd() {
        if (game.isOngoing()) {
            restart();
        }
    }

    public void restart() {
        game.reset();
        runGame();
    }
}
