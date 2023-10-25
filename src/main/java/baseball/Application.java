package baseball;

import baseball.controller.BaseBallController;

public class Application {
    private static String startMessage = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(startMessage);
        BaseBallController controller = BaseBallController.getInstance();
        controller.run();
    }
}
