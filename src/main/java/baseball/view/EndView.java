package baseball.view;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class EndView {
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.";
    GameController gameController = new GameController();

    public void printEndGame() {
        System.out.println(END_GAME_MESSAGE);
    }

    public void reStart() {
        printReStart();
        gameController.restart(Console.readLine());
    }
    public void printReStart() {
        System.out.println(RESTART_GAME_MESSAGE);
    }
}
