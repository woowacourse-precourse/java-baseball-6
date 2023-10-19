package baseball.view;

public class OutputView {
    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printUserInputMessage() {
        System.out.print(USER_INPUT_MESSAGE);
    }
}
