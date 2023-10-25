package baseball.view;

public class OutputView {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_SUCCESS_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printHint(String HintMessage) {
        System.out.println(HintMessage);
    }

    public void printSuccess() {
        System.out.println(NUMBER_OF_DIGITS + GAME_SUCCESS_MESSAGE);
    }
}
