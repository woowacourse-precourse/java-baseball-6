package baseball.domain;

public class Constants {

    //GameMessages
    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String RESTART_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String COMPLETELY_EXIT_MESSAGE = "숫자 야구 게임을 종료합니다.";

    //Validation
    public static final String SHORT_OR_LONG = "입력값의 길이가 짧거나 깁니다.";
    public static final String NOT_NUMBER = "입력값이 숫자가 아닙니다.";
    public static final String ZERO_INCLUDED = "0은 사용되면 안됩니다. 수의 범위는 1~9 입니다.";
    public static final String DUPLICATE_DIGITS = "서로 다른 수로 이루어지지 않았습니다.";
    public static final String ONE_OR_TWO = "1 또는 2만 입력해야 합니다.";

    //Numbers
    public static final int NUMBER_LENGTH = 3;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 9;

    //Strings
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOT_THING = "낫싱";
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";

    //Command
    public static final String ZERO = "0";
    public static final String RESTART_COMMAND = "1";
    public static final String END_COMMAND = "2";
    public static final boolean RESTART = true;
    public static final boolean END = false;

}
