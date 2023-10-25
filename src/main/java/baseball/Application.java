package baseball;

import baseball.manager.BaseBallGameManager;
import baseball.manager.GameManager;
import baseball.manager.RandomNumberGenerator;
import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;
import baseball.ui.UIFacade;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new BaseBallGameManager(new UIFacade(new ConsoleInput(),
                new ConsoleOutput()),new RandomNumberGenerator());
        gameManager.execute();
    }
}
