package baseball.consts;

import static baseball.consts.NumberConst.RESTART_NUMBER;
import static baseball.consts.NumberConst.END_NUMBER;
import static baseball.consts.NumberConst.BASEBALL_SIZE;

public class MessagesConst {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String GAME_END_MESSAGE = BASEBALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String INPUT_USER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String INPUT_RESTART_NUMBER = "게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + END_NUMBER + "를 입력하세요.";
}
