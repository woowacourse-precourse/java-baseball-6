package baseball;

import baseball.baseballV2.system.BaseBallApplication;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        new GameController();
        BaseBallApplication baseBallApplication = new BaseBallApplication();
        baseBallApplication.run();
    }
}
