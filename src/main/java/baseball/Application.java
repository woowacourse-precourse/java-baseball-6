package baseball;

import baseball.controller.BaseBall;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {

        BaseBall baseBall = new BaseBall();
        //while 구문 있던 부분 수정
        baseBall.playBall();
    }
}
