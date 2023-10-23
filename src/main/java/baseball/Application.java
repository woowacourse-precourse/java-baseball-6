package baseball;

import controller.BaseballController;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.gameStart();
    }
}
