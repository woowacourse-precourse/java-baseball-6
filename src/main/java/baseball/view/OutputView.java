package baseball.view;

public class OutputView {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String NOTHING_MESSAGE = "낫싱";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }
    public void printWin() {
        System.out.println(WIN_MESSAGE);
    }

    public void printBall(int count) {
        System.out.print(count+BALL_MESSAGE);
    }
    public void printStrike(int count) {
        System.out.println(count+STRIKE_MESSAGE);
    }
    public void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

}
