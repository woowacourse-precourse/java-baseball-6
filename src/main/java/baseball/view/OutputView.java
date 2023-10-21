package baseball.view;

public class OutputView {
    public static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    public static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public static OutputView getInstance() {
        return instance;
    }
}
