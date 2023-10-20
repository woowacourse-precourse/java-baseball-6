package baseball;

import java.util.List;

import static baseball.GameManager.getInstance;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            getInstance().startGame();
            break;
        }
    }
}
