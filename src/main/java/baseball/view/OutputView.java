package baseball.view;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 :";

    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printInputNumbers() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
    }
}
