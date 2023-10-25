package baseball.util;

public class ConstantUtil {

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String STRIKE = "스트라이크";
    public static final String BOOL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String SUCCESS_MATCH_NUMBER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final Integer ALL_MATCH_NUMBER = 3;
    public static final String WRONG_INPUT = "잘못된 값을 입력했습니다. 프로그램을 종료합니다.";

    private ConstantUtil() {
        throw new IllegalStateException();
    }
}
