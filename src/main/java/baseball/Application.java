package baseball;

import baseball.controller.PlayerController;
import baseball.logic.BaseBallGame;
import baseball.logic.Game;
import baseball.model.Computer;
import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new BaseBallGame(new ConsoleView(), new PlayerController(new Computer()), 3);
        game.start();
    }
}


