package baseball.view;

public class OutputView {
    public static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    public static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public void printResult(final String gameResult) {
        System.out.println(gameResult);
    }

    public void printEndGame() {
        System.out.println(END_GAME);
    }

    public static OutputView getInstance() {
        return instance;
    }
}
