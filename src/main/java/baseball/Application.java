package baseball;

import baseball.computer.BaseballGame;
import baseball.computer.GameManager;
import baseball.computer.RandomRuleManager;
import baseball.player.UserInputNumberManager;
import baseball.player.UserNumberManager;

public class Application {
    public static void main(String[] args) {
        UserNumberManager userNumberManager = new UserInputNumberManager();
        GameManager numberManager = new RandomRuleManager(userNumberManager);

        BaseballGame game = new BaseballGame(numberManager);
        game.run();
    }
}
