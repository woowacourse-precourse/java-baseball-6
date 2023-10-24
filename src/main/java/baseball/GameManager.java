package baseball;

import java.io.IOException;

public class GameManager {
    public void start() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameFunction.gametry();
    }
}
