package baseball;

import game.BaseballGameClass;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: baseball game class를 service로 바꾸기.
        // test code
        // Game Start
        System.out.println("숫자 야구 게임을 시작합니다.");

        BaseballGameClass baseballGameClass = new BaseballGameClass();
        baseballGameClass.gameInit();
        baseballGameClass.gamePlay();

    }
}
