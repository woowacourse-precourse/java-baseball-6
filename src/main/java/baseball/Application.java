package baseball;

import baseball.game.Game;
import baseball.message.Printer;

public class Application {

    public static void main(String[] args) {
        while (true) {
            Printer.start();

            if (!Game.play()) {
                break;
            }
        }
    }
}
