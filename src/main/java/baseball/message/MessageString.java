package baseball.message;

import baseball.Constant;

public class MessageString {

    private MessageString() {
    }

    public static final String GAME_LEN_ERROR_STRING = "%d개의 숫자를 입력하세요!".formatted(
        Constant.NUMBER_LENGTH);
    public static final String WRONG_GAME_INPUT_ERROR_STRING = "입력은 %d~%d 사이의 각각 다른 숫자 %d개 입니다!".formatted(
        Constant.NUMBER_MIN, Constant.NUMBER_MAX, Constant.NUMBER_LENGTH);
    public static final String WRONG_RERUN_INPUT_ERROR_STRING = "입력은 %d 아니면 %d입니다!".formatted(
        Constant.RESTART_RESTART, Constant.RESTART_END);

    public static final String END_MSG = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료".formatted(
        Constant.NUMBER_LENGTH);
    public static final String RESTART_MSG = "게임을 새로 시작하려면 %d, 종료하려면 %s를 입력하세요.".formatted(
        Constant.RESTART_RESTART, Constant.RESTART_END);


    public static final String INIT_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String PROMT_MSG = "숫자를 입력해주세요 : ";
    public static final String NOTHING_MSG = "낫싱";
    public static final String STRIKE_MSG = "스트라이크";
    public static final String BALL_MSG = "볼";
    public static final String NEW_LINE = "\n";

}
