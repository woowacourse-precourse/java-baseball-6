package baseball;

import baseball.controller.BaseballGame;
import baseball.view.MessageView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //게임 시작메세지
        MessageView.start_M();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startGame();
    }
}
