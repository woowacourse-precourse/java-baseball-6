package baseball;

import baseball.controller.NumberBaseballGameController;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        numberBaseballGameController.run();
    }
}