package baseball;

import baseball.domain.BaseballCount;
import baseball.util.GameUtil;
import baseball.util.MessageUtil;
import java.util.List;

/**
 * 게임을 직접 컨트롤하는 메인 클래스
 */
public class BaseballGame {
    private List<Integer> computer;

    public BaseballGame() {
        MessageUtil.printStartMsg();
    }

    public void playGame() {
        computer = GameUtil.initRandomNumber();
        while (true) {
            BaseballCount count = playUnitGame();
            if (finishGame(count)) {
                break;
            }
        }
    }

    /**
     * 사용자가 입력한 후 부터 볼, 스트라이크 개수 출력까지를 단위게임이라 한다.
     */
    private BaseballCount playUnitGame() {
        List<Integer> userNum = GameUtil.inputNumber();
        BaseballCount count = GameUtil.compareBaseball(computer, userNum);
        MessageUtil.printBaseballCount(count);
        return count;
    }

    private boolean finishGame(BaseballCount count) {
        if (GameUtil.isUnitGameFinish(count)) {
            if (GameUtil.isGameRestart()) {
                restartGame();
                return false;
            }
            return true;
        }
        return false;
    }

    private void restartGame() {
        computer = GameUtil.initRandomNumber();
    }
}
