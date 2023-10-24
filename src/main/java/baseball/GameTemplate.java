package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameTemplate {
    String restart = "1";

    GameTemplate() {
        while (restart.equals("1")) {
            Game game = new Game();
            askRestartGame();
        }
        if (restart.equals("2")) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void askRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        this.restart = Console.readLine();
    }
}
