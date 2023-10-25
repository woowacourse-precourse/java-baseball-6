package baseball.constants;

import static baseball.constants.Game.QUIT;
import static baseball.constants.Game.START;

public class GameMessage {
    public static final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_PROMPT = "게임을 다시 시작하려면 " + START + "를 입력하세요. 종료하려면 " + QUIT + "를 입력하세요.";
}
