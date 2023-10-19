package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
