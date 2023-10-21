package baseball.domain;

import baseball.utils.BaseballGameNoticeUtil;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void game() {
        BaseballGameNoticeUtil.noticeStartGame();
        game.gameRun();

        while (true) {
            BaseballGameNoticeUtil.noticeAgainOrExit();

            if (requireAgainOrExit().equals("2")) {
                break;
            }
            game.gameRun();
        }
    }

    /* 재시작 또는 종료 값 입력 */
    public String requireAgainOrExit() {
        return Console.readLine();
    }
}
