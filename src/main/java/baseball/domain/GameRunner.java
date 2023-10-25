package baseball.domain;

import baseball.view.OutPutView;

public class GameRunner {

    public static void runGame() {
        OutPutView.gameStartInfo(Game.GAME_NAME);
        boolean playGame = true;
        while (playGame) {
            Game game = Game.startGame();
            game.showResult();
            playGame = game.askRestart();
        }
    }
}
