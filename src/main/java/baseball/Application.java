package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 목표 : 메인 함수 안에는 구체적인 로직 넣지 않기!!
        GameController controller = new GameController();
        controller.startGame();
    }
}
