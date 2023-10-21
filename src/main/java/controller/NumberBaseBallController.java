package controller;

import model.system.GameController;
import view.InputView;
import view.OutputView;

public class NumberBaseBallController {

    public static final String QUIT_GAME = "2";

    public NumberBaseBallController() {
    }

    public void run() {
        while (true) {
            GameController gameController = new GameController();
            gameController.run();
            OutputView.Write("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            OutputView.Write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = InputView.ReadInput();
            if (input.equals(QUIT_GAME)) {
                return;
            }
        }
    }
}
