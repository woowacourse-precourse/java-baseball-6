package baseball;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.run();
        Console.close();
    }
}
