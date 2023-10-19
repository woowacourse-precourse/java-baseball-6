package baseball.util;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");

    public static final String ERROR_PREFIX_MESSAGE = "[ERROR]";
    public static final String EMPTY_INPUT_SUFFIX_MESSAGE = "아무것도 입력하지 않았습니다";
    public static final String WRONG_LENGTH_SUFFIX_MESSAGE = "3개의 수로 입력하지 않았습니다";
    public static final String WRONG_CHARACTER_SUFFIX_MESSAGE = "숫자가 아닌 문자를 입력했습니다";
    public static final String DUPLICATED_NUMBER_SUFFIX_MESSAGE = "중복된 수가 존재합니다.";

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 :";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


}
