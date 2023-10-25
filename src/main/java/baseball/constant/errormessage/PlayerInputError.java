package baseball.constant.errormessage;

import baseball.constant.Constant;

public class PlayerInputError {
    public static final String PLAYER_NUMBER_WRONG_INPUT_NOT_INTEGER_MESSAGE = "[ERROR] 1~9 사이 숫자가 아닌 다른 문자가 입력에 포함되어 있습니다.";
    public static final String PLAYER_NUMBER_WRONG_INPUT_SIZE_MESSAGE =
            "[ERROR] 야구 번호는 " + Constant.GAME_NUMBERS_SIZE + "개만 입력 가능합니다.";
    public static final String PLAYER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE = "[ERROR] 야구 번호들은 중복될 수 업습니다.";
    public static final String PLAYER_NUMBER_WRONG_INPUT_RANGE_MESSAGE = "[ERROR] 입력한 문자열 중 1~9 사이의 수가 아닌 문자가 포함되어있습니다.";
    public static final String PLAYER_REGAME_WRONG_INPUT_NUMBER_MESSAGE = "[ERROR] 1 또는 2를 입력해야합니다.";
}
