package baseball.constant;

import static baseball.constant.Command.*;
import static baseball.constant.Rule.*;

public enum Message {

    NOTHING("낫싱"),
    BALL("볼 "),
    STRIKE("스트라이크"),
    GAME_START("숫자 야구 게임을 시작합니다."),
    NEED_USER_INPUT("숫자를 입력해주세요 : "),
    GAME_END("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_RETRY_GAME("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }

    public String getGameEndMessage() {
        return String.format(value, SIZE.getValue());
    }

    public String getAskRetryMessage() {
        return String.format(value, RETRY_GAME.getCommand(), END_GAME.getCommand());
    }

}
