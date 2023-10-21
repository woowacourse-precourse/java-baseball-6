package baseball.console;

import baseball.console.game.GameList;
import baseball.console.game.numberbaseball.NumberBaseballGame;
import baseball.console.util.Status;
import camp.nextstep.edu.missionutils.Console;

public class GameConsole {
    NumberBaseballGame numberBaseballGame;
    Status status;
    GameList target;

    public GameConsole() {
        init();
    }

    private void init() {
        target = GameList.NUMBER_BASEBALL;
        status = Status.CONTINUE;
    }

    public void start() {
        while (status == Status.CONTINUE) {
            if (target == GameList.NUMBER_BASEBALL) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                launchNumberBaseball();
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            status = Status.values()[choice];
        }

    }

    private void launchNumberBaseball() {
        numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.start();
    }
}
