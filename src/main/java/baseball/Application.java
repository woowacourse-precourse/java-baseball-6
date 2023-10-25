package baseball;

import baseball.game.Control;
import baseball.view.GameMessage;

public class Application {
    public static void main(String[] args) {
        Control control = new Control();
        control.run();
    }
}
