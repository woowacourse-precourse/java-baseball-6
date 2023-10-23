package baseball;

import baseball.manager.BaseBallGameManager;
import baseball.manager.GameManager;
import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new BaseBallGameManager(new ConsoleInput(),
                new ConsoleOutput());
        gameManager.execute();
    }
}
