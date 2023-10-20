package baseball.baseball.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }
}
