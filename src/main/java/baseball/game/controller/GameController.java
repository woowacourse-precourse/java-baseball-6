package baseball.game.controller;

import baseball.game.model.Game;
import baseball.game.view.GameView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private Game game;
    private GameView gameView;

    public boolean playingGame() {

        String userInput;
        game = new Game();
        gameView = new GameView();

        gameView.printGameStart();

        while (game.isGamePlaying()) {
            userInput = Console.readLine();
            getHint(userInput);
        }

        gameView.printGameEnd();
        userInput = Console.readLine();

        return game.restartGame(userInput);
    }

    private void getHint(String input) {

        game.validateInput(input);

        int strikeCount = game.countStrike(input);
        int ballCount = game.countBall(input);
        gameView.printHint(strikeCount, ballCount);

    }

}
