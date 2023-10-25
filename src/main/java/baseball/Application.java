package baseball;

import baseball.controller.Controller;
import baseball.model.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new RandomNumberGenerator());
        controller.run();
    }
}
