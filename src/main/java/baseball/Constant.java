package baseball;

public class Constant {
    public static String LINE_SEPARATOR = System.lineSeparator();
    public static String START_MESSAGE = "숫자 야구 게임을 시작합니다." + LINE_SEPARATOR;
    public static String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + LINE_SEPARATOR;
    public static String INPUT_RETRY_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + LINE_SEPARATOR;
    public static String INVALID_FORMAT_MESSAGE = "잘못된 형식입니다.";
    public static String INVALID_LENGTH_MESSAGE = "자릿수가 올바르지 않습니다.";
    public static String INVALID_DUPLICATE_MESSAGE = "중복된 수가 존재합니다.";
    public static String INVALID_CHOICE_MESSAGE = "1, 2만 입력할 수 있습니다.";
    public static String INVALID_BLANK_VALUE_MESSAGE = "공백은 입력할 수 없습니다.";
    public static String NUMERIC_PATTERN = "^[1-9]+$";
    public static String RETRY = "1";
    public static String EXIT = "2";
    public static String NOTHING = "낫싱";
    public static String STRIKE = "스트라이크";
    public static String BALL = "볼 ";
    public static int MAX_NUMBER_LENGTH = 3;
    public static int MIN_RANGE = 1;
    public static int MAX_RANGE = 9;
}
