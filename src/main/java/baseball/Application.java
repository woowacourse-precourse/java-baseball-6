package baseball;

import baseball.controller.MainController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.getInstance();
        mainController.run();
        Console.close();
    }
}
