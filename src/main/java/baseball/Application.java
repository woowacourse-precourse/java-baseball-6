package baseball;

import baseball.Controller.Controller;
import baseball.view.Log;

public class Application {

    private static final Controller controller = new Controller();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Log.info("숫자 야구 게임을 시작합니다.");

        boolean start = true;
        while (start) {
            start = controller.run();
        }
    }
}
