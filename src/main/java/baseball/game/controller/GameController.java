package baseball.game.controller;

import baseball.game.model.Game;
import baseball.game.view.GameView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {


    public boolean startGame() {

        Game game = new Game();
        GameView gameView = new GameView();

        gameView.printGameStart();

        while (true) {
            String input = Console.readLine();
            game.validateInput(input);

            int strikeCount = game.countStrike(input);
            int ballCount = game.countBall(input);
            gameView.printHint(strikeCount, ballCount);

            if (game.isEndGame(strikeCount)) {
                gameView.printGameEnd();
                input = Console.readLine();
                return game.restartGame(input);
            }
        }


    }



}
