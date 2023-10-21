package baseball.console;

import baseball.console.game.NumberBaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class GameConsole {
    NumberBaseballGame numberBaseballGame;
    enum Mode {CONTINUE, EXIT}
    Mode mode;

    public GameConsole() {
        init();
    }

    private void init() {
        numberBaseballGame = new NumberBaseballGame();
        mode = Mode.CONTINUE;
    }

    public void start() {
        while (mode == Mode.CONTINUE) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            numberBaseballGame.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            mode = Mode.values()[choice-1];
        }



    }
}
