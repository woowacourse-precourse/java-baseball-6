package baseball;

import baseball.controller.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // Create BaseballGame Instance
        BaseballGame game = new BaseballGame();
        // 게임 실행
        game.run();
        // computing scanner resource return
        Console.close();
    }
}
