package baseball;

import baseball.controller.baseballController;
public class Application {
    public static void main(String[] args) {
        baseballController baseballcontroller = new baseballController();
        baseballcontroller.run();
    }
}
