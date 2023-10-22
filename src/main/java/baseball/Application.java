package baseball;

import baseball.common.controller.CommonController;

import java.util.concurrent.TimeoutException;

public class Application {
    public static void main(String[] args) throws TimeoutException {
        // TODO: 프로그램 구현

        CommonController commonController = new CommonController();
        commonController.baseball();
    }
}
