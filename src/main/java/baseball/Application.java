package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.logging.Logger;


public class Application {

    private static final String RESTART_GAME = "1";
    private static final String CLOSE_GAME = "2";
    public static final Logger LOG = Logger.getGlobal();

    //변수명은 리펙토링(관점의 차이) 남이 내 코드를 알 수 있는가? 1이 뭐고 2가 뭔데?


    public static void main(String[] args) {
        Baseball.playBaseball();
        LOG.info("숫자 야구 게임을 시작합니다.");
        String replayChoose = "1";
        while (RESTART_GAME.equals(replayChoose)) {
            Baseball.playBaseball();
            LOG.info("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replayChoose = Console.readLine();
            if (replayChoose.equals(RESTART_GAME)) {
                continue;
            }
            if (replayChoose.equals(CLOSE_GAME)) {
                return;
            }
        }
    }
}
