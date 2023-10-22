package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.startGame();
        } finally {
            Console.close();
        }
    }
}
