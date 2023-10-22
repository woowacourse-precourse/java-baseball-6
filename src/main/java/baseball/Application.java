package baseball;


import baseball.controller.BaseballGameController;
import baseball.view.BaseballGameView;

public class Application {

    private static final int RESTART = 1;

    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(); // 게임 컨트롤러 생성
        BaseballGameView baseballGameView = new BaseballGameView();

        baseballGameView.startView();
        int exitCode = baseballGameController.startGame(); // 컨트롤러를 통해서 게임 시작

        while (exitCode == RESTART) { // 게임 종료 후 반환 값을 받아서 재시작인지 아닌지 판단
            exitCode = baseballGameController.startGame(); // 재시작
        }

    }
}
