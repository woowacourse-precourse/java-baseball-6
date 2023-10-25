package baseball;

import baseball.game.BaseballGame;
import baseball.game.impl.BaseballGameImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGameImpl(3);
        game.init();
        while (!game.isOver()) {
            game.display();
            String userInput = Console.readLine();
            game.validateInput(userInput);
            game.action(userInput);
        }
    }
}
