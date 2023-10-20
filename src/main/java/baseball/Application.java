package baseball;

import baseball.component.GameCore;
import baseball.component.Initializer;
import baseball.component.Inputter;
import baseball.component.Validator;

public class Application {
    public static void main(String[] args) {
        GameCore gameCore = new GameCore(Initializer.getInitializer(),
                Inputter.getInputter(),
                new Validator());

        gameCore.game();
    }
}
