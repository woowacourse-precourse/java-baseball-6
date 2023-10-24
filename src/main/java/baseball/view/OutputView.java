package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_STOP_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameStop() {
        System.out.println(GAME_STOP_MESSAGE);
    }

    public void printRoundResult(String result) {
        System.out.println(result);
    }
}
