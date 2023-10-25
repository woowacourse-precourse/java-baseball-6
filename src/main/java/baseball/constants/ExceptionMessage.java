package baseball.constants;

import static baseball.constants.Game.ANSWER_DIGIT;
import static baseball.constants.Game.END_INCLUSIVE;
import static baseball.constants.Game.QUIT;
import static baseball.constants.Game.START;
import static baseball.constants.Game.START_INCLUSIVE;

public class ExceptionMessage {
    public static final String GAME_STATUS_EXCEPTION =
            "유효하지 않은 입력값입니다. 게임을 다시 시작하려면 " + START + ", 종료하려면 " + QUIT + "를 입력하세요.";

    public static final String GUESS_LENGTH_EXCEPTION = "입력값의 자릿수가 올바르지 않습니다. " + ANSWER_DIGIT + "자리의 숫자를 입력하세요.";

    public static final String GUESS_FORMAT_EXCEPTION =
            "입력값의 형식이 올바르지 않습니다. " + START_INCLUSIVE + "에서 " + END_INCLUSIVE + "사이의 숫자를 입력하세요.";

    public static final String GUESS_NO_DUPLICATE_EXCEPTION =
            "입력값에 중복된 숫자가 포함되어 있습니다. 서로 다른 숫자를 입력하세요.";
}
