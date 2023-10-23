package baseball;

import baseball.game.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        while (gameController.playingGame()) {
        }
        Console.close();
    }
}
