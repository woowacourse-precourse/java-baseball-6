package baseball.util;

public class GameVariables {
    private static String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static String END_SENTENCE = "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    private static String NOTHING = "낫싱";
    private static String STRIKE = "스트라이크";
    private static String BALL = "볼";
    private static String NUMBER_PATTERN = "^(?!.*(.).*\\1)[1-9]{3}$";

    private static String ERROR_MESSAGE = "유효하지 않은 패턴입니다.\n"
            + "중복되지 않는 1부터 9까지의 3자리 숫자를 입력하세요.";


    public static String getStartSentence() { return START_SENTENCE; }
    public static String getEndSentence() { return END_SENTENCE; }
    public static String getInputSentence() { return INPUT_SENTENCE; }
    public static String getNothing() { return NOTHING; }
    public static String getStrike() { return STRIKE; }
    public static String getBall() { return BALL; }
    public static String getNumberPattern() { return NUMBER_PATTERN; }
    public static String getErrorMessage() { return ERROR_MESSAGE; }
}
