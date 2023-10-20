package baseball;

import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean start = true;

        // 게임 시작
        while(start) {
            GameView.gameStart();
            start = false;
        }
    }
}
