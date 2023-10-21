package baseball.message;

import baseball.gameutil.Constant;

public class ErrorMessage {
    public static final String GAME_LEN_ERROR_STRING = "%d개의 숫자를 입력하세요!".formatted(Constant.NUMBER_LENGTH);
    public static final String WRONG_GAME_INPUT_ERROR_STRING = "입력은 %d~%d사이의 숫자 %d개 입니다!".formatted(Constant.NUMBER_MIN, Constant.NUMBER_MAX, Constant.NUMBER_LENGTH);
    public static final String WRONG_RERUN_INPUT_ERROR_STRING = "입력은 %d 아니면 %d입니다!".formatted(Constant.RESTART_MIN, Constant.RESTART_MAX);
}
