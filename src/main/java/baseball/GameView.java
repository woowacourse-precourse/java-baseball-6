package baseball;


import static baseball.GameController.LOGGERNAME;

import java.util.logging.Logger;

public class GameView {

    Logger log = Logger.getLogger(LOGGERNAME);

    private static GameView gameView;

    private GameView() {
    }

    public static GameView getInstance() {
        if (gameView == null) {
            gameView = new GameView();
        }
        return gameView;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public Integer selectMenu() {
        // TODO: 게임 종료 후 안내 메세지 출력 및 input validation
        return 1;
    }

}
