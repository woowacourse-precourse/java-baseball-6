package baseball.View;

public class OutputView {
    private static final String gameStartMsg = "숫자 야구 게임을 시작합니다.";
    private static final String gameEndMsg = "숫자 야구 게임을 종료합니다.";

    public void printStartMsg() {
        System.out.println(gameStartMsg);
    }

    public void printEndMsg() {
        System.out.println(gameEndMsg);
    }

}
