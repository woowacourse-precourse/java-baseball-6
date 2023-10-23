package baseball;

import baseball.View.Cli;
import baseball.View.View;
import baseball.game.BaseballGame;
import baseball.game.Game;
import baseball.player.Computer;
import baseball.player.User;

public class Application {
    public static void main(String[] args) {
        boolean isplay;
        View view = new Cli();
        Game baseballGame = new BaseballGame(view);

        do {
            isplay = runGame(baseballGame);
        } while (isplay);
    }
    private static boolean runGame(Game baseballGame) {
            boolean isEnd;
            baseballGame.startGame(new Computer(), new User());

            do {
                isEnd = baseballGame.playTurn();
            }
            while (!isEnd);

            return baseballGame.isRestart();
    }
}
