package baseball;

import baseball.Controller.GameController;
import baseball.View.GameView;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            GameController gameController = new GameController(); // 컨트롤러 생성하면서 컴퓨터 숫자 자동 생성
            gameController.GameStart();

            String gameAgainNum = GameView.gameEnd();
            if(gameAgainNum.equals("2")) { // 2번 입력 시 게임 종료
                break;
            }
        }
    }
}
