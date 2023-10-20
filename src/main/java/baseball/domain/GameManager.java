package baseball.domain;

import baseball.utils.BaseballGameNoticeUtil;
import camp.nextstep.edu.missionutils.Console;

import static baseball.utils.BaseballGameNoticeUtil.noticeStartGame;

public class GameManager {

    private BaseBall baseBall;

    public GameManager(BaseBall baseBall) {
        this.baseBall = baseBall;
    }

    public void game() {
        noticeStartGame();
        baseBall.baseBallRun();

        while(true) {
            BaseballGameNoticeUtil.noticeAgainOrExit();
            String againOrExit = againOrExit();

            if (againOrExit.equals("2")) break;
            baseBall.baseBallRun();
        }

    }

    /* 재시작 또는 종료 값 입력 */
    public String againOrExit() {
        return Console.readLine();
    }
}
