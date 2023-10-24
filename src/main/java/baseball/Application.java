package baseball;

import baseball.controller.GameFlowController;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args){
        // TODO: 프로그램 구현
        GameFlowController gameFlowController = new GameFlowController();
        OutputView outputView = new OutputView();
        outputView.displayMessage("숫자 야구 게임을 시작합니다.");
        gameFlowController.startGame();`
    }
}
