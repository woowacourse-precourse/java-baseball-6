package baseball;

import baseball.game.Game;
import baseball.game.Message;
import baseball.io.InputHandler;
import baseball.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Game(new InputHandler(), new OutputHandler(), new Message()).run();
    }
}
