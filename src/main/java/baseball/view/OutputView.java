package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void start() {
        System.out.println(START_MESSAGE);
    }
}
