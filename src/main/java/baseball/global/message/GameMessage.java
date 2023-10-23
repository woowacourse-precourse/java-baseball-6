package baseball.global.message;

import baseball.global.constant.GameCode;
import baseball.global.constant.RuleValue;

public enum GameMessage {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    REQUEST_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다"),
    GAME_WIN_MESSAGE(RuleValue.BASEBALL_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_NOT_MESSAGE("게임을 새로 시작하려면 " +
            GameCode.RESTART_CODE +" 종료하려면 " +
            GameCode.QUIT_CODE + "를 입력하세요.");
    private final String message;
    GameMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
