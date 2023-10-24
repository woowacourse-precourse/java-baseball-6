package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        boolean restart;
        BaseballGameController baseballGameController = new BaseballGameController();
        BaseballGameView baseballGameView = new BaseballGameView();

        baseballGameView.startView(); // 첫 시작에만 나오기 때문에 컨트롤러 밖에서 한 번 호출
        restart = baseballGameController.startGame(); // 컨트롤러를 통해서 게임 시작

        while (restart) { // 게임 종료 후 반환 값을 받아서 재시작인지 아닌지 판단
            restart = baseballGameController.startGame();
        }

    }

}
