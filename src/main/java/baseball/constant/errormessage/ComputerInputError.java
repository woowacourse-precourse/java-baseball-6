package baseball.constant.errormessage;

import baseball.constant.Constant;

public class ComputerInputError {
    public static final String COMPUTER_NUMBER_WRONG_INPUT_SIZE_MESSAGE =
            "[ERROR] 컴퓨터 숫자에 " + Constant.GAME_NUMBERS_SIZE + "개의 수가 저장되지 않았습니다.";
    public static final String COMPUTER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE = "[ERROR] 컴퓨터 숫자에 중복된 야구 번호가 존재합니다.";
    public static final String COMPUTER_NUMBER_WRONG_INPUT_RANGE_MESSAGE = "[ERROR] 컴퓨터 숫자에 1~9 사이의 수가 아닌 문자가 포함되어있습니다.";
}
