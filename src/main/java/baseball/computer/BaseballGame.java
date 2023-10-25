package baseball.computer;

import baseball.computer.GameManager;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.enums.NumberInfo.*;
import static baseball.enums.Message.*;

public class BaseballGame {
    private final GameManager numberManager;

    public BaseballGame(GameManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        System.out.println(START_GAME_MESSAGE);

        while (true) {
            playGame();

            if (askRestartGame()) {
                continue;
            }

            break;
        }
    }

    private void playGame() {
        List<Integer> Numberlist = numberManager.createNumber();
        numberManager.countCalculate(Numberlist);
    }

    private boolean askRestartGame() {
        System.out.println(RESTART_QUESTION_MESSAGE.getMessage());
        String cmd = Console.readLine();
        int restart = Integer.parseInt(cmd);

        if (restart == RESTART_TRUE.getNumberInfo()) {
            return true;
        } else if (restart == RESTART_FALSE.getNumberInfo()) {
            return false;
        }

        throw new IllegalArgumentException("[Error]: 재시작을 원하시면 1, 종료를 원하시면 2를 입력하세요.");
    }
}