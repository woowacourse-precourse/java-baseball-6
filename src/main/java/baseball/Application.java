package baseball;

import baseball.game.Game;
import baseball.game.GameLogic;
import baseball.game.GameUI;
import baseball.user.User;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameUI gameUI = new GameUI();
        GameLogic gameLogic = new GameLogic();
        Computer computer = new Computer();

        User user = new User();
        Game game = new Game(gameUI, gameLogic, computer, user);

        game.startGame();
    }
}