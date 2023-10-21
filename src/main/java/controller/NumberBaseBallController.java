package controller;

import model.system.GameController;
import view.InputView;
import view.OutputView;

public class NumberBaseBallController {

    public static final String QUIT_GAME = "2";

    public NumberBaseBallController() {
    }

    public void run() {
        OutputView.write("숫자 야구 게임을 시작합니다.");
        while (true) {
            GameController gameController = new GameController();
            gameController.run();
            OutputView.write("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            OutputView.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = InputView.readInput();
            if (input.equals(QUIT_GAME)) {
                return;
            }
        }
    }
}
