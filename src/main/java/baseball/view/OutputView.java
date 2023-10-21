package baseball.view;

public class OutputView {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String COLLECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String STRIKE_MESSAGE = "스트라이크";
    private final String BALL_MESSAGE = "볼";
    private final String NOTHING_MESSAGE = "낫싱";

    public void print_start() {
        System.out.println(START_MESSAGE);
    }

    public void print_end() {
        System.out.println(COLLECT_MESSAGE);
    }

    public void print_strike() {
        System.out.print(STRIKE_MESSAGE);
    }

    public void print_ball() {
        System.out.print(BALL_MESSAGE);
    }

    public void print_nothing() {
        System.out.println(NOTHING_MESSAGE);
    }
}
