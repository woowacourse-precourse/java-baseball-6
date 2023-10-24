package baseball.constant;

/**
 * 메시지 불변 클래스
 */
public final class Message {
    public final static String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT_MSG = "숫자를 입력해주세요 : ";
    public final static String BALL_MSG = "볼";
    public final static String STRIKE_MSG = "스트라이크";
    public final static String NOTHING_MSG = "낫싱";
    public final static String GAME_FINISH_MSG = Number.GAME_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String GAME_RESTART_MSG = "게임을 새로 시작하려면 " + Number.RESTART_NUM +
            ", 종료하려면 " + Number.FINISH_NUM + "를 입력하세요.";
    public final static String INPUT_LENGTH_EXCEPTION_MSG = "입력의 길이가 올바르지 않습니다.";
    public final static String INPUT_DOMAIN_EXCEPTION_MSG = "허용되지 않는 문자를 입력했습니다.";
    public final static String INPUT_DUPLICATED_EXCEPTION_MSG = "입력에 중복된 숫자가 존재합니다.";
}
