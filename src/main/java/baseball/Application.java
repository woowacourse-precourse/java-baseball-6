package baseball;

import baseball.controller.Baseball;
import baseball.domain.RestartNumber;
import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleView.gameStartView();
        while (true) {
            Baseball baseball = new Baseball();
            baseball.gameStart();
            RestartNumber restartNumber = new RestartNumber(ConsoleView.reGame());
            if (restartNumber.getRestartNumber() == 2) {
                break;
            }
        }
    }
}
