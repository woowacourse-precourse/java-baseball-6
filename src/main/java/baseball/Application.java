package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BaseballReferee;
import baseball.domain.RandomNumberFactory;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new RandomNumberFactory(),
                new BaseballReferee());
        baseballController.run();
    }
}
