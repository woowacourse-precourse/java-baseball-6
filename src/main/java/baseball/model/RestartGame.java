package baseball.model;

import baseball.ConstantVO;
import camp.nextstep.edu.missionutils.Console;

public class RestartGame {

    public boolean isRestartGame() throws IllegalArgumentException {
        boolean isRestart = false;
        int answer = getAnswer();
        if (answer == ConstantVO.RESTART) {
            isRestart = true;
        } else if (answer == ConstantVO.GAME_OVER) {
            isRestart = false;
        }
        return isRestart;
    }

    private int getAnswer() throws IllegalArgumentException {
        int answer = Integer.parseInt(Console.readLine());

        if (answer == 0 || answer > ConstantVO.GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
